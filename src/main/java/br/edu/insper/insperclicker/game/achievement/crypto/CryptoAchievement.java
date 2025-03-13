package br.edu.insper.insperclicker.game.achievement.crypto;

import br.edu.insper.insperclicker.game.achievement.Achievement;
import br.edu.insper.insperclicker.game.crypto.Crypto;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

public class CryptoAchievement extends Achievement<Crypto>
{
    public CryptoAchievement(String name, String displayName, String description, RequirementTarget<Crypto>... targetResources)
    {
        super(name, displayName, description, targetResources);
    }
}
