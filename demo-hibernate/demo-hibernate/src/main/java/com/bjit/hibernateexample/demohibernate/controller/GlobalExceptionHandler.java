package com.bjit.hibernateexample.demohibernate.controller;

import com.bjit.hibernateexample.demohibernate.exception.AccountNotFoundException;
import com.bjit.hibernateexample.demohibernate.exception.InsufficientBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({AccountNotFoundException.class, InsufficientBalanceException.class})
    public ResponseEntity<Object> accountNotFound(Exception ex){
        if(ex instanceof AccountNotFoundException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else if(ex instanceof InsufficientBalanceException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
