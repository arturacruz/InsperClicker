package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/click")
public class ClickController
{
    @Autowired
    private GameState gameState;

    @GetMapping("/{clickAmount}")
    public Game click(
            @RequestParam String playerName,
            @PathVariable int clickAmount)
    {
        Game game = gameState.getGameInstance(playerName);
        game.click(clickAmount);
        return game;

    }
}
