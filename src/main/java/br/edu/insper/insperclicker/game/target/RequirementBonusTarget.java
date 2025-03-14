package br.edu.insper.insperclicker.game.target;

import br.edu.insper.insperclicker.game.resources.common.LeveledGameResource;

public class RequirementBonusTarget<T extends LeveledGameResource> extends BonusTarget<T>
{
    private final int requiredLevel;

    public RequirementBonusTarget(T gameResource, int requiredLevel, double bonus)
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
