package com.bjit.main.controller;

import com.bjit.main.exception.AdminNotFoundException;
import com.bjit.main.exception.CandidateNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({AdminNotFoundException.class, ArithmeticException.class,
            CandidateNotFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception ex) {
        if(ex instanceof AdminNotFoundException) {
            // Some operation
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else if(ex instanceof CandidateNotFoundException) {
            // Some operation for candidate not found
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else {
            // Some other operation
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
