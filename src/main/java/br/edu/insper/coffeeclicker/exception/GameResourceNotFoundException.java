package br.edu.insper.coffeeclicker.exception;

public class GameResourceNotFoundException extends RuntimeException
{
    private final String message;
    public GameResourceNotFoundException(String name, String resource)
    {
        this.message = resource + " with name " + name + " not found";
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
