package br.edu.insper.insperclicker.repository.models;

import br.edu.insper.insperclicker.dto.UpgradeDTO;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;
import br.edu.insper.insperclicker.game.target.RequirementBonusTarget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record UpgradeModel(
        String name,
        String displayName,
        String description,
        List<RequirementBonusTarget<Building>> targetList,
        double price,
        boolean taken,
        boolean unlocked)
{
    public static UpgradeModel from(Upgrade upgrade)
    {
        return new UpgradeModel(
                upgrade.getName(),
                upgrade.getDisplayName(),
                upgrade.getDescription(),
                upgrade.getTargetList(),
                upgrade.getPrice(),
                upgrade.isTaken(),
                upgrade.isUnlocked()
        );
    }

    public static Upgrade to(UpgradeModel upgradeModel)
    {
        return new Upgrade(
                upgradeModel.name,
                upgradeModel.displayName,
                upgradeModel.description,
                upgradeModel.targetList,
                upgradeModel.price,
                upgradeModel.taken,
                upgradeModel.unlocked
        );
    }

    public static Map<String, UpgradeModel> fromMap(Map<String, Upgrade> upgrades)
    {
        return upgrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> from(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }

    public static Map<String, Upgrade> toMap(Map<String, UpgradeModel> upgrades)
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
