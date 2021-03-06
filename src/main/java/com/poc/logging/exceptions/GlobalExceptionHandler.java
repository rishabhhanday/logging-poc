package com.poc.logging.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleError(Exception ex) {
        log.error("Something went wrong,{}", ex.getMessage());

        return ResponseEntity.ok("DOWN");
    }
}