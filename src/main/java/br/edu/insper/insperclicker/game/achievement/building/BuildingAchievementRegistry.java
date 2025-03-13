package br.edu.insper.insperclicker.game.achievement.building;
import br.edu.insper.insperclicker.game.building.Building;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.HashMap;

public class BuildingAchievementRegistry
{
    private static final HashMap<String, BuildingAchievement> achievements = new HashMap<>();


    public static HashMap<String, BuildingAchievement> generateStarterBuildingAchievements()
    {
        return achievements;
    }

    private static RequirementTarget<Building> createTarget(Building building, int level, double bonus)
    {
        return new RequirementTarget<>(building, level, bonus);
    }

    private static void addToMap(BuildingAchievement achievement)
    {
        achievements.put(achievement.getName(), achievement);
    }
}

