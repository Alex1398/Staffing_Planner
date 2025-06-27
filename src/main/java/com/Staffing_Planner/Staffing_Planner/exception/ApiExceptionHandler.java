package com.Staffing_Planner.Staffing_Planner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(WishAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleWishExists(WishAlreadyExistsException ex) {
        return Map.of("error_wish", ex.getMessage());
    }

    @ExceptionHandler(InvalidAssignmentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleInvalidAssignmentExceptionExists(InvalidAssignmentException ex) {
        return Map.of("error_assignments", ex.getMessage());
    }
}