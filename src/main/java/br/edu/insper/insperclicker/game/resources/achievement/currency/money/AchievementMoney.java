package br.edu.insper.insperclicker.game.resources.achievement.currency.money;

import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

public class AchievementMoney extends Achievement
{
    private final Money money = CurrencyRegistry.MONEY;
    private final double requirement;

    public AchievementMoney(String name, String displayName, String description, double requirement)
    {
        super(name, displayName, description, "Money");
        this.requirement = requirement;
    }



    public double getRequirement()
    {
        return requirement;
    }

    @Override
    public boolean isValidForUnlock()
    {
        return money.isEqualOrGreaterThan(requirement);
    }
}
