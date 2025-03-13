package br.edu.insper.insperclicker.game.achievement.moneypersec;
import br.edu.insper.insperclicker.game.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.HashMap;

public class MoneyPerSecAchievementRegistry
{
    private static final HashMap<String, MoneyPerSecAchievement> achievements = new HashMap<>();


    public static HashMap<String, MoneyPerSecAchievement> generateStarterMoneyPerSecAchievements()
    {
        return achievements;
    }

    private static RequirementTarget<MoneyPerSec> createTarget(MoneyPerSec building, int level, double bonus)
    {
        return new RequirementTarget<>(building, level, bonus);
    }

    private static void addToMap(MoneyPerSecAchievement achievement)
    {
        achievements.put(achievement.getName(), achievement);
    }
}

