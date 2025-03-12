package br.edu.insper.coffeeclicker.game.upgrade;
import br.edu.insper.coffeeclicker.game.building.Building;
import static br.edu.insper.coffeeclicker.game.building.BuildingRegistry.*;
import br.edu.insper.coffeeclicker.game.target.RequirementTarget;
import jakarta.annotation.Nullable;
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
