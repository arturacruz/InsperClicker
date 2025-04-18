package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.dto.PlayerDTO;
import br.edu.insper.insperclicker.dto.UpgradeDTO;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.Player;
import br.edu.insper.insperclicker.game.common.PlayerState;
import br.edu.insper.insperclicker.game.common.Registries;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;
import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upgrade")
public class UpgradeController
{
    @Autowired
    private PlayerState playerState;

    @GetMapping("/buy/{upgradeName}")
    public PlayerDTO buyUpgrade(
            @RequestParam String playerName,
            @PathVariable String upgradeName)
    {
        PlayerModel playerModel = playerState.getPlayerInstance(playerName);
        Player player = PlayerModel.to(playerModel);
        Game game = player.getGame();

        game.buyUpgrade(upgradeName);
        game.doPassiveActions();

        playerModel = playerState.saveState(PlayerModel.from(player));
        return PlayerDTO.from(PlayerModel.to(playerModel));
    }

    @GetMapping("/list")
    public Map<String, UpgradeDTO> listUpgrades()
    {
        return UpgradeDTO.fromMap(new Registries().initializeUpgrades());
    }
}