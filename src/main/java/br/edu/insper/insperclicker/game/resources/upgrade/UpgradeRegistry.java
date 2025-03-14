package br.edu.insper.insperclicker.game.resources.upgrade;
import br.edu.insper.insperclicker.game.resources.building.Building;
import static br.edu.insper.insperclicker.game.resources.building.BuildingRegistry.COFFEE_MUG;
import br.edu.insper.insperclicker.game.target.RequirementBonusTarget;

import java.util.HashMap;

public class UpgradeRegistry
{
    private static final HashMap<String, Upgrade> upgrades = new HashMap<>();

    public static final Upgrade TEST_UPGRADE = new Upgrade(
            "testUpgrade", "Test Upgrade", "A test upgrade.", 10,
            createTarget(COFFEE_MUG, 2, 0.5)
    );

    public static HashMap<String, Upgrade> generateStarterUpgrades()
    {
        addToMap(TEST_UPGRADE);
        return upgrades;
    }

    private static RequirementBonusTarget<Building> createTarget(Building building, int level, double bonus)
    {
        return new RequirementBonusTarget<>(building, level, bonus);
    }

    private static void addToMap(Upgrade upgrade)
    {
        upgrades.put(upgrade.getName(), upgrade);
    }
}
