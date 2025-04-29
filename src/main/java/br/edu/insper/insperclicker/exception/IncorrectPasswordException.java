package br.edu.insper.insperclicker.exception;


public class IncorrectPasswordException extends RuntimeException
{
    private final String message;
    public IncorrectPasswordException(String name, String password)
    {
        this.message = password + " is the incorrect password for player " + name + ".";
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
