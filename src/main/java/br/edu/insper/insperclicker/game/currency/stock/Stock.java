package br.edu.insper.insperclicker.game.currency.stock;

import br.edu.insper.insperclicker.game.currency.common.Currency;

public class Stock extends Currency<Integer>
{
    private int level;

    public Stock(int amount)
    {
        super(amount);
    }

    public void addToStock(int amount)
    {
        setAmount(getAmount() + amount);
    }

    public boolean isEqualOrGreaterThan(int amount)
    {
        return getAmount() >= amount;
    }

}
