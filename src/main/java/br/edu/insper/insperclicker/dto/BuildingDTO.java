package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.resources.building.Building;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public record BuildingDTO(
        String name,
        String displayName,
        String description,
        int level,
        double price,
        double moneyPerSec
)
{
    public static BuildingDTO from(Building building)
    {
        return new BuildingDTO(
                building.getName(),
                building.getDisplayName(),
                building.getDescription(),
                building.getLevel(),
                building.getPrice(),
                building.getMoneyPerSec()
        );
    }

    public static Map<String, BuildingDTO> fromMap(Map<String, Building> buildings)
    {
        return buildings.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> from(entry.getValue()),
                        (a, b) -> a,
                        HashMap::new
                ));
    }
}
