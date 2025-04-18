package br.edu.insper.insperclicker.game.resources.achievement.common;


import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.resources.achievement.currency.money.AchievementMoneyRegistry;
import br.edu.insper.insperclicker.game.resources.achievement.currency.moneypersec.AchievementMoneyPerSecRegistry;
import br.edu.insper.insperclicker.game.resources.achievement.currency.stock.AchievementStockRegistry;

import java.util.HashMap;

public class AchievementRegistry
{
    private final AchievementMoneyRegistry achievementMoneyRegistry;
    private final AchievementMoneyPerSecRegistry achievementMoneyPerSecRegistry = new AchievementMoneyPerSecRegistry();
    private final AchievementStockRegistry achievementStockRegistry = new AchievementStockRegistry();

    public AchievementRegistry(CurrencyRegistry currencyRegistry)
    {
        achievementMoneyRegistry = new AchievementMoneyRegistry(currencyRegistry.MONEY);
    }
    public HashMap<String, Achievement> generateStarterAchievements()
    {
        HashMap<String, Achievement> achievements = new HashMap<>();
        achievements.putAll(achievementMoneyRegistry.generateStarterMoneyAchievements());
        achievements.putAll(achievementMoneyPerSecRegistry.generateStarterMoneyPerSecAchievements());
        achievements.putAll(achievementStockRegistry.generateStarterStockAchievements());
        return achievements;
    }
}
