package com.bridgelabz.employeepayrollapp.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// UC-02 Provide User-Friendly Error Response in case validation fails
// @ControllerAdvice enables centralized exception handling across all @RequestMapping methods
@ControllerAdvice
public class GlobalExceptionHandler {

    // UC-02 To handle validation errors, create @ExceptionHandler
    // for MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage()); // Mapping field names to validation messages
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    //UC-03 Custom Exception for Employee Not Found
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
