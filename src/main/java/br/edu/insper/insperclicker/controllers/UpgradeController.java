package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.GameState;
import br.edu.insper.insperclicker.game.common.Registries;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;
import br.edu.insper.insperclicker.game.resources.upgrade.UpgradeRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/upgrade")
public class UpgradeController
{
    @Autowired
    private GameState gameState;

    @GetMapping("/buy/{upgradeName}")
    public Game buyUpgrade(
            @RequestParam String playerName,
            @PathVariable String upgradeName) {
        Game game = gameState.getGameInstance(playerName);
        game.buyUpgrade(upgradeName);
        game.doPassiveActions();
        return game;
    }

    @GetMapping("/list")
    public HashMap<String, Upgrade> listUpgrades()
    {
        return new Registries().initializeUpgrades();
    }
}