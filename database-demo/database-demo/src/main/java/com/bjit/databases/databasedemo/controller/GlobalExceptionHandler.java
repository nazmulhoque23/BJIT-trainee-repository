package com.bjit.databases.databasedemo.controller;

import com.bjit.databases.databasedemo.exception.CannotCreateException;
import com.bjit.databases.databasedemo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class, CannotCreateException.class})
    public ResponseEntity<Object> notFoundException(Exception ex){
        if(ex instanceof NotFoundException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else if(ex instanceof CannotCreateException){
            return  new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
