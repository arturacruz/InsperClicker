package br.edu.insper.insperclicker.game.resources.achievement.currency.stock;

import br.edu.insper.insperclicker.game.currency.common.CurrencyRegistry;
import br.edu.insper.insperclicker.game.currency.stock.Stock;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

public class AchievementStock extends Achievement
{
    private final Stock stock;
    private final int requirement;

    public AchievementStock(String name, String displayName, String description, int requirement, Stock stock)
    {
        super(name, displayName, description, "Stock");
        this.requirement = requirement;
        this.stock = stock;
    }

    public int getRequirement()
    {
        return requirement;
    }

    @Override
    public boolean isValidForUnlock()
    {
        return stock.isEqualOrGreaterThan(requirement);
    }
}
