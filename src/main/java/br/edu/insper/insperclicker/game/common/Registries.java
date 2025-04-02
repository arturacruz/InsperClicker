package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.currency.stock.Stock;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;
import br.edu.insper.insperclicker.game.resources.achievement.common.AchievementRegistry;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.game.resources.building.BuildingRegistry;
import br.edu.insper.insperclicker.game.resources.upgrade.Upgrade;
import br.edu.insper.insperclicker.game.resources.upgrade.UpgradeRegistry;

import java.util.HashMap;

public class Registries
{
    private final BuildingRegistry buildingRegistry = new BuildingRegistry();
    private final CurrencyRegistry currencyRegistry = new CurrencyRegistry();
    private final UpgradeRegistry upgradeRegistry = new UpgradeRegistry(buildingRegistry);
    private final AchievementRegistry achievementRegistry = new AchievementRegistry(currencyRegistry);

    public Money initializeMoney()
    {
        return currencyRegistry.MONEY;
    }

    public MoneyPerSec initializeMoneyPerSec()
    {
        return currencyRegistry.MONEY_PER_SEC;
    }

    public Stock initializeStock()
    {
        return currencyRegistry.STOCK;
    }

    public HashMap<String, Building> initializeBuildings()
    {
        return buildingRegistry.generateStarterBuildings();
    }

    public HashMap<String, Upgrade> initializeUpgrades()
    {
        return upgradeRegistry.generateStarterUpgrades();
    }

    public HashMap<String, Achievement> initializeAchievements()
    {
        return achievementRegistry.generateStarterAchievements();
    }

}
