package br.edu.insper.coffeeclicker.game.building;

public class Building
{
    private String displayName;
    private String name;
    private double price;
    private int level = 0;
    private String description;

    public Building(String name, String displayName, double price, String description)
    {
        this.name = name;
        this.displayName = displayName;
        this.price = price;
        this.description = description;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
