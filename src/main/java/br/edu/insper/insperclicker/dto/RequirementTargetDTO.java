package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resource.GameResource;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class RequirementTargetDTO
{
    private final String name;
    private final int requiredLevel;
    private final double bonus;
    public RequirementTargetDTO(String name, int requiredLevel, double bonus)
    {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public double getBonus() {
        return bonus;
    }

    public static <T extends GameResource> RequirementTargetDTO from(RequirementTarget<T> requirementTarget)
    {
        return new RequirementTargetDTO(
                requirementTarget.getResourceName(),
                requirementTarget.getRequiredLevel(),
                requirementTarget.getBonus());
    }
}
