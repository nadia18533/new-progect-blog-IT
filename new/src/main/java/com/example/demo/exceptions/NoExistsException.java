package com.example.demo.exceptions;

public class NoExistsException extends RuntimeException{
    public NoExistsException(String message) {
        super(message);
    }
}
