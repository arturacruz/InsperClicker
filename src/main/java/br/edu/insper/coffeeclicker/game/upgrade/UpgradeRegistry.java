package br.edu.insper.coffeeclicker.game.upgrade;
import br.edu.insper.coffeeclicker.game.building.Building;
import static br.edu.insper.coffeeclicker.game.building.BuildingRegistry.*;
import br.edu.insper.coffeeclicker.game.target.RequirementTarget;
import jakarta.annotation.Nullable;
import java.util.HashMap;

public class UpgradeRegistry
{
    private static final HashMap<String, Upgrade> upgrades = new HashMap<>();

    public static final Upgrade TEST_UPGRADE = register(
            "testUpgrade", "Test Upgrade", "A test upgrade.", 10,
            COFFEE_MUG, 1, 0.05,
            null, 0, 0
    );

    public static HashMap<String, Upgrade> generateStarterUpgrades()
    {
        addToMap(TEST_UPGRADE);
        return upgrades;
    }

    private static Upgrade register(String displayName, String name, String description, double price,
                                    Building primaryBuilding, int primaryRequiredLevel, double primaryBonus,
                                    @Nullable Building secondaryBuilding, int secondaryRequiredLevel, double secondaryBonus)
    {
        RequirementTarget<Building> primaryTarget = new RequirementTarget<>(primaryBuilding, primaryRequiredLevel, primaryBonus);
        RequirementTarget<Building> secondaryTarget = null;
        if(secondaryBuilding != null)
        {
            secondaryTarget = new RequirementTarget<>(secondaryBuilding, secondaryRequiredLevel, secondaryBonus);
        }

        return new Upgrade(
            displayName, name, description, price, primaryTarget, secondaryTarget
        );
    }

    private static void addToMap(Upgrade upgrade)
    {
        upgrades.put(upgrade.getDisplayName(), upgrade);
    }
}
