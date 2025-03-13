package br.edu.insper.insperclicker.game.achievement.building;

import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.building.Building;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class BuildingAchievement extends Achievement<Building>
{
    public BuildingAchievement(String name, String displayName, String description, RequirementTarget<Building>... targetResources)
    {
        super(name, displayName, description, targetResources);
    }
}
