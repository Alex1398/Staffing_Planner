package com.Staffing_Planner.Staffing_Planner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAssignmentException extends RuntimeException {
    public InvalidAssignmentException(String msg) { super(msg); }
}
