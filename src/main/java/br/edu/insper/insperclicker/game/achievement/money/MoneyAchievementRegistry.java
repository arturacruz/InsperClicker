package br.edu.insper.insperclicker.game.achievement.money;
import br.edu.insper.insperclicker.game.Graduation;
import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.money.Money;
import br.edu.insper.insperclicker.game.resource.LeveledGameResource;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.HashMap;
import java.util.Map;

public class MoneyAchievementRegistry
{
    private static final HashMap<String, MoneyAchievement> achievements = new HashMap<>();

    public static final MoneyAchievement m100 = new MoneyAchievement(
            "money100", "100 Money", "You got 100 money!",
            createTarget(money, 100, )
    )

    public static Map<String, MoneyAchievement> generateStarterMoneyAchievements(Money money)
    {

        return achievements;
    }

    private static RequirementTarget<Money> createTarget(Money money, int level, double bonus)
    {
        return new RequirementTarget<>(money, level, bonus);
    }

    private static void addToMap(MoneyAchievement achievement)
    {
        achievements.put(achievement.getName(), achievement);
    }
}

