package com.example.swagger.exception;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String mess) {
        super(mess);
    }
}
