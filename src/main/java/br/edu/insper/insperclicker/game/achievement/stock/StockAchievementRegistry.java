package br.edu.insper.insperclicker.game.achievement.stock;
import br.edu.insper.insperclicker.game.crypto.Stock;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.HashMap;

public class StockAchievementRegistry
{
    private static final HashMap<String, StockAchievement> achievements = new HashMap<>();


    public static HashMap<String, StockAchievement> generateStarterCryptoAchievements()
    {
        return achievements;
    }

    private static RequirementTarget<Stock> createTarget(Stock building, int level, double bonus)
    {
        return new RequirementTarget<>(building, level, bonus);
    }

    private static void addToMap(StockAchievement achievement)
    {
        achievements.put(achievement.getName(), achievement);
    }
}

