package br.edu.insper.insperclicker.game.achievement.moneypersec;

import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class MoneyPerSecAchievement extends Achievement<MoneyPerSec>
{
    public MoneyPerSecAchievement(String name, String displayName, String description, RequirementTarget<MoneyPerSec>... targetResources)
    {
        super(name, displayName, description, targetResources);
    }
}
