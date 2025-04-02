package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.currency.stock.Stock;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

import java.util.HashMap;

public class Init
{
    public void initializeBuildings()
    {
        System.out.println("Initializing buildings.");
    }

    public HashMap<String, Achievement> generateStarterAchievements()
    {
        return new HashMap<>();
    }

    public void initializeUpgrades()
    {
        System.out.println("Initializing upgrades.");
    }

    public void initializeSoulUpgrades()
    {
        System.out.println("Initializing soul upgrades.");
    }

    public void initializePlayer()
    {
        System.out.println("Initializing player.");
    }

    public void initializeAchievements()
    {
        System.out.println("Initializing achievements.");
    }



}
