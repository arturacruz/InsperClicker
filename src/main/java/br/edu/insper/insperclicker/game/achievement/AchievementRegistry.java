package br.edu.insper.insperclicker.game.achievement;

import br.edu.insper.insperclicker.game.achievement.building.BuildingAchievementRegistry;
import br.edu.insper.insperclicker.game.achievement.money.MoneyAchievementRegistry;
import br.edu.insper.insperclicker.game.achievement.moneypersec.MoneyPerSecAchievementRegistry;
import br.edu.insper.insperclicker.game.resource.LeveledGameResource;

import java.util.HashMap;

public class AchievementRegistry
{
    public static HashMap<String, Achievement<? extends LeveledGameResource>> generateStarterAchievements()
    {
        HashMap<String, Achievement<? extends LeveledGameResource>> achievements = new HashMap<>();
        achievements.putAll(MoneyAchievementRegistry.generateStarterMoneyAchievements());
        achievements.putAll(MoneyPerSecAchievementRegistry.generateStarterMoneyPerSecAchievements());
        achievements.putAll(BuildingAchievementRegistry.generateStarterBuildingAchievements());
        return achievements;
    }
}
