package br.edu.insper.insperclicker.game.resources.achievement.resource;

import java.util.HashMap;

public class AchievementResourceRegistry
{
    private final HashMap<String, AchievementResource<?>> achievements = new HashMap<>();

    public HashMap<String, AchievementResource<?>> generateStarterResourceAchievements()
    {

        return achievements;
    }
    private void addToMap(AchievementResource<?> achievementResource)
    {
        achievements.put(achievementResource.getName(), achievementResource);
    }
}
