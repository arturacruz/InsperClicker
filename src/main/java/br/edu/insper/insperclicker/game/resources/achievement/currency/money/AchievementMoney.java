package br.edu.insper.insperclicker.game.resources.achievement.currency.money;

import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

public class AchievementMoney extends Achievement
{

    public AchievementMoney(String name, String displayName, String description, double requirement, Money money)
    {
        super(name, displayName, description, "Money", requirement, money);
    }
}
