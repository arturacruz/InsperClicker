package br.edu.insper.coffeeclicker.game.soulupgrade;

import br.edu.insper.coffeeclicker.game.resource.GameResource;

public class SoulUpgrade extends GameResource
{
    private double price;

    public SoulUpgrade(String displayName, String name, String description, double price)
    {
        super(displayName, name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
