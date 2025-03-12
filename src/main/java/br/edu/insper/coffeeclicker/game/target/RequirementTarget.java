package br.edu.insper.coffeeclicker.game.target;

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

}
