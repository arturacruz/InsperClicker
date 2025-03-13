package br.edu.insper.insperclicker.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDTO
{
    private final String exceptionName;
    private final String message;
    private final HttpStatus statusCode;
    private final LocalDateTime localDateTime;

    public ErrorDTO(RuntimeException ex, HttpStatus statusCode)
    {
        this.exceptionName = ex.getClass().getSimpleName();
        this.message = ex.getMessage();
        this.statusCode = statusCode;
        this.localDateTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getExceptionName()
    {
        return exceptionName;
    }
}
