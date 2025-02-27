package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.game.achievement.Achievement;
import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.upgrade.Upgrade;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Ascension
{
    private double coffees = 0;
    private int milk = 0;
    private double clickSize = 1;
    private double coffeePerSec = 0.1;
    private final ArrayList<Building> buildings = new ArrayList<>();
    private final ArrayList<Upgrade> upgrades = new ArrayList<>();
    private final ArrayList<Achievement> achievements = new ArrayList<>();

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

    public ArrayList<Building> getBuildings()
    {
        return buildings;
    }

    public ArrayList<Upgrade> getUpgrades()
    {
        return upgrades;
    }

    public ArrayList<Achievement> getAchievements()
    {
        return achievements;
    }

    public void addBuilding(Building building)
    {
        if(building == null) return;
        this.buildings.add(building);
    }

    public void addUpgrade(Upgrade upgrade)
    {
        if(upgrade == null) return;
        this.upgrades.add(upgrade);
    }

    public void addAchievement(Achievement achievement)
    {
        if(achievement == null) return;
        this.achievements.add(achievement);
    }
}
