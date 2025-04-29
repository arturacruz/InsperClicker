package br.edu.insper.insperclicker.repository.models;

import br.edu.insper.insperclicker.game.resources.building.Building;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record BuildingModel(
        String name,
        String displayName,
        double baseCost,
        String description,
        double baseMoneyPerSec,
        double clickSizeIncrease,
        int unlockLevel,
        int level)
{
    public static BuildingModel from(Building building) {
        return new BuildingModel(
                building.getName(),
                building.getDisplayName(),
                building.getBaseCost(),
                building.getDescription(),
                building.getBaseMoneyPerSec(),
                building.getClickSizeIncrease(),
                building.getUnlockLevel(),
                building.getLevel()
        );
    }

    public static Building to(BuildingModel buildingModel)
    {
        return new Building(
                buildingModel.name,
                buildingModel.displayName,
                buildingModel.baseCost,
                buildingModel.description,
                buildingModel.baseMoneyPerSec,
                buildingModel.clickSizeIncrease,
                buildingModel.unlockLevel,
                buildingModel.level
        );
    }

    public static Map<String, BuildingModel> fromMap(Map<String, Building> upgrades)
    {
        return upgrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> from(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }

    public static Map<String, Building> toMap(Map<String, BuildingModel> upgrades)
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
