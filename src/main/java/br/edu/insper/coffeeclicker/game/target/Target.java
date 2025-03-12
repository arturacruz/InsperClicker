package br.edu.insper.coffeeclicker.game.target;

import br.edu.insper.coffeeclicker.game.resource.GameResource;

public class Target<T extends GameResource>
{
    private final T gameResource;
    private final double bonus;

    public Target(T resource, double bonus)
    {
        this.gameResource = resource;
        this.bonus = bonus;
    }

    public T getGameResource()
    {
        return gameResource;
    }

    public double getBonus()
    {
        return bonus;
    }
}
