package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.exception.GameResourceNotFoundException;
import br.edu.insper.coffeeclicker.game.achievement.Achievement;
import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.building.BuildingRegistry;
import br.edu.insper.coffeeclicker.game.target.RequirementTarget;
import br.edu.insper.coffeeclicker.game.upgrade.Upgrade;
import br.edu.insper.coffeeclicker.game.upgrade.UpgradeRegistry;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ascension
{
    private double coffees = 0;
    private int milk = 0;
    private double clickSize = 1;
    private double coffeePerSec = 0;
    private int currentUnlockLevel = 1;
    private float buildingDiscountBonus = 0;
    private float buildingProductionBonus = 0;
    private final HashMap<String, Building> buildings = BuildingRegistry.generateStarterBuildings();
    private final HashMap<String, Upgrade> upgrades = UpgradeRegistry.generateStarterUpgrades();
    private final HashMap<String, Achievement> achievements = Init.generateStarterAchievements();

    public void click(int clickAmount)
    {
        coffees += clickSize * clickAmount;
    }
    public void doCoffeePerSec(LocalDateTime lastRequest)
    {
        LocalDateTime currentRequest = LocalDateTime.now();
        double milliseconds = ChronoUnit.MILLIS.between(lastRequest, currentRequest);
        coffees += coffeePerSec * (milliseconds / 1000);
    }

    public double getCoffees()
    {
        return coffees;
    }

    public void addToCoffees(double amount) { this.coffees += amount; }

    public void subtractFromCoffees(double amount) { this.coffees -= amount; }

    public void setCoffees(double coffees)
    {
        this.coffees = coffees;
    }

    public int getMilk()
    {
        return milk;
    }

    public void setMilk(int milk)
    {
        this.milk = milk;
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

    public double getCoffeePerSec()
    {
        return coffeePerSec;
    }

    public void setCoffeePerSec(double coffeePerSec)
    {
        this.coffeePerSec = coffeePerSec;
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
     * {@link Ascension#getBuildingProductionBonus()}
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
     * {@link Ascension#getBuildingDiscountBonus()}
     */
    public void setBuildingDiscountBonus(float buildingDiscountBonus) {
        this.buildingDiscountBonus = buildingDiscountBonus;
    }

    public void updateCoffeePerSec()
    {
        this.coffeePerSec = this.buildings
                .values()
                .stream()
                .filter(building -> building.getLevel() >= 1)
                .mapToDouble(Building::getCoffeePerSec).sum();
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

    public void buyBuilding(String name, int amount) throws GameResourceNotFoundException
    {
        if(!buildingExists(name))
        {
            throw new GameResourceNotFoundException(name, "Building");
        }

        Building building = getBuilding(name);
        double totalPrice = building.getPrice() * amount;
        if(coffees < totalPrice) return;

        if(building.getUnlockLevel() == currentUnlockLevel) incrementUnlockLevel(building.getUnlockLevel());
        building.buy(amount);
        unlockUpgrades(building);
        subtractFromCoffees(totalPrice);
        updateCoffeePerSec();

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

    public void buyUpgrade(String upgradeName, int amount)
    {
        if(!this.upgrades.containsKey(upgradeName))
        {
            System.err.println("Upgrade with name {" + upgradeName + "} not found");
            return;
        }
        // getUpgrade(upgradeName).addToLevel(amount);
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

    public void unlockUpgrades(Building building)
    {
        // Get all upgrades that have this building as a requirement
        List<Map.Entry<String, Upgrade>> newUpgrades = upgrades.entrySet().stream()
                .filter(entry -> entry.getValue().anyResourceIs(building))
                .toList();

        // Filter through those upgrades to see if all buildings are at the desired levels
        newUpgrades.stream()
                .filter(entry -> {
                    Upgrade upgrade = entry.getValue();
                    for(RequirementTarget<Building> target : upgrade.getTargetList())
                    {
                        // Get building from our game instance
                        Building bd = getBuilding(target.getResourceName());
                        if (bd == null) return false;

                        // if it's not at the required level, or is null, remove it from our filter
                        if(!target.hasRequiredLevel(bd.getLevel())) return false;
                    }
                    return true;
                })
                // unlock
                .forEach(entry -> entry.getValue().unlock());
    }

    public HashMap<String, Achievement> getAchievements() {
        return achievements;
    }
}
