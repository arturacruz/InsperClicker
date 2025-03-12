package br.edu.insper.insperclicker.game.target;

import br.edu.insper.insperclicker.game.resource.GameResource;

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
