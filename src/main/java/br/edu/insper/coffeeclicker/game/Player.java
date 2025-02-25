package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.game.soulupgrade.SoulUpgrade;

import java.util.ArrayList;

public class Player
{
    private int ascensionLevel = 0;
    private final ArrayList<SoulUpgrade> soulUpgrades = new ArrayList<>();

    public int getAscensionLevel() {
        return ascensionLevel;
    }

    public void setAscensionLevel(int ascensionLevel) {
        this.ascensionLevel = ascensionLevel;
    }

    public ArrayList<SoulUpgrade> getSoulUpgrades() {
        return soulUpgrades;
    }

    public void addSoulUpgrade(SoulUpgrade soulUpgrade)
    {
        if(soulUpgrade == null) return;
        this.soulUpgrades.add(soulUpgrade);
    }
}
