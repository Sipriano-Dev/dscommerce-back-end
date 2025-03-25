package com.devsipriano.dscommerce.controllers.handlers;

import com.devsipriano.dscommerce.dto.CustomError;
import com.devsipriano.dscommerce.services.exceptions.DatabaseException;
import com.devsipriano.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice//Essa classe pode interceptar qualquer exception para que vc possa customiza e retorna um corpo
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)//Vai interceptar Uma exception especifica
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)//Vai interceptar Uma exception especifica
    public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
