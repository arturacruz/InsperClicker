package br.edu.insper.coffeeclicker.controllers;
import br.edu.insper.coffeeclicker.exception.GameResourceNotFoundException;
import br.edu.insper.coffeeclicker.game.Ascension;
import br.edu.insper.coffeeclicker.game.Game;
import br.edu.insper.coffeeclicker.game.GameState;
import br.edu.insper.coffeeclicker.game.Init;
import br.edu.insper.coffeeclicker.game.building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
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
        return Init.generateStarterBuildings();
    }
}
