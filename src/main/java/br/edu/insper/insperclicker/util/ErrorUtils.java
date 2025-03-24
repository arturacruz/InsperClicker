package br.edu.insper.insperclicker.util;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import br.edu.insper.insperclicker.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorUtils
{
    public static ResponseEntity<ErrorDTO> throwNotFound(RuntimeException err)
    {
        ErrorDTO errorDTO = new ErrorDTO(
          err,
          NOT_FOUND
        );
        return ResponseEntity.status(NOT_FOUND).body(errorDTO);
    }

    public static ResponseEntity<ErrorDTO> throwBadRequest(RuntimeException err)
    {
        ErrorDTO errorDTO = new ErrorDTO(
                err,
                BAD_REQUEST
        );
        return ResponseEntity.status(BAD_REQUEST).body(errorDTO);
    }
}
