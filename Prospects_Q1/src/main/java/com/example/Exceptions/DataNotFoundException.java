package com.example.Exceptions;

public class DataNotFoundException extends Exception{
    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
