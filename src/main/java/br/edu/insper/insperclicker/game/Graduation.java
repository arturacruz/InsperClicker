package br.edu.insper.insperclicker.game;

import br.edu.insper.insperclicker.exception.GameResourceAlreadyOwnedException;
import br.edu.insper.insperclicker.exception.GameResourceNotFoundException;
import br.edu.insper.insperclicker.exception.GameResourceNotUnlockedException;
import br.edu.insper.insperclicker.exception.InsufficientFundsException;
import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.achievement.AchievementRegistry;
import br.edu.insper.insperclicker.game.achievement.money.MoneyAchievement;
import br.edu.insper.insperclicker.game.building.Building;
import br.edu.insper.insperclicker.game.building.BuildingRegistry;
import br.edu.insper.insperclicker.game.crypto.Stock;
import br.edu.insper.insperclicker.game.crypto.StockRegistry;
import br.edu.insper.insperclicker.game.money.Money;
import br.edu.insper.insperclicker.game.resource.LeveledGameResource;
import br.edu.insper.insperclicker.game.upgrade.Upgrade;
import br.edu.insper.insperclicker.game.upgrade.UpgradeRegistry;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Graduation
{
    private double money = 0;
    private Money moneyInstance = new Money();
    private double clickSize = 1;
    private double moneyPerSec = 0;
    private int currentUnlockLevel = 1;
    private float buildingDiscountBonus = 0;
    private float buildingProductionBonus = 0;
    private final HashMap<String, Building> buildings = BuildingRegistry.generateStarterBuildings();
    private final HashMap<String, Upgrade> upgrades = UpgradeRegistry.generateStarterUpgrades();
    private final HashMap<String, Achievement<? extends LeveledGameResource>> achievements = AchievementRegistry.generateStarterAchievements();

    private final Stock stock = StockRegistry.create();

    public void click(int clickAmount)
    {
        money += clickSize * clickAmount;
    }
    public void doMoneyPerSec(LocalDateTime lastRequest)
    {
        LocalDateTime currentRequest = LocalDateTime.now();
        double milliseconds = ChronoUnit.MILLIS.between(lastRequest, currentRequest);
        money += moneyPerSec * (milliseconds / 1000);
    }

    public double getMoney()
    {
        return money;
    }

    public void addToMoney(double amount) { this.money += amount; }

    public void subtractFromMoney(double amount) { this.money -= amount; }

    public void setMoney(double money)
    {
        this.money = money;
    }

    public double getClickSize()
    {
        return clickSize;
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
        return moneyPerSec;
    }

    public void setMoneyPerSec(double moneyPerSec)
    {
        this.moneyPerSec = moneyPerSec;
    }

    /**
     * Number in percentage, from 0 to 1
     * 0.05 would apply a 5% bonus, subtracting from 1
     */
    public float getBuildingProductionBonus()
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
    public float getBuildingDiscountBonus() {
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
        this.moneyPerSec = this.buildings
                .values()
                .stream()
                .filter(building -> building.getLevel() >= 1)
                .mapToDouble(Building::getMoneyPerSec).sum();
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
        if(money < totalPrice)
        {
            throw new InsufficientFundsException(name, "Building", totalPrice, money);
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
        if(money < price)
        {
            throw new InsufficientFundsException(name, "Upgrade", price, money);
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


    public Achievement<?> getAchievement(String achievementName)
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
        stock.setLevel(0);
        int stockLevel = achievements.values().stream()
                .filter(Achievement::isUnlocked)
                .mapToInt(Achievement::applyBonusToStock).sum();
        stock.setLevel(stockLevel);
    }

    public HashMap<String, Achievement<? extends LeveledGameResource>> getAchievements()
    {
        return achievements;
    }

    public void doPassiveActions(LocalDateTime lastRequest)
    {
        doMoneyPerSec(lastRequest);
        moneyInstance.setLevel((int) money);
        unlockAchievements();
        updateAchievementStockLevel();
    }
}
