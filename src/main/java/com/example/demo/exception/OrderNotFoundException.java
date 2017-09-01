package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by niket.shah on 1/9/17.
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Exception msg")
public class OrderNotFoundException extends RuntimeException {
}
