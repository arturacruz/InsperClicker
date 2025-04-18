package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.repository.PlayerRepository;
import br.edu.insper.insperclicker.repository.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlayerState
{
    @Autowired
    private PlayerRepository repository;

    public PlayerModel getPlayerInstance(String name)
    {
        PlayerModel playerModel = repository.findByName(name);
        if(playerModel == null)
        {
            System.out.println("null");
            playerModel = repository.save(PlayerModel.from(new Player(name)));
        }
        return playerModel;
    }

    public PlayerModel saveState(PlayerModel player)
    {
        return repository.save(player);
    }

    public Game getGameInstance(String player)
    {
        return PlayerModel.to(getPlayerInstance(player)).getGame();
    }

}
