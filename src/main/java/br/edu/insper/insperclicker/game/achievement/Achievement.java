package br.edu.insper.insperclicker.game.achievement;

import br.edu.insper.insperclicker.game.resource.GameResource;

public class Achievement extends GameResource
{
    private boolean unlocked = false;

    public Achievement(String name, String displayName, String description)
    {
        super(name, displayName, description);
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
