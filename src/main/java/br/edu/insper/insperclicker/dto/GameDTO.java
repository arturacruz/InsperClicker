package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.common.Game;

public record GameDTO(GraduationDTO graduation)
{
    public static GameDTO from(Game game)
    {
        return new GameDTO(
                GraduationDTO.from(game.getGraduation())
        );
    }
}
