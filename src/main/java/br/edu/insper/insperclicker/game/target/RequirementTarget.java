package br.edu.insper.insperclicker.game.target;

import br.edu.insper.insperclicker.game.resources.common.LeveledGameResource;

public class RequirementTarget<T extends LeveledGameResource> extends Target<T>
{
    private final int requiredLevel;

    public RequirementTarget(T gameResource, int requiredLevel)
    {
        super(gameResource);
        this.requiredLevel = requiredLevel;
    }

    public int getRequiredLevel()
    {
        return requiredLevel;
    }

    public boolean isValid()
    {
        return requiredLevel == getGameResource().getLevel();
    }

    public boolean isOf(T resource)
    {
        return this.getGameResource().equals(resource);
    }

    public String getResourceName()
    {
        return getGameResource().getName();
    }

}
