package br.edu.insper.insperclicker.game.currency.common;

import br.edu.insper.insperclicker.game.currency.money.Money;
import br.edu.insper.insperclicker.game.currency.money.MoneyPerSec;
import br.edu.insper.insperclicker.game.currency.stock.Stock;

public class CurrencyRegistry
{
    public static Money MONEY = new Money(100000000.0);

    public static MoneyPerSec MONEY_PER_SEC = new MoneyPerSec(0);

    public static Stock STOCK = new Stock(0);
}
