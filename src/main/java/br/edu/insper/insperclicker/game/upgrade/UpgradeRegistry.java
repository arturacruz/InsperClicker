package br.edu.insper.insperclicker.game.upgrade;
import br.edu.insper.insperclicker.game.building.Building;
import static br.edu.insper.insperclicker.game.building.BuildingRegistry.*;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

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

    private static RequirementTarget<Building> createTarget(Building building, int level, double bonus)
    {
        return new RequirementTarget<>(building, level, bonus);
    }

    private static void addToMap(Upgrade upgrade)
    {
        upgrades.put(upgrade.getName(), upgrade);
    }
}
