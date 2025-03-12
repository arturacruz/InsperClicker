package br.edu.insper.coffeeclicker.controllers;

import br.edu.insper.coffeeclicker.game.Game;
import br.edu.insper.coffeeclicker.game.GameState;
import br.edu.insper.coffeeclicker.game.upgrade.Upgrade;
import br.edu.insper.coffeeclicker.game.upgrade.UpgradeRegistry;
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
        return game;
    }

    @GetMapping("/list")
    public HashMap<String, Upgrade> listUpgrades()
    {
        return UpgradeRegistry.generateStarterUpgrades();
    }
}