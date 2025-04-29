package br.edu.insper.insperclicker.controllers;
import br.edu.insper.insperclicker.dto.PrestigeDTO;
import br.edu.insper.insperclicker.game.common.Game;
import br.edu.insper.insperclicker.game.common.PlayerState;
import br.edu.insper.insperclicker.game.prestige.Prestige;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestige")
public class PrestigeController
{
    @Autowired
    private PlayerState playerState;

    @GetMapping("/show")
    public PrestigeDTO showPrestigeEarnings(
            @RequestParam String playerName,
            @RequestParam String password
            )
    {
        Game game = playerState.getGameInstance(playerName, password);
        game.doPassiveActions();
        return new PrestigeDTO(
                Prestige.getBitcoinEarnedOnPrestige(game.getGraduation().getMoney())
        );

    }
}
