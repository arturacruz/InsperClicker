package br.edu.insper.insperclicker.game.currency.common;

import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.currency.stock.Stock;

public class CurrencyRegistry
{
    public Money MONEY = new Money(0);

    public MoneyPerSec MONEY_PER_SEC = new MoneyPerSec(0);

    public Stock STOCK = new Stock(0);
}
