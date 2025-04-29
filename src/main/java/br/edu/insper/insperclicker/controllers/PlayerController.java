package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.dto.PlayerDataDTO;
import br.edu.insper.insperclicker.game.common.PlayerState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController
{
    @Autowired
    private PlayerState playerState;

    @GetMapping("/get/{name}")
    public Collection<PlayerDataDTO> findPlayerByName(@PathVariable String playerName)
    {
        return playerState.findPlayerByName(playerName);
    }

    @GetMapping("/list")
    public List<PlayerDataDTO> listPlayers()
    {
        return playerState.listPlayers();
    }
}
