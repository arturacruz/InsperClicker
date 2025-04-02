package br.edu.insper.insperclicker.game.resources.achievement.currency.moneypersec;

import br.edu.insper.insperclicker.game.resources.achievement.currency.money.AchievementMoney;

import java.util.HashMap;

public class AchievementMoneyPerSecRegistry
{
    private final HashMap<String, AchievementMoneyPerSec> achievements = new HashMap<>();

    public HashMap<String, AchievementMoneyPerSec> generateStarterMoneyPerSecAchievements()
    {

        return achievements;
    }
    private void addToMap(AchievementMoneyPerSec achievementMoneyPerSec)
    {
        achievements.put(achievementMoneyPerSec.getName(), achievementMoneyPerSec);
    }
}
