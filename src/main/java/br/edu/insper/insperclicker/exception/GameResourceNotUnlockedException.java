package br.edu.insper.insperclicker.exception;

public class GameResourceNotUnlockedException extends RuntimeException
{
    private final String message;
    public GameResourceNotUnlockedException(String name, String resource)
    {
        this.message = resource + " with name " + name + " not yet unlocked. You filthy cheater.";
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
