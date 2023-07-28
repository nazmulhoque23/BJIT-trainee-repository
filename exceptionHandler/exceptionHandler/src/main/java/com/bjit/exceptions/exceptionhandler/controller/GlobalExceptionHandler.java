package com.bjit.exceptions.exceptionhandler.controller;

import com.bjit.exceptions.exceptionhandler.exception.CategoryException;
import com.bjit.exceptions.exceptionhandler.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CategoryException.class, ProductException.class})
    public ResponseEntity<Object> notFoundException(Exception ex){
        if(ex instanceof CategoryException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else if(ex instanceof ProductException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
