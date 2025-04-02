package br.edu.insper.insperclicker.game.resources.achievement.currency.moneypersec;

import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

public class AchievementMoneyPerSec extends Achievement
{
    private final MoneyPerSec moneyPerSec;
    private final double requirement;

    public AchievementMoneyPerSec(String name, String displayName, String description, double requirement, MoneyPerSec moneyPerSec)
    {
        super(name, displayName, description, "MoneyPerSec");
        this.requirement = requirement;
        this.moneyPerSec = moneyPerSec;
    }

    public double getRequirement()
    {
        return requirement;
    }

    @Override
    public boolean isValidForUnlock()
    {
        return moneyPerSec.isEqualOrGreaterThan(requirement);
    }
}
