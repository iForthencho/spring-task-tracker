package com.DATakeHomeAssignment.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // exception for task not found
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException (TaskNotFoundException exc) {

        // create a GlobalErrorResponse
        GlobalErrorResponse error = new GlobalErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // catch all exception handler
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException (Exception exc) {

        // create a GlobalErrorResponse
        GlobalErrorResponse error = new GlobalErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
