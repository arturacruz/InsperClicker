package br.edu.insper.insperclicker.game.currency.money;

import br.edu.insper.insperclicker.game.currency.common.Currency;

public class MoneyPerSec extends Currency<Double>
{
    public MoneyPerSec(double amount)
    {
        super(amount);
    }

    public void addToMoneyPerSec(double amount)
    {
        setAmount(getAmount() + amount);
    }

    public boolean isEqualOrGreaterThan(double amount)
    {
        return getAmount() >= amount;
    }
}
