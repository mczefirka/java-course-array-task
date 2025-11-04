package com.internship.array_task.exception;

public class ArrayException extends RuntimeException {
    public ArrayException() {
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(Throwable cause) {
        super(cause);
    }

    public ArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}