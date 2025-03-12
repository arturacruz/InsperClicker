package br.edu.insper.coffeeclicker.game.target;

import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.resource.GameResource;
import jakarta.annotation.Resource;

public class RequirementTarget<T extends GameResource> extends Target<T>
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

    public boolean hasRequiredLevel(int requiredLevel)
    {
        return this.requiredLevel == requiredLevel;
    }

    public String getResourceName()
    {
        return getGameResource().getName();
    }



}
