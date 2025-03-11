package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.exception.GameResourceNotFoundException;
import br.edu.insper.coffeeclicker.game.achievement.Achievement;
import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.upgrade.Upgrade;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.NameNotFoundException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
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
    private final HashMap<String, Building> buildings = Init.generateStarterBuildings();
    private final HashMap<String, Upgrade> upgrades = Init.generateStarterUpgrades();
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

        if(building.getUnlockLevel() == currentUnlockLevel) setCurrentUnlockLevel(building.getUnlockLevel() + 1);
        building.buy(amount);
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
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
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


    public HashMap<String, Upgrade> getUpgrades() {
        return upgrades;
    }

    public HashMap<String, Achievement> getAchievements() {
        return achievements;
    }
}
