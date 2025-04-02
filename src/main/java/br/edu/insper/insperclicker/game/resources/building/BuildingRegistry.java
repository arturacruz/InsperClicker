package br.edu.insper.insperclicker.game.resources.building;

import java.util.HashMap;

public class BuildingRegistry
{
    private final HashMap<String, Building> buildings = new HashMap<>();
    public final Building COFFEE_MUG = new Building(
            "moneyMug",
            "Money Mug",
            15,
            "A trusty mug for manual brewing.",
            0.1,
            0,
            0);

    public final Building COFFEE_GRINDER = new Building(
            "moneyGrinder",
            "Money Grinder",
            100,
            "For the money afficionados that wanna do it themselves.",
            1,
            0,
            1);

    public final Building COFFEE_MAKER = new Building(
            "moneyMaker",
            "Money Maker",
            1000,
            "Automates basic brewing. Now with a carafe!",
            10,
            0,
            2);

    public HashMap<String, Building> generateStarterBuildings()
    {
        addToMap(COFFEE_MUG);
        addToMap(COFFEE_GRINDER);
        addToMap(COFFEE_MAKER);
        return buildings;
    }

    private void addToMap(Building building)
    {
        buildings.put(building.getName(), building);
    }

}
