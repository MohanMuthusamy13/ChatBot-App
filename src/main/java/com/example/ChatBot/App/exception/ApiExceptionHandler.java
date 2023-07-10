package com.example.ChatBot.App.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ResponseNotFoundException.class)
    public ResponseEntity<Object> notFoundException(
            ResponseNotFoundException responseNotFoundException
    ) {
        ApiException apiException = new ApiException()
                .setMessage(responseNotFoundException.getMessage())
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .setZonedDateTime(ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
