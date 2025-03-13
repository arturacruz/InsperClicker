package br.edu.insper.insperclicker.game.achievement.money;

import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.money.Money;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class MoneyAchievement extends Achievement<Money>
{
    public MoneyAchievement(String name, String displayName, String description, RequirementTarget<Money>... targetResources)
    {
        super(name, displayName, description, targetResources);
    }
}
