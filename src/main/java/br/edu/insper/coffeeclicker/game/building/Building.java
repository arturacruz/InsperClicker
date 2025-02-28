package br.edu.insper.coffeeclicker.game.building;

public class Building
{
    private String displayName;
    private String name;
    private double price;
    private final double baseCost;
    private final int unlockLevel;
    private final double baseCoffeePerSec;
    private double coffeePerSec;
    private int level = 0;
    private String description;

    public Building(String name, String displayName, double baseCost, String description, double baseCoffeePerSec, int unlockLevel)
    {
        this.name = name;
        this.displayName = displayName;
        this.baseCost = baseCost;
        this.description = description;
        this.baseCoffeePerSec = baseCoffeePerSec;
        this.unlockLevel = unlockLevel;

        updatePrice();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
