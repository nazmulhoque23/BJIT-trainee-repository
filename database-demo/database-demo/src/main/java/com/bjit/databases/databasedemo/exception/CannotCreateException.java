package com.bjit.databases.databasedemo.exception;

public class CannotCreateException extends RuntimeException{
    public CannotCreateException(String message){
        super(message);
    }
}
