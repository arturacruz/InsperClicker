package br.edu.insper.insperclicker.repository.models;

import br.edu.insper.insperclicker.game.common.Game;

import java.time.LocalDateTime;

public record GameModel(
        LocalDateTime lastRequest,
        GraduationModel graduation
)
{
    public static GameModel from(Game game)
    {
        return new GameModel(
                game.getLastRequest(),
                GraduationModel.from(game.getGraduation())
        );
    }

    public static Game to(GameModel gameModel)
    {
        return new Game(
                gameModel.lastRequest,
                GraduationModel.to(gameModel.graduation)
        );
    }
}
