package br.edu.insper.insperclicker.game.resources.achievement.currency.stock;

import java.util.HashMap;

public class AchievementStockRegistry
{
    private final HashMap<String, AchievementStock> achievements = new HashMap<>();

    public HashMap<String, AchievementStock> generateStarterStockAchievements()
    {

        return achievements;
    }
    private void addToMap(AchievementStock achievementStock)
    {
        achievements.put(achievementStock.getName(), achievementStock);
    }
}
