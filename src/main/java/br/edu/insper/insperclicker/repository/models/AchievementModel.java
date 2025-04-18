package br.edu.insper.insperclicker.repository.models;

import br.edu.insper.insperclicker.game.currency.common.Currency;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record AchievementModel(
        String name,
        String displayName,
        String description,
        String requirementType,
        double requirement,
        Currency target,
        boolean unlocked)
{
    public static AchievementModel from(Achievement achievement)
    {
        return new AchievementModel(
                achievement.getName(),
                achievement.getDisplayName(),
                achievement.getDescription(),
                achievement.getRequirementType(),
                achievement.getRequirement(),
                achievement.getTarget(),
                achievement.isUnlocked()
        );
    }

    public static Achievement to(AchievementModel achievementModel)
    {
        return new Achievement(
                achievementModel.name,
                achievementModel.displayName,
                achievementModel.description,
                achievementModel.requirementType,
                achievementModel.requirement,
                achievementModel.target,
                achievementModel.unlocked
        );
    }

    public static Map<String, AchievementModel> fromMap(Map<String, Achievement> upgrades)
    {
        return upgrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> from(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }

    public static Map<String, Achievement> toMap(Map<String, AchievementModel> upgrades)
    {
        return upgrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> to(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }
}
