package br.edu.insper.insperclicker.game.resources.achievement.resource;


import br.edu.insper.insperclicker.game.resources.common.LeveledGameResource;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class AchievementResource<T extends LeveledGameResource> extends Achievement
{
    private final RequirementTarget<T> requirementTarget;
    public AchievementResource(String name, String displayName, String description, RequirementTarget<T> requirementTarget)
    {
        super(name, displayName, description, requirementTarget.getGameResource().getClass().getSimpleName());
        this.requirementTarget = requirementTarget;
    }

    @Override
    public boolean isValidForUnlock()
    {
        return requirementTarget.isValid();
    }
}
