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
        super(displayName, name, description);
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
        this.price = baseCost + Math.pow(1.15, getLevel());
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
        return this.coffeePerSec;
    }

    public void updateCoffeePerSec()
    {
        this.coffeePerSec = baseCoffeePerSec * level;
    }

    public double getBaseCoffeePerSec() {
        return baseCoffeePerSec;
    }

    public double getProductionBonus() {
        return productionBonus;
    }

    public void setProductionBonus(double productionBonus) {
        this.productionBonus = productionBonus;
    }

    public double getDiscountBonus() {
        return discountBonus;
    }

    public void setDiscountBonus(double discountBonus) {
        this.discountBonus = discountBonus;
    }


    public void updateBonusValues(Ascension ascension)
    {
        this.productionBonus = ascension.getBuildingProductionBonus();
        this.discountBonus = ascension.getBuildingDiscountBonus();
    }

}
