package br.edu.insper.insperclicker.controllers;
import br.edu.insper.insperclicker.dto.BuildingDTO;
import br.edu.insper.insperclicker.dto.PlayerDTO;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.PlayerState;
import br.edu.insper.insperclicker.game.common.Player;
import br.edu.insper.insperclicker.game.common.Registries;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/building")
public class BuildingController
{
    @Autowired
    private PlayerState playerState;

    @GetMapping("/buy/{buildingName}/{amount}")
    public PlayerDTO buyBuilding(
            @RequestParam String playerName,
            @RequestParam String password,
            @PathVariable String buildingName,
            @PathVariable int amount)
    {
        PlayerModel playerModel = playerState.getPlayerInstance(playerName, password);
        Player player = PlayerModel.to(playerModel);
        Game game = player.getGame();

        game.buyBuilding(buildingName, amount);
        game.doPassiveActions();

        playerModel = playerState.saveState(PlayerModel.from(player));
        return PlayerDTO.from(PlayerModel.to(playerModel));

    }

    @GetMapping("/list")
    public Map<String, BuildingDTO> listBuildings()
    {
        return BuildingDTO.fromMap(new Registries().initializeBuildings());
    }
}
