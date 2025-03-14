package br.edu.insper.insperclicker.game.currency.common;

public class Currency<T extends Number>
{
    private T amount;

    public Currency(T amount)
    {
        this.amount = amount;
    }

    public T getAmount()
    {
        return amount;
    }

    public void setAmount(T amount)
    {
        this.amount = amount;
    }

}
