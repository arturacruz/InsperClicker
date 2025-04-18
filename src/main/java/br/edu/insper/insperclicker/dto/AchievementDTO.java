package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.currency.common.Currency;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record AchievementDTO(
        String name,
        String displayName,
        String description,
        String requirementType,
        double requirement,
        Currency target,
        boolean unlocked)
{

    public static AchievementDTO from(Achievement achievement)
    {
        return new AchievementDTO(
                achievement.getName(),
                achievement.getDisplayName(),
                achievement.getDescription(),
                achievement.getRequirementType(),
                achievement.getRequirement(),
                achievement.getTarget(),
                achievement.isUnlocked()
        );
    }

    public static Map<String, AchievementDTO> fromMap(Map<String, Achievement> achievements)
    {
        return achievements.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> from(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }
}
