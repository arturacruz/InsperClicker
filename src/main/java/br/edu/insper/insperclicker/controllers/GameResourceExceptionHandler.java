package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.dto.ErrorDTO;
import br.edu.insper.insperclicker.exception.*;
import br.edu.insper.insperclicker.util.ErrorUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GameResourceExceptionHandler
{
    @ExceptionHandler(GameResourceNotFoundException.class)
    protected ResponseEntity<ErrorDTO> notFound(RuntimeException err)
    {
        return ErrorUtils.throwNotFound(err);
    }

    @ExceptionHandler({GameResourceAlreadyOwnedException.class,
                        GameResourceNotUnlockedException.class,
                        InsufficientFundsException.class,
                        InvalidClickInputException.class})
    protected ResponseEntity<ErrorDTO> badRequest(RuntimeException err)
    {
        return ErrorUtils.throwBadRequest(err);
    }


}
