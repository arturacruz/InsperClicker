package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;
import br.edu.insper.insperclicker.game.resources.building.Building;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record AchievementDTO(
        String name,
        String displayName,
        String description,
        String requirementType,
        boolean unlocked)
{
    public static AchievementDTO from(Achievement achievement)
    {
        return new AchievementDTO(
                achievement.getName(),
                achievement.getDisplayName(),
                achievement.getDescription(),
                achievement.getRequirementType(),
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
