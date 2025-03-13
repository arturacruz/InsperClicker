package br.edu.insper.insperclicker.game.achievement.stock;

import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.crypto.Stock;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class StockAchievement extends Achievement<Stock>
{
    public StockAchievement(String name, String displayName, String description, RequirementTarget<Stock>... targetResources)
    {
        super(name, displayName, description, targetResources);
    }
}
