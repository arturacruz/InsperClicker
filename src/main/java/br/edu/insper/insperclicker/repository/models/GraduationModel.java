package br.edu.insper.insperclicker.repository.models;

import br.edu.insper.insperclicker.game.common.Graduation;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.currency.stock.Stock;

import java.util.HashMap;
import java.util.Map;

public record GraduationModel(
        Money money,
        MoneyPerSec moneyPerSec,
        Stock stock,
        Map<String, BuildingModel> buildings,
        Map<String, UpgradeModel> upgrades,
        Map<String, AchievementModel> achievements,
        double clickSize,
        int currentUnlockLevel,
        double buildingDiscountBonus,
        double buildingProductionBonus
)
{
    public static GraduationModel from(Graduation graduation)
    {
        return new GraduationModel(
                new Money(graduation.getMoney()),
                new MoneyPerSec(graduation.getMoneyPerSec()),
                new Stock(graduation.getStock()),
                BuildingModel.fromMap(graduation.getUnfilteredBuildings()),
                UpgradeModel.fromMap(graduation.getUnfilteredUpgrades()),
                AchievementModel.fromMap(graduation.getAchievements()),
                graduation.getClickSize(),
                graduation.getCurrentUnlockLevel(),
                graduation.getBuildingDiscountBonus(),
                graduation.getBuildingProductionBonus()
        );
    }

    public static Graduation to(GraduationModel graduationModel)
    {
        return new Graduation(
                graduationModel.money,
                graduationModel.moneyPerSec,
                graduationModel.stock,
                new HashMap<>(BuildingModel.toMap(graduationModel.buildings)),
                new HashMap<>(UpgradeModel.toMap(graduationModel.upgrades)),
                new HashMap<>(AchievementModel.toMap(graduationModel.achievements)),
                graduationModel.clickSize,
                graduationModel.currentUnlockLevel,
                graduationModel.buildingDiscountBonus,
                graduationModel.buildingProductionBonus
        );
    }
}
