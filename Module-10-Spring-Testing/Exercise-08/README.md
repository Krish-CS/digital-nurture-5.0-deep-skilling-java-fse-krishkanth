# Exercise 8: Test Controller Exception Handling

## Objective
Add and test a `@ControllerAdvice` for handling exceptions.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- Mockito
- MockMvc
- Maven

## Solution Test (`Exercise8_ControllerExceptionTest.java`)
Test that `GlobalExceptionHandler` returns 404 when `NoSuchElementException` is thrown from the controller.

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
