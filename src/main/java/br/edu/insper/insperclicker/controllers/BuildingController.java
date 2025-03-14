package br.edu.insper.insperclicker.controllers;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.GameState;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.game.resources.building.BuildingRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/building")
public class BuildingController
{
    @Autowired
    private GameState gameState;

    @GetMapping("/buy/{buildingName}/{amount}")
    public Game buyBuilding(
            @RequestParam String playerName,
            @PathVariable String buildingName,
            @PathVariable int amount)
    {
        Game game = gameState.getGameInstance(playerName);
        game.buyBuilding(buildingName, amount);
        return game;

    }

    @GetMapping("/list")
    public HashMap<String, Building> listBuildings()
    {
        return BuildingRegistry.generateStarterBuildings();
    }
}
