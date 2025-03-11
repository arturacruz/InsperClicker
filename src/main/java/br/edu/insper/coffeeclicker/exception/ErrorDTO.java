package br.edu.insper.coffeeclicker.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDTO
{
    private final String message;
    private final HttpStatus statusCode;
    private final LocalDateTime localDateTime;

    public ErrorDTO(String message, HttpStatus statusCode)
    {
        this.message = message;
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
}
