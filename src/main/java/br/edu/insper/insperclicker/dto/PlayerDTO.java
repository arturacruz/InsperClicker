package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.common.Player;

public record PlayerDTO(
        String id,
        String name,
        double bitcoins,
        GameDTO game
)
{
    public static PlayerDTO from(Player player)
    {
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getBitcoins(),
                GameDTO.from(player.getGame())
        );
    }
}
