package br.edu.insper.insperclicker.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDTO
{
    private final String exception;
    private final String message;
    private final HttpStatus statusCode;
    private final LocalDateTime timestamp;

    public ErrorDTO(RuntimeException ex, HttpStatus statusCode)
    {
        this.exception = ex.getClass().getSimpleName();
        this.message = ex.getMessage();
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getException()
    {
        return exception;
    }
}
