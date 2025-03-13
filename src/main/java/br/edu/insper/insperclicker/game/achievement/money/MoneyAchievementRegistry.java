package br.edu.insper.insperclicker.game.achievement.money;
import br.edu.insper.insperclicker.game.money.Money;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.HashMap;

public class MoneyAchievementRegistry
{
    private static final HashMap<String, MoneyAchievement> achievements = new HashMap<>();


    public static HashMap<String, MoneyAchievement> generateStarterMoneyAchievements()
    {
        return achievements;
    }

    private static RequirementTarget<Money> createTarget(Money building, int level, double bonus)
    {
        return new RequirementTarget<>(building, level, bonus);
    }

    private static void addToMap(MoneyAchievement achievement)
    {
        achievements.put(achievement.getName(), achievement);
    }
}

