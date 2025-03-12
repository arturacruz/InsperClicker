package br.edu.insper.insperclicker.controllers;

import br.edu.insper.insperclicker.exception.ErrorDTO;
import br.edu.insper.insperclicker.exception.GameResourceNotFoundException;
import br.edu.insper.insperclicker.util.ErrorUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GameResourceExceptionHandler
{
    @ExceptionHandler(GameResourceNotFoundException.class)
    protected ResponseEntity<ErrorDTO> resourceNotFound(RuntimeException err)
    {
        return ErrorUtils.throwNotFound(err);
    }

}
