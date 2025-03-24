package br.edu.insper.insperclicker.exception;

public class InvalidClickInputException extends RuntimeException
{
    private final String message;
    public InvalidClickInputException(int clicks)
    {
        this.message = "Invalid input: " + clicks + " clicks.";
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
