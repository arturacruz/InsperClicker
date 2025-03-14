package br.edu.insper.insperclicker.game.resources.achievement.currency.money;

import br.edu.insper.insperclicker.game.resources.building.Building;

import java.util.HashMap;

public class AchievementMoneyRegistry
{
    private static final HashMap<String, AchievementMoney> achievements = new HashMap<>();

    private static final AchievementMoney A100 = new AchievementMoney("A100", "A100", "100 MONEY", 100);
    public static HashMap<String, AchievementMoney> generateStarterMoneyAchievements()
    {
        addToMap(A100);
        return achievements;
    }
    private static void addToMap(AchievementMoney achievementMoney)
    {
        achievements.put(achievementMoney.getName(), achievementMoney);
    }
}
