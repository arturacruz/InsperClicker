package br.edu.insper.insperclicker.game.common;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GameState
{
    /**
     * String = playerName
     * Game = Corresponding game instance
     */
    private final HashMap<String, Game> gameStates = new HashMap<>();

    public Game getGameInstance(String player)
    {
        if(!gameStates.containsKey(player))
        {
            gameStates.put(player, new Game(player));
        }
        Game game = gameStates.get(player);
        game.doPassiveActions();
        return game;
    }

}
