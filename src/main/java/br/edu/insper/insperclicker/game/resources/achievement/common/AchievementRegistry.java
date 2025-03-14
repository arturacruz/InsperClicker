package br.edu.insper.insperclicker.game.resources.achievement.common;


import br.edu.insper.insperclicker.game.resources.achievement.currency.money.AchievementMoneyRegistry;
import br.edu.insper.insperclicker.game.resources.achievement.currency.moneypersec.AchievementMoneyPerSecRegistry;
import br.edu.insper.insperclicker.game.resources.achievement.currency.stock.AchievementStockRegistry;
import br.edu.insper.insperclicker.game.resources.achievement.resource.AchievementResourceRegistry;

import java.util.HashMap;

public class AchievementRegistry
{
    public static HashMap<String, Achievement> generateStarterAchievements()
    {
        HashMap<String, Achievement> achievements = new HashMap<>();
        achievements.putAll(AchievementMoneyRegistry.generateStarterMoneyAchievements());
        achievements.putAll(AchievementMoneyPerSecRegistry.generateStarterMoneyPerSecAchievements());
        achievements.putAll(AchievementStockRegistry.generateStarterStockAchievements());
        achievements.putAll(AchievementResourceRegistry.generateStarterResourceAchievements());
        return achievements;
    }
}
