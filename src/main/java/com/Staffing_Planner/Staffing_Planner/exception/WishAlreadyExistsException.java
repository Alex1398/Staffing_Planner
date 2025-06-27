package com.Staffing_Planner.Staffing_Planner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WishAlreadyExistsException extends RuntimeException {
    public WishAlreadyExistsException(String message) {
        super(message);
    }
}