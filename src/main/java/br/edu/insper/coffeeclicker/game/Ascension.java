package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.game.achievement.Achievement;
import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.upgrade.Upgrade;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Ascension
{
    private double coffees = 0;
    private int milk = 0;
    private double clickSize = 1;
    private double coffeePerSec = 0;
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
        if(!this.buildings.containsKey(buildingName))
        {
            System.err.println("Building with name {" + buildingName + "} not found");
            return null;
        }
        return this.buildings.get(buildingName);
    }

    public void buyBuilding(String buildingName, int amount)
    {
        if(!this.buildings.containsKey(buildingName))
        {
            System.err.println("Building with name {" + buildingName + "} not found");
            return;
        }

        Building building = getBuilding(buildingName);
        double totalPrice = building.getPrice() * amount;
        if(getCoffees() < totalPrice) return;

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
}
