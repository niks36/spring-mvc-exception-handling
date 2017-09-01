# Spring MVC Exception Handling

Spring MVC Provides various way to handle exception.

Mainly there are 3 options.

# Using HTTP Status Code

When any exception throws it causes server to return 500 Status Code.
For that, any exception that we write can be annotated with `@ResponseStatus` annotation

For example, here we have annotated `CustomerNotFoundException` with `@ResponseStatus` annotation

```java
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Customer Not Found")
public class CustomerNotFoundException extends RuntimeException {
}

```
