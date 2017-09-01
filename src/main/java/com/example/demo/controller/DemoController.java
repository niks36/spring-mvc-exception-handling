package com.example.demo.controller;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by niket.shah on 1/9/17.
 */
@RestController
public class DemoController {

    @GetMapping(path = "/customer/{id}")
    public @ResponseBody
    ResponseEntity<String> getCustomerId(@PathVariable String id) {
        if (id.equals("10")) {
            throw new CustomerNotFoundException();
        }
        return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
    }


    @GetMapping(path = "/order/{id}")
    public @ResponseBody
    ResponseEntity<String> getOrder(@PathVariable String id) {
        if (id.equals("10")) {
            throw new OrderNotFoundException();
        }
        return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/employee/{id}")
    public @ResponseBody
    ResponseEntity<String> getEmployee(@PathVariable String id) {
        if (id.equals("10")) {
            throw new EmployeeNotFoundException();
        }
        return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Order Not Found")
    @ExceptionHandler(OrderNotFoundException.class)
    public void exceptionHandling() {

    }
}
