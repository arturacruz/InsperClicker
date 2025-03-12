package br.edu.insper.insperclicker.exception;

public class InsufficientFundsException extends RuntimeException
{
    private final String message;
    public InsufficientFundsException(String name, String resource, double required, double available)
    {
        this.message = "Insufficient funds to buy " + resource + " " + name + ". " + required + " required, " + available + " available.";
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
