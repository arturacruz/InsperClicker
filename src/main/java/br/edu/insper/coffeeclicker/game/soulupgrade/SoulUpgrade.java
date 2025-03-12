package br.edu.insper.coffeeclicker.game.soulupgrade;

import br.edu.insper.coffeeclicker.game.resource.GameResource;

public class SoulUpgrade extends GameResource
{
    private double price;

    public SoulUpgrade(String name, String displayName, String description, double price)
    {
        super(name, displayName, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
