package br.edu.insper.coffeeclicker.game.building;

import java.util.HashMap;

public class BuildingRegistry
{
    private static final HashMap<String, Building> buildings = new HashMap<>();
    public static final Building COFFEE_MUG = new Building(
            "coffeeMug",
            "Coffee Mug",
            10,
            "A trusty mug for manual brewing.",
            0.1,
            0);

    public static final Building COFFEE_GRINDER = new Building(
            "coffeeGrinder",
            "Coffee Grinder",
            100,
            "For the coffee afficionados that wanna do it themselves.",
            1,
            1);

    public static final Building COFFEE_MAKER = new Building(
            "coffeeMaker",
            "Coffee Maker",
            1000,
            "Automates basic brewing. Now with a carafe!",
            10,
            2);

    public static HashMap<String, Building> generateStarterBuildings()
    {
        addToMap(COFFEE_MUG);
        addToMap(COFFEE_GRINDER);
        addToMap(COFFEE_MAKER);
        return buildings;
    }

    private static void addToMap(Building building)
    {
        buildings.put(building.getName(), building);
    }

}
