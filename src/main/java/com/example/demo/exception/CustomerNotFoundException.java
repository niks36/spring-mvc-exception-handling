package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by niket.shah on 1/9/17.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Customer Not Found")
public class CustomerNotFoundException extends RuntimeException {
}
