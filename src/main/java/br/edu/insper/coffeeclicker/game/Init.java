package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.game.achievement.Achievement;
import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.building.BuildingCoffeeGrinder;
import br.edu.insper.coffeeclicker.game.building.BuildingCoffeeMaker;
import br.edu.insper.coffeeclicker.game.building.BuildingCoffeeMug;
import br.edu.insper.coffeeclicker.game.upgrade.Upgrade;

import java.util.HashMap;

public class Init
{
    public static void initializeBuildings()
    {
        System.out.println("Initializing buildings.");
    }

    public static HashMap<String, Building> generateStarterBuildings()
    {
        HashMap<String, Building> buildings = new HashMap<>();
        buildings.put("coffeeMug", new BuildingCoffeeMug());
        buildings.put("coffeeGrinder", new BuildingCoffeeGrinder());
        buildings.put("coffeeMaker", new BuildingCoffeeMaker());
        return buildings;
    }

    public static HashMap<String, Upgrade> generateStarterUpgrades()
    {
        return new HashMap<>();
    }

    public static HashMap<String, Achievement> generateStarterAchievements()
    {
        return new HashMap<>();
    }

    public static void initializeUpgrades()
    {
        System.out.println("Initializing upgrades.");
    }

    public static void initializeSoulUpgrades()
    {
        System.out.println("Initializing soul upgrades.");
    }

    public static void initializePlayer()
    {
        System.out.println("Initializing player.");
    }

    public static void initializeAchievements()
    {
        System.out.println("Initializing achievements.");
    }


}
