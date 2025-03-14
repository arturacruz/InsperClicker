package br.edu.insper.insperclicker.game.resources.achievement.common;

import br.edu.insper.insperclicker.game.resources.common.GameResource;


public class Achievement extends GameResource
{
    private boolean unlocked = false;
    private final String requirementType;

    public Achievement(String name, String displayName, String description, String requirementType)
    {
        super(name, displayName, description);
        this.requirementType = requirementType;
    }

    public String getRequirementType()
    {
        return requirementType;
    }

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public void unlock()
    {
        this.unlocked = true;
    }

    public int applyBonusToStock()
    {
        if(!unlocked) return 0;
        return 4;
    }
    public boolean isValidForUnlock()
    {
        return true;
    }
}
