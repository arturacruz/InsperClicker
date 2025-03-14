package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resources.common.LeveledGameResource;
import br.edu.insper.insperclicker.game.target.RequirementBonusTarget;

public record RequirementTargetDTO(String name, int requiredLevel, double bonus)
{
    public static <T extends LeveledGameResource> RequirementTargetDTO from(RequirementBonusTarget<T> requirementBonusTarget)
    {
        return new RequirementTargetDTO(
                requirementBonusTarget.getResourceName(),
                requirementBonusTarget.getRequiredLevel(),
                requirementBonusTarget.getBonus());
    }
}
