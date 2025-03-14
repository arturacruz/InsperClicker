package br.edu.insper.insperclicker.game.target;

import br.edu.insper.insperclicker.game.resources.common.GameResource;

public class BonusTarget<T extends GameResource> extends Target<T>
{
    private final double bonus;

    public BonusTarget(T resource, double bonus)
    {
        super(resource);
        this.bonus = bonus;
    }


    public double getBonus()
    {
        return bonus;
    }
}
