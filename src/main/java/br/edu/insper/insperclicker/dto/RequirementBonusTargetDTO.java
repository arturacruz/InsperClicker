package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resources.common.LeveledGameResource;
import br.edu.insper.insperclicker.game.target.RequirementBonusTarget;

public record RequirementBonusTargetDTO(String name, int requiredLevel, double bonus)
{
    public static <T extends LeveledGameResource> RequirementBonusTargetDTO from(RequirementBonusTarget<T> requirementBonusTarget)
    {
        return new RequirementBonusTargetDTO(
                requirementBonusTarget.getResourceName(),
                requirementBonusTarget.getRequiredLevel(),
                requirementBonusTarget.getBonus());
    }
}
