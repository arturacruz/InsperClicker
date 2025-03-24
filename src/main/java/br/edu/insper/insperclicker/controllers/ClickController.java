package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.exception.InvalidClickInputException;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
        if(clickAmount > 1000)
        {
            throw new InvalidClickInputException(clickAmount);
        }
        Game game = gameState.getGameInstance(playerName);
        game.click(clickAmount);
        game.doPassiveActions();
        return game;

    }
}
