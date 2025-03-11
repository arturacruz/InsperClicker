package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.game.soulupgrade.SoulUpgrade;

import java.util.ArrayList;

public class Player
{
    private String name;
    private int ascensionLevel = 0;
    private int soulBeans = 0;
    private final ArrayList<SoulUpgrade> soulUpgrades = new ArrayList<>();
    private float buildingProductionBonus = 0;
    private float buildingDiscountBonus = 0;


    public Player(String name)
    {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBuildingProductionBonus() {
        return buildingProductionBonus;
    }

    public void setBuildingProductionBonus(float buildingProductionBonus) {
        this.buildingProductionBonus = buildingProductionBonus;
    }

    public float getBuildingDiscountBonus() {
        return buildingDiscountBonus;
    }

    public void setBuildingDiscountBonus(float buildingDiscountBonus) {
        this.buildingDiscountBonus = buildingDiscountBonus;
    }

    public int getSoulBeans() {
        return soulBeans;
    }

    public void setSoulBeans(int soulBeans) {
        this.soulBeans = soulBeans;
    }
}
