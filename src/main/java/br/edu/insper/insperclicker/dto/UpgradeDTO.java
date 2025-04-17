package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record UpgradeDTO(
        String name,
        String displayName,
        String description,
        double price,
        boolean taken,
        boolean unlocked,
        List<RequirementBonusTargetDTO> targetList
)
{
    public static UpgradeDTO from(Upgrade upgrade)
    {
        return new UpgradeDTO(
                upgrade.getName(),
                upgrade.getDisplayName(),
                upgrade.getDescription(),
                upgrade.getPrice(),
                upgrade.isTaken(),
                upgrade.isUnlocked(),
                upgrade.getTargetList()
        );
    }

    public static Map<String, UpgradeDTO> fromMap(Map<String, Upgrade> upgrades)
    {
        return upgrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> from(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }
}
