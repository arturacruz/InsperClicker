package br.edu.insper.insperclicker.game.resources.soulupgrade;

import java.util.ArrayList;

public class SoulUpgradeTree
{
    private int level;
    private int treeSize;
    private final ArrayList<SoulUpgrade> soulUpgrades = new ArrayList<>();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTreeSize() {
        return treeSize;
    }

    public void setTreeSize(int treeSize) {
        this.treeSize = treeSize;
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
