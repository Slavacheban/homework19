package com.springdata.exceptions;

public class SomeException extends RuntimeException {
    public SomeException() {
    }

    public SomeException(String message) {
        super(message);
    }
}
