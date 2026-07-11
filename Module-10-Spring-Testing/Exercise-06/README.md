# Exercise 6: Test Service Exception Handling

## Objective
Test how a service handles a missing user.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- Mockito
- Maven

## Solution Test (`Exercise6_ServiceExceptionTest.java`)
Test `getUserByIdOrThrow()` method in `UserService` — verifies successful lookup and `NoSuchElementException` for missing user.

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
