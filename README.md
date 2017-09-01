# Spring MVC Exception Handling

Spring MVC Provides various way to handle exception.
If any exception is thrown from RestController & if it is not handled in a proper way we will git following output.
```
{
    "timestamp": 1504253880312,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "com.example.demo.exception.CustomerNotFoundException",
    "message": "No message available",
    "path": "/customer/10"
}
```
Mainly there are 3 options.

## Using HTTP Status Code

When any exception throws it causes server to return 500 Status Code.
For that, any exception that we write can be annotated with `@ResponseStatus` annotation

For example, here we have annotated `CustomerNotFoundException` with `@ResponseStatus` annotation

```java
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Customer Not Found")
public class CustomerNotFoundException extends RuntimeException {
}

```

After starting the application, if we hit http://localhost:8080/customer/10 from Postman/ARC Clien then it will return following response
```
{
    "timestamp": 1504254105271,
    "status": 400,
    "error": "Bad Request",
    "exception": "com.example.demo.exception.CustomerNotFoundException",
    "message": "Customer Not Found",
    "path": "/customer/10"
}
```

Here, in the response message we are getting proper reason of failure as well as response code that we want to return from the Controller.

## Using Exception handler - Controller level

We can add `@ExceptionHandler` annotation to any controller method to handle exception thrown from the same controller.

For example we have one method in controller
```java
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Order Not Found")
    @ExceptionHandler(OrderNotFoundException.class)
    public void exceptionHandling() {

    }
```

Using this you can convert predefined exception to HTTP Status Code.

## Global Exception handling

Using `@ControllerAdvice` allows you to use exactly the same exception handling technique that we do need to apply to every controller. This will acts as global exception handler class.

Any class annotated with `@ControllerAdvice` becomes a controller-advice.
Like this
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT,reason = "Message from Global Exception handler")
    public void globalExceptionHandler(){
    }
}
```

### In what order spring resolves ExceptionHandler?
First spring will try to find any controller level exception handler method for same type or parent type of exception, if is doest not found any it will check for global exception handler method & after that it will check for exception class level HTTPResponseCode
