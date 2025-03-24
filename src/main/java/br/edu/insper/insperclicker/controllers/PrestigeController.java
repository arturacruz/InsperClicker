package br.edu.insper.insperclicker.controllers;
import br.edu.insper.insperclicker.dto.PrestigeDTO;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.GameState;
import br.edu.insper.insperclicker.game.prestige.Prestige;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.game.resources.building.BuildingRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/prestige")
public class PrestigeController
{
    @Autowired
    private GameState gameState;

    @GetMapping("/show")
    public PrestigeDTO showPrestigeEarnings(@RequestParam String playerName)
    {
        Game game = gameState.getGameInstance(playerName);
        game.doPassiveActions();
        return new PrestigeDTO(
                Prestige.getBitcoinEarnedOnPrestige(game.getCurrentGraduation().getMoney())
        );

    }
}
