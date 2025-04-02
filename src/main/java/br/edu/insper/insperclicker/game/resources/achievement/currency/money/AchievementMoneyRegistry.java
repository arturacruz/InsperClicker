package br.edu.insper.insperclicker.game.resources.achievement.currency.money;

import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.resources.building.Building;

import java.util.HashMap;

public class AchievementMoneyRegistry
{
    private final HashMap<String, AchievementMoney> achievements = new HashMap<>();

    private final AchievementMoney A100;

    public AchievementMoneyRegistry(Money money)
    {
         A100 = new AchievementMoney("A100", "A100", "100 MONEY", 100, money);
    }
    public HashMap<String, AchievementMoney> generateStarterMoneyAchievements()
    {
        addToMap(A100);
        return achievements;
    }
    private void addToMap(AchievementMoney achievementMoney)
    {
        achievements.put(achievementMoney.getName(), achievementMoney);
    }
}
