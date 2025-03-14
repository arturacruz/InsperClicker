package br.edu.insper.insperclicker.game.resources.achievement.resource;

import java.util.HashMap;

public class AchievementResourceRegistry
{
    private static final HashMap<String, AchievementResource<?>> achievements = new HashMap<>();

    public static HashMap<String, AchievementResource<?>> generateStarterResourceAchievements()
    {

        return achievements;
    }
    private static void addToMap(AchievementResource<?> achievementResource)
    {
        achievements.put(achievementResource.getName(), achievementResource);
    }
}
