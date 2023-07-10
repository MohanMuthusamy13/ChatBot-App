package com.example.ChatBot.App.exception;

public class ResponseNotFoundException extends RuntimeException {
    public ResponseNotFoundException(String message) {
        super(message);
    }

    public ResponseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
