package br.edu.insper.coffeeclicker.game.requirement;

public class Target
{
    private final String resourceDisplayName;
    private final int requiredLevel;
    private final double bonus;

    public Target(String resourceDisplayName, int requiredLevel, double bonus)
    {
        this.resourceDisplayName = resourceDisplayName;
        this.requiredLevel = requiredLevel;
        this.bonus = bonus;
    }
}
