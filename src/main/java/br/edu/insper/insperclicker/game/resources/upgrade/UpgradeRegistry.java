package br.edu.insper.insperclicker.game.resources.upgrade;
import br.edu.insper.insperclicker.game.resources.building.Building;

import br.edu.insper.insperclicker.game.resources.building.BuildingRegistry;
import br.edu.insper.insperclicker.game.target.RequirementBonusTarget;
import jakarta.validation.constraints.NotNull;

import java.util.HashMap;

public class UpgradeRegistry
{
    private final BuildingRegistry buildingRegistry;
    private final HashMap<String, Upgrade> upgrades = new HashMap<>();

    public UpgradeRegistry(@NotNull BuildingRegistry buildingRegistry)
    {
        this.buildingRegistry = buildingRegistry;

        TEST_UPGRADE = new Upgrade(
                "testUpgrade", "Test Upgrade", "A test upgrade.", 10,
                createTarget(buildingRegistry.COFFEE_MUG, 2, 0.5)
        );
    }

    public final Upgrade TEST_UPGRADE;

    public HashMap<String, Upgrade> generateStarterUpgrades()
    {
        addToMap(TEST_UPGRADE);
        return upgrades;
    }

    private RequirementBonusTarget<Building> createTarget(Building building, int level, double bonus)
    {
        return new RequirementBonusTarget<>(building, level, bonus);
    }

    private void addToMap(Upgrade upgrade)
    {
        upgrades.put(upgrade.getName(), upgrade);
    }
}
