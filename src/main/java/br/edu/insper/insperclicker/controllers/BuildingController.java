package br.edu.insper.insperclicker.controllers;
import br.edu.insper.insperclicker.dto.PlayerDTO;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.PlayerState;
import br.edu.insper.insperclicker.game.common.Player;
import br.edu.insper.insperclicker.game.common.Registries;
import br.edu.insper.insperclicker.game.resources.building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/building")
public class BuildingController
{
    @Autowired
    private PlayerState playerState;

    @GetMapping("/buy/{buildingName}/{amount}")
    public PlayerDTO buyBuilding(
            @RequestParam String playerName,
            @PathVariable String buildingName,
            @PathVariable int amount)
    {
        Player player = playerState.getPlayerInstance(playerName);
        Game game = player.getGame();
        game.buyBuilding(buildingName, amount);
        game.doPassiveActions();
        return PlayerDTO.from(playerState.saveState(player));

    }

    @GetMapping("/list")
    public HashMap<String, Building> listBuildings()
    {
        return new Registries().initializeBuildings();
    }
}
