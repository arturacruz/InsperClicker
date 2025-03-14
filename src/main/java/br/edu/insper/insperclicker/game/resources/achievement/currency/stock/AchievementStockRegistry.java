package br.edu.insper.insperclicker.game.resources.achievement.currency.stock;

import java.util.HashMap;

public class AchievementStockRegistry
{
    private static final HashMap<String, AchievementStock> achievements = new HashMap<>();

    public static HashMap<String, AchievementStock> generateStarterStockAchievements()
    {

        return achievements;
    }
    private static void addToMap(AchievementStock achievementStock)
    {
        achievements.put(achievementStock.getName(), achievementStock);
    }
}
