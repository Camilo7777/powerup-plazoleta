package com.pragma.powerup.infrastructure.exceptionhandler;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import com.pragma.powerup.domain.exception.WrongDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(WrongDataException.class)
    public ResponseEntity<Map<String, String>> handleWrongDataException(
            WrongDataException ignoredWrongDataException) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.WRONG_DATA.getMessage()));
    }
    
}