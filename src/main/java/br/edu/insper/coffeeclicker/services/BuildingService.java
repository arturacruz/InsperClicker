package br.edu.insper.coffeeclicker.services;

import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.building.BuildingCoffeeMug;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BuildingService
{
    private final HashMap<String, Building> nameToBuilding = new HashMap<>();

}
