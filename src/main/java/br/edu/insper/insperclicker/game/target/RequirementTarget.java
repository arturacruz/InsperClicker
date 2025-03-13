package br.edu.insper.insperclicker.game.target;

import br.edu.insper.insperclicker.game.resource.LeveledGameResource;

public class RequirementTarget<T extends LeveledGameResource> extends Target<T>
{
    private final int requiredLevel;

    public RequirementTarget(T gameResource, int requiredLevel, double bonus)
    {
        super(gameResource, bonus);
        this.requiredLevel = requiredLevel;
    }

    public int getRequiredLevel()
    {
        return requiredLevel;
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
