package br.edu.insper.coffeeclicker.game.building;

import br.edu.insper.coffeeclicker.game.Ascension;
import br.edu.insper.coffeeclicker.game.resource.GameResource;

public class Building extends GameResource
{
    private double price;
    private final double baseCost;
    private final int unlockLevel;
    private final double baseCoffeePerSec;
    private double coffeePerSec;
    private int level = 0;
    private double discountBonus = 0;
    private double productionBonus = 0;

    public Building(String name, String displayName, double baseCost, String description, double baseCoffeePerSec, int unlockLevel)
    {
        super(name, displayName, description);
        this.baseCost = baseCost;
        this.baseCoffeePerSec = baseCoffeePerSec;
        this.unlockLevel = unlockLevel;

        updatePrice();
    }


    public double getPrice() {
        return price;
    }
    public void updatePrice()
    {
        if(level == 0)
        {
            this.price = baseCost;
            return;
        }
        this.price = (baseCost + Math.pow(1.15, getLevel())) * getEffectiveDiscountBonus();
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level)
    {
        this.level = level;
    }

    public int getUnlockLevel()
    {
        return this.unlockLevel;
    }
    public void buy(int amount)
    {
        addToLevel(amount);
        updatePrice();
        updateCoffeePerSec();
    }

    private void addToLevel(int amount) { this.level += amount; }

    public double getCoffeePerSec()
    {
        return this.coffeePerSec * getEffectiveProductionBonus();
    }

    public void updateCoffeePerSec()
    {
        this.coffeePerSec = baseCoffeePerSec * level;
    }

    public double getBaseCoffeePerSec() {
        return baseCoffeePerSec;
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
        return 1 - this.productionBonus;
    }

    public void updateBonusValues(Ascension ascension)
    {
        this.productionBonus = ascension.getBuildingProductionBonus();
        this.discountBonus = ascension.getBuildingDiscountBonus();
    }

}
