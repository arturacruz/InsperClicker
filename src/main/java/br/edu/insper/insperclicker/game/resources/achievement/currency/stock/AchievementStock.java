package br.edu.insper.insperclicker.game.resources.achievement.currency.stock;

import br.edu.insper.insperclicker.game.currency.stock.Stock;
import br.edu.insper.insperclicker.game.resources.achievement.common.Achievement;

public class AchievementStock extends Achievement
{

    public AchievementStock(String name, String displayName, String description, double requirement, Stock stock)
    {
        super(name, displayName, description, "Stock", requirement, stock);
    }
}
