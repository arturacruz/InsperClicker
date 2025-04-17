package br.edu.insper.insperclicker.dto;

import br.edu.insper.insperclicker.game.common.Graduation;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.currency.stock.Stock;

import java.util.Map;

public record GraduationDTO(
        double money,
        double moneyPerSec,
        double stock,
        double clickSize,
        Map<String, BuildingDTO> buildings,
        Map<String, AchievementDTO> achievements,
        Map<String, UpgradeDTO> upgrades)
{
    public static GraduationDTO from(Graduation graduation)
    {
        return new GraduationDTO(
                graduation.getMoney(),
                graduation.getMoneyPerSec(),
                graduation.getStock(),
                graduation.getClickSize(),
                BuildingDTO.fromMap(graduation.getBuildings()),
                AchievementDTO.fromMap(graduation.getAchievements()),
                UpgradeDTO.fromMap(graduation.getUpgrades())
        );
    }
}
