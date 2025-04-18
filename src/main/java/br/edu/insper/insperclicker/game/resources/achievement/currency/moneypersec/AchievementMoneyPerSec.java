package br.edu.insper.insperclicker.game.resources.achievement.currency.moneypersec;

import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

public class AchievementMoneyPerSec extends Achievement
{

    public AchievementMoneyPerSec(String name, String displayName, String description, double requirement, MoneyPerSec moneyPerSec)
    {
        super(name, displayName, description, "MoneyPerSec", requirement, moneyPerSec);
    }

}
