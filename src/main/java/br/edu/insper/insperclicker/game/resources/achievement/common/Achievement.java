package br.edu.insper.insperclicker.game.resources.achievement.common;

import br.edu.insper.insperclicker.game.currency.common.Currency;
import br.edu.insper.insperclicker.game.resources.common.GameResource;

public class Achievement extends GameResource
{
    private boolean unlocked = false;
    private final String requirementType;
    private final double requirement;
    private final Currency target;

    public Achievement(String name, String displayName, String description, String requirementType, double requirement, Currency target, boolean unlocked)
    {
        super(name, displayName, description);
        this.requirementType = requirementType;
        this.requirement = requirement;
        this.target = target;
        this.unlocked = unlocked;
    }

    public Achievement(String name, String displayName, String description, String requirementType, double requirement, Currency target)
    {
        super(name, displayName, description);
        this.requirementType = requirementType;
        this.requirement = requirement;
        this.target = target;
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
        return target.getAmount() > requirement;
    }

    public double getRequirement() {
        return requirement;
    }

    public Currency getTarget()
    {
        return target;
    }
}
