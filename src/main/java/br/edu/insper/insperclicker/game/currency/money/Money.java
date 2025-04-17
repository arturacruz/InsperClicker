package br.edu.insper.insperclicker.game.currency.money;


import br.edu.insper.insperclicker.game.currency.common.Currency;


public class Money extends Currency<Double>
{

    public Money(double amount)
    {
        super(amount);
    }

    public void addToMoney(double amount)
    {
        setAmount(getAmount() + amount);
    }

    public void subtractFromMoney(double amount)
    {
        setAmount(getAmount() - amount);
    }

    public boolean isEqualOrGreaterThan(double amount)
    {
        return getAmount() >= amount;
    }
}
