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

        REAL_MUG = new Upgrade(
                "realMug", "Real Mug", "A devalued mug.", 10,
                createTarget(buildingRegistry.MONEY_MUG, 2, 0.25)
        );
        EURO_MUG = new Upgrade(
                "euroMug", "Euro Mug", "A socialist mug.", 100,
                createTarget(buildingRegistry.MONEY_MUG, 10, 0.5)
        );

        COIN_GRINDER = new Upgrade(
                "coinGrinder", "Coin Grinder", "Counting pennies.", 20,
                createTarget(buildingRegistry.MONEY_GRINDER, 2, 0.25)
        );
        GOLD_GRINDER = new Upgrade(
                "goldGrinder", "Gold Grinder", "A 'stable' economy.", 120,
                createTarget(buildingRegistry.MONEY_GRINDER, 10, 0.5)
        );
    }

    public final Upgrade REAL_MUG;
    public final Upgrade EURO_MUG;

    public final Upgrade COIN_GRINDER;
    public final Upgrade GOLD_GRINDER;

    public HashMap<String, Upgrade> generateStarterUpgrades()
    {
        addToMap(REAL_MUG);
        addToMap(EURO_MUG);
        addToMap(COIN_GRINDER);
        addToMap(GOLD_GRINDER);
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
