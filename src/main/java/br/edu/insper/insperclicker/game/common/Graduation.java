package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.exception.GameResourceAlreadyOwnedException;
import br.edu.insper.insperclicker.exception.GameResourceNotFoundException;
import br.edu.insper.insperclicker.exception.GameResourceNotUnlockedException;
import br.edu.insper.insperclicker.exception.InsufficientFundsException;
import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;
import br.edu.insper.insperclicker.game.resources.achievement.common.AchievementRegistry;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.game.resources.building.BuildingRegistry;
import br.edu.insper.insperclicker.game.currency.stock.Stock;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;
import br.edu.insper.insperclicker.game.resources.upgrade.UpgradeRegistry;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Graduation
{
    private final Money money;
    private final MoneyPerSec moneyPerSec;
    private final Stock stock;
    private double clickSize;
    private int currentUnlockLevel;
    private double buildingDiscountBonus;
    private double buildingProductionBonus;
    private final HashMap<String, Building> buildings;
    private final HashMap<String, Upgrade> upgrades;
    private final HashMap<String, Achievement> achievements;

    public Graduation(
            Money money,
            MoneyPerSec moneyPerSec,
            Stock stock,
            HashMap<String, Building> buildings,
            HashMap<String, Upgrade> upgrades,
            HashMap<String, Achievement> achievements,
            double clickSize,
            int currentUnlockLevel,
            double buildingDiscountBonus,
            double buildingProductionBonus)
    {
        this.money = money;
        this.moneyPerSec = moneyPerSec;
        this.stock = stock;
        this.buildings = buildings;
        this.upgrades = upgrades;
        this.achievements = achievements;
        this.clickSize = clickSize;
        this.currentUnlockLevel = currentUnlockLevel;
        this.buildingDiscountBonus = buildingDiscountBonus;
        this.buildingProductionBonus = buildingProductionBonus;
    }

    public Graduation()
    {
        Registries registries = new Registries();
        money = registries.initializeMoney();
        moneyPerSec = registries.initializeMoneyPerSec();
        stock = registries.initializeStock();
        buildings = registries.initializeBuildings();
        upgrades = registries.initializeUpgrades();
        achievements = registries.initializeAchievements();
        clickSize = 1;
        currentUnlockLevel = 1;
        buildingDiscountBonus = 0;
        buildingProductionBonus = 0;
    }

    public void click(int clickAmount)
    {
        money.addToMoney(clickSize * clickAmount);
    }

    public void doMoneyPerSec(LocalDateTime lastRequest)
    {
        LocalDateTime currentRequest = LocalDateTime.now();
        double milliseconds = ChronoUnit.MILLIS.between(lastRequest, currentRequest);
        money.addToMoney(getMoneyPerSec() * (milliseconds / 1000));
        System.out.println("do money");
    }

    public double getMoney()
    {
        return money.getAmount();
    }

    public void subtractFromMoney(double amount) { this.money.subtractFromMoney(amount); }

    public double getClickSize()
    {
        return clickSize;
    }

    public double getStock()
    {
        return stock.getAmount();
    }

    public void setCurrentUnlockLevel(int unlockLevel)
    {
        this.currentUnlockLevel = unlockLevel;
    }

    public void incrementUnlockLevel(int currentUnlockLevel)
    {
        this.currentUnlockLevel++;
    }

    public int getCurrentUnlockLevel()
    {
        return this.currentUnlockLevel;
    }

    public void setClickSize(double clickSize)
    {
        this.clickSize = clickSize;
    }

    public double getMoneyPerSec()
    {
        return moneyPerSec.getAmount() + moneyPerSec.getAmount() * (stock.getAmount() / 80.0);
    }

    /**
     * Number in percentage, from 0 to 1
     * 0.05 would apply a 5% bonus, subtracting from 1
     */
    public double getBuildingProductionBonus()
    {
        return buildingProductionBonus;
    }

    /**
     * {@link Graduation#getBuildingProductionBonus()}
     */
    public void setBuildingProductionBonus(float buildingProductionBonus) {
        this.buildingProductionBonus = buildingProductionBonus;
    }

    /**
     * Number in percentage, from 0 to 1
     * 0.05 would apply a 5% bonus, subtracting from 1
     */
    public double getBuildingDiscountBonus() {
        return buildingDiscountBonus;
    }

    /**
     * {@link Graduation#getBuildingDiscountBonus()}
     */
    public void setBuildingDiscountBonus(float buildingDiscountBonus)
    {
        this.buildingDiscountBonus = buildingDiscountBonus;
    }

    public void updateMoneyPerSec()
    {
        this.moneyPerSec.setAmount(
                this.buildings
                .values()
                .stream()
                .filter(building -> building.getLevel() >= 1)
                .mapToDouble(Building::getMoneyPerSec).sum());
    }

    /**
     * This method fetches a building.
     *
     * @return the building if available, or null if not found.
     */
    public Building getBuilding(String buildingName)
    {
        if(!buildingExists(buildingName))
        {
            System.err.println("Building with name {" + buildingName + "} not found");
            return null;
        }
        return this.buildings.get(buildingName);
    }

    public boolean buildingExists(String name)
    {
        return this.buildings.containsKey(name);
    }

    public void buyBuilding(String name, int amount) throws GameResourceNotFoundException,
                                                            InsufficientFundsException,
                                                            GameResourceNotUnlockedException
    {
        if(!buildingExists(name))
        {
            throw new GameResourceNotFoundException(name, "Building");
        }

        Building building = getBuilding(name);
        if(building.getUnlockLevel() > currentUnlockLevel)
        {
            throw new GameResourceNotUnlockedException(name, "Building");
        }

        double totalPrice = building.getBuyPrice(amount);
        if(money.getAmount() < totalPrice)
        {
            throw new InsufficientFundsException(name, "Building", totalPrice, money.getAmount());
        }


        if(building.getUnlockLevel() == currentUnlockLevel) incrementUnlockLevel(building.getUnlockLevel());
        building.buy(amount);
        unlockUpgrades();
        subtractFromMoney(totalPrice);
        updateMoneyPerSec();

    }

    public Upgrade getUpgrade(String upgradeName)
    {
        if(!this.upgrades.containsKey(upgradeName))
        {
            System.err.println("Upgrade with name {" + upgradeName + "} not found");
            return null;
        }
        return this.upgrades.get(upgradeName);
    }

    public void buyUpgrade(String name) throws GameResourceNotFoundException,
                                                GameResourceAlreadyOwnedException,
                                                GameResourceNotUnlockedException,
                                                InsufficientFundsException
    {
        if(!upgradeExists(name))
        {
            throw new GameResourceNotFoundException(name, "Upgrade");
        }

        Upgrade upgrade = getUpgrade(name);
        if(!upgrade.isUnlocked())
        {
            throw new GameResourceNotUnlockedException(name, "Upgrade");
        }
        if(upgrade.isTaken())
        {
            throw new GameResourceAlreadyOwnedException(name, "Upgrade");
        }

        double price = upgrade.getPrice();
        if(money.getAmount() < price)
        {
            throw new InsufficientFundsException(name, "Upgrade", price, money.getAmount());
        }

        upgrade.setTaken(true);
        subtractFromMoney(price);
        updateBuildingUpgradeBonus();
        updateBuildingBonuses();
        updateMoneyPerSec();
    }

    public boolean upgradeExists(String name)
    {
        return this.upgrades.containsKey(name);
    }

    public void updateBuildingUpgradeBonus() throws GameResourceNotFoundException
    {
        buildings.values()
                .forEach(building -> building.setUpgradeProductionBonus(0));

        upgrades.values()
                .forEach(Upgrade::applyBonuses);
    }


    public Achievement getAchievement(String achievementName)
    {
        if(!this.achievements.containsKey(achievementName))
        {
            System.err.println("Achievement with name {" + achievementName + "} not found");
            return null;
        }
        return this.achievements.get(achievementName);
    }

    public void buyAchievement(String achievementName, int amount)
    {
        if(!this.achievements.containsKey(achievementName))
        {
            System.err.println("Achievement with name {" + achievementName + "} not found");
            return;
        }
        // getAchievement(achievementName).addToLevel(amount);
    }

    public Map<String, Building> getBuildings()
    {
        return buildings
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().getUnlockLevel() <= currentUnlockLevel)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public HashMap<String, Building> getUnfilteredBuildings()
    {
        return buildings;
    }

    public void updateRunSoulValues(Player player)
    {
        buildingDiscountBonus = player.getBuildingDiscountBonus();
        buildingProductionBonus = player.getBuildingProductionBonus();
        updateBuildingBonuses();
    }

    public void updateBuildingBonuses()
    {
        this.buildings
                .values()
                .forEach(building -> building.updateBonusValues(this));
    }


    public Map<String, Upgrade> getUpgrades()
    {
        return upgrades
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().isUnlocked())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public HashMap<String, Upgrade> getUnfilteredUpgrades()
    {
        return upgrades;
    }

    public void unlockUpgrades()
    {
        upgrades.values().stream()
                .filter(Upgrade::isValidForUnlock)
                .forEach(Upgrade::unlock);
    }

    public void unlockAchievements()
    {
        achievements.values().stream()
                .filter(Achievement::isValidForUnlock)
                .forEach(Achievement::unlock);
    }

    public void updateAchievementStockLevel() throws GameResourceNotFoundException
    {
        stock.setAmount(0);
        int stockLevel = achievements.values().stream()
                .filter(Achievement::isUnlocked)
                .mapToInt(Achievement::applyBonusToStock).sum();
        stock.setAmount(stockLevel);
    }

    public void updateClickSize()
    {
        setClickSize(1);
        double size = buildings.values().stream()
                .filter(bd -> bd.getLevel() > 0 && bd.getEffectiveClickSizeIncrease() > 0)
                .mapToDouble(Building::getEffectiveClickSizeIncrease).sum();
        setClickSize(getClickSize() + size);

    }

    public HashMap<String, Achievement> getAchievements()
    {
        return achievements;
    }

    public void doPassiveActions(LocalDateTime lastRequest)
    {
        doMoneyPerSec(lastRequest);
        unlockAchievements();
        updateAchievementStockLevel();
    }
}
