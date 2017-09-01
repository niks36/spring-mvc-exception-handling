package com.example.demo.exceptionhandler;

import com.example.demo.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by niket.shah on 1/9/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Message from Global Exception handler")
    public void globalExceptionHandler() {
    }
}
