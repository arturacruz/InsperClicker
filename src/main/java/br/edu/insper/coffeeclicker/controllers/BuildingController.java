package br.edu.insper.coffeeclicker.controllers;
import br.edu.insper.coffeeclicker.game.Ascension;
import br.edu.insper.coffeeclicker.game.Game;
import br.edu.insper.coffeeclicker.game.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/building")
public class BuildingController
{
    @Autowired
    private GameState gameState;

    @GetMapping("/buy/{name}")
    public Ascension buyBuilding(
            @RequestParam String playerName,
            @PathVariable String buildingName)
    {
        Game game = gameState.getGameInstance(playerName);
        return game.getCurrentAscension();

    }
}
