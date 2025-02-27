package br.edu.insper.coffeeclicker.controllers;

import br.edu.insper.coffeeclicker.game.Ascension;
import br.edu.insper.coffeeclicker.game.Game;
import br.edu.insper.coffeeclicker.game.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/click")
public class ClickController
{
    @Autowired
    private GameState gameState;

    @GetMapping("/{clickAmount}")
    public Ascension click(
            @RequestParam String playerName,
            @PathVariable int clickAmount)
    {
        Game game = gameState.getGameInstance(playerName);
        game.click(clickAmount);
        return game.getCurrentAscension();

    }
}
