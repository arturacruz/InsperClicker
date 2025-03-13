package br.edu.insper.insperclicker.game.achievement.crypto;
import br.edu.insper.insperclicker.game.crypto.Crypto;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.HashMap;

public class CryptoAchievementRegistry
{
    private static final HashMap<String, CryptoAchievement> achievements = new HashMap<>();


    public static HashMap<String, CryptoAchievement> generateStarterCryptoAchievements()
    {
        return achievements;
    }

    private static RequirementTarget<Crypto> createTarget(Crypto building, int level, double bonus)
    {
        return new RequirementTarget<>(building, level, bonus);
    }

    private static void addToMap(CryptoAchievement achievement)
    {
        achievements.put(achievement.getName(), achievement);
    }
}

