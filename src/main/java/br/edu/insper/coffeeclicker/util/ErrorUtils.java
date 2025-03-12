package br.edu.insper.coffeeclicker.util;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import br.edu.insper.coffeeclicker.exception.ErrorDTO;
import org.springframework.http.ResponseEntity;

public class ErrorUtils
{
    public static ResponseEntity<ErrorDTO> throwNotFound(RuntimeException err)
    {
        ErrorDTO errorDTO = new ErrorDTO(
          err.getMessage(),
          NOT_FOUND
        );
        return ResponseEntity.status(NOT_FOUND).body(errorDTO);
    }
}
