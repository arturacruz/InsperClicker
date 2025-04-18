package br.edu.insper.insperclicker.game.currency.stock;

import br.edu.insper.insperclicker.game.currency.common.Currency;

public class Stock extends Currency
{
    private double level;

    public Stock(double amount)
    {
        super(amount);
    }

    public void addToStock(double amount)
    {
        setAmount(getAmount() + amount);
    }

    public boolean isEqualOrGreaterThan(double amount)
    {
        return getAmount() >= amount;
    }

}
