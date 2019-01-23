package com.example.demo.exceptions;

public class NoAccessToEditException extends RuntimeException{
    public NoAccessToEditException(String message) {
        super(message);
    }
}
