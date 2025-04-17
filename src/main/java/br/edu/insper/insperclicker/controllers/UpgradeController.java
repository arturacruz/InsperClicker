package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.dto.PlayerDTO;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.Player;
import br.edu.insper.insperclicker.game.common.PlayerState;
import br.edu.insper.insperclicker.game.common.Registries;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
        Player player = playerState.getPlayerInstance(playerName);
        Game game = player.getGame();
        game.buyUpgrade(upgradeName);
        game.doPassiveActions();
        System.out.println(game.getGraduation().getMoney());
        return PlayerDTO.from(playerState.saveState(player));
    }

    @GetMapping("/list")
    public HashMap<String, Upgrade> listUpgrades()
    {
        return new Registries().initializeUpgrades();
    }
}