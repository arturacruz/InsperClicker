package br.edu.insper.insperclicker.game.building;

import br.edu.insper.insperclicker.game.Graduation;
import br.edu.insper.insperclicker.game.resource.GameResource;
import br.edu.insper.insperclicker.game.resource.LeveledGameResource;

public class Building extends LeveledGameResource
{
    private double price;
    private final double baseCost;
    private final int unlockLevel;
    private final double baseMoneyPerSec;
    private double moneyPerSec;
    private double discountBonus = 0;
    private double productionBonus = 0;
    private double upgradeProductionBonus = 0;

    public Building(String name, String displayName, double baseCost, String description, double baseMoneyPerSec, int unlockLevel)
    {
        super(name, displayName, description, 0);
        this.baseCost = baseCost;
        this.baseMoneyPerSec = baseMoneyPerSec;
        this.unlockLevel = unlockLevel;

        updatePrice();
    }


    public double getPrice() {
        return price;
    }

    public double getBuyPrice(int amount)
    {
        if(getLevel() == 0 && amount == 1) return baseCost;

        return (baseCost * amount + Math.pow(1.15, getLevel() + amount - 1)) * getEffectiveDiscountBonus();
    }
    public void updatePrice()
    {
        if(getLevel() == 0)
        {
            this.price = baseCost;
            return;
        }
        this.price = (baseCost + Math.pow(1.15, getLevel())) * getEffectiveDiscountBonus();
    }

    public int getUnlockLevel()
    {
        return this.unlockLevel;
    }
    public void buy(int amount)
    {
        addToLevel(amount);
        updatePrice();
        updateMoneyPerSec();
    }

    public double getMoneyPerSec()
    {
        return this.moneyPerSec;
    }

    public void updateMoneyPerSec()
    {
        this.moneyPerSec = baseMoneyPerSec * getLevel() * getEffectiveProductionBonus();
    }

    public double getBaseMoneyPerSec() {
        return baseMoneyPerSec;
    }

    /**
     * Number in percentage, from 0 to 1
     * 0.05 would apply a 5% bonus, subtracting from 1
     */
    public double getProductionBonus() {
        return productionBonus;
    }

    /**
     * {@link Building#getProductionBonus()}
     */
    public void setProductionBonus(double productionBonus) {
        this.productionBonus = productionBonus;
    }

    /**
     * Number in percentage, from 0 to 1
     * 0.05 would apply a 5% bonus, subtracting from 1
     */
    public double getDiscountBonus()
    {
        return discountBonus;
    }

    /**
     * {@link Building#getDiscountBonus()}
     */
    public void setDiscountBonus(double discountBonus) {
        this.discountBonus = discountBonus;
    }

    /**
     * Number in percentage, with the value subtracted from 1
     */
    public double getEffectiveDiscountBonus()
    {
        return 1 - this.discountBonus;
    }

    /**
     * Number in percentage, with the value subtracted from 1
     */
    public double getEffectiveProductionBonus()
    {
        return 1 + this.productionBonus;
    }

    public void updateBonusValues(Graduation graduation)
    {
        this.productionBonus = graduation.getBuildingProductionBonus() + getUpgradeProductionBonus();
        this.discountBonus = graduation.getBuildingDiscountBonus();
        this.updateMoneyPerSec();
    }

    public void addToUpgradeProductionBonus(double value)
    {
        this.upgradeProductionBonus += value;
    }

    public double getUpgradeProductionBonus()
    {
        return upgradeProductionBonus;
    }

    public void setUpgradeProductionBonus(double upgradeProductionBonus)
    {
        this.upgradeProductionBonus = upgradeProductionBonus;
    }
}
