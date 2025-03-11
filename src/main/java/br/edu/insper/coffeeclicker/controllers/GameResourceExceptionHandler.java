package br.edu.insper.coffeeclicker.controllers;

import br.edu.insper.coffeeclicker.exception.ErrorDTO;
import br.edu.insper.coffeeclicker.exception.GameResourceNotFoundException;
import br.edu.insper.coffeeclicker.util.ErrorUtils;
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
