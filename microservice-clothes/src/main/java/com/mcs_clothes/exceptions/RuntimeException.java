package com.mcs_clothes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeException {

    @ExceptionHandler(java.lang.RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(java.lang.RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}
