package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resource.LeveledGameResource;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public record RequirementTargetDTO(String name, int requiredLevel, double bonus)
{
    public static <T extends LeveledGameResource> RequirementTargetDTO from(RequirementTarget<T> requirementTarget)
    {
        return new RequirementTargetDTO(
                requirementTarget.getResourceName(),
                requirementTarget.getRequiredLevel(),
                requirementTarget.getBonus());
    }
}
