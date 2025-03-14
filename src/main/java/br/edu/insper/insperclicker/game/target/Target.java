package br.edu.insper.insperclicker.game.target;

import br.edu.insper.insperclicker.game.resources.common.GameResource;

public class Target<T extends GameResource>
{
    private final T gameResource;

    public Target(T resource)
    {
        this.gameResource = resource;
    }

    public T getGameResource()
    {
        return gameResource;
    }

}
