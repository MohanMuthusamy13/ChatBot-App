package com.example.ChatBot.App.exception;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class ApiException {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;
}
