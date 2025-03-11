package br.edu.insper.coffeeclicker.game.achievement;

import br.edu.insper.coffeeclicker.game.resource.GameResource;

public class Achievement extends GameResource
{
    private boolean unlocked = false;

    public Achievement(String displayName, String name, String description)
    {
        super(displayName, name, description);
    }

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked)
    {
        this.unlocked = unlocked;
    }
}
