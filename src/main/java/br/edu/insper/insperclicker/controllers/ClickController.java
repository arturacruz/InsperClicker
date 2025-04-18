package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.dto.PlayerDTO;
import br.edu.insper.insperclicker.exception.InvalidClickInputException;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.Player;
import br.edu.insper.insperclicker.game.common.PlayerState;
import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/click")
public class ClickController
{
    @Autowired
    private PlayerState playerState;

    @GetMapping("/{clickAmount}")
    public PlayerDTO click(
            @RequestParam String playerName,
            @PathVariable int clickAmount)
    {
        if(clickAmount > 1000)
        {
            throw new InvalidClickInputException(clickAmount);
        }
        PlayerModel playerModel = playerState.getPlayerInstance(playerName);
        Player player = PlayerModel.to(playerModel);
        Game game = player.getGame();

        game.click(clickAmount);
        game.doPassiveActions();

        playerModel = playerState.saveState(PlayerModel.from(player));
        return PlayerDTO.from(PlayerModel.to(playerModel));

    }
}
