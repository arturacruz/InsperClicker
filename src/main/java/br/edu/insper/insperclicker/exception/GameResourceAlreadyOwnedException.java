package br.edu.insper.insperclicker.exception;

public class GameResourceAlreadyOwnedException extends RuntimeException
{
    private final String message;
    public GameResourceAlreadyOwnedException(String name, String resource)
    {
        this.message = resource + " with name " + name + " already owned.";
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
