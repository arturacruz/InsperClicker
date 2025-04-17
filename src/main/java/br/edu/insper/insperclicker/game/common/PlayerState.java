package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlayerState
{
    @Autowired
    private PlayerRepository repository;

    public Player getPlayerInstance(String name)
    {
        Player player = repository.findByName(name);
        if(player == null)
        {
            player = repository.save(new Player(name));
        }
        return player;
    }

    public Player saveState(Player player)
    {
        return repository.save(player);
    }

    public Game getGameInstance(String player)
    {
        return getPlayerInstance(player).getGame();
    }

}
