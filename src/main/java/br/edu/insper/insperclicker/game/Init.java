package br.edu.insper.insperclicker.game;

import br.edu.insper.insperclicker.game.achievement.Achievement;

import java.util.HashMap;

public class Init
{
    public static void initializeBuildings()
    {
        System.out.println("Initializing buildings.");
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
