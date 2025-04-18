package br.edu.insper.insperclicker.repository.models;

import br.edu.insper.insperclicker.game.common.Player;

public record PlayerModel(
        String id,
        String name,
        double bitcoins,
        double buildingProductionBonus,
        double buildingDiscountBonus,
        GameModel game
)
{
    public static PlayerModel from(Player player)
    {
        return new PlayerModel(
                player.getId(),
                player.getName(),
                player.getBitcoins(),
                player.getBuildingProductionBonus(),
                player.getBuildingDiscountBonus(),
                GameModel.from(player.getGame())
        );
    }

    public static Player to(PlayerModel playerModel)
    {
        return new Player(
                playerModel.id,
                playerModel.name,
                playerModel.bitcoins,
                playerModel.buildingProductionBonus,
                playerModel.buildingDiscountBonus,
                GameModel.to(playerModel.game));
    }
}
