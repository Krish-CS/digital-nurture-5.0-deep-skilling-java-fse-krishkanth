# Exercise 1: Basic Unit Test for a Service Method

## Objective
Write a unit test for a service method that adds two numbers.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- Maven

## Service Under Test (`UserService.java`)
```java
package com.bank.service;

@Service
public class UserService {
    public int add(int a, int b) {
        return a + b;
    }
    // ... other methods
}
```

## Solution Test (`Exercise1_CalculatorServiceTest.java`)
```java
package com.bank;

import com.bank.service.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1_CalculatorServiceTest {

    private UserService userService = new UserService();

    @Test
    public void testAdd() {
        int result = userService.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testAddNegative() {
        int result = userService.add(-1, 5);
        assertEquals(4, result);
    }
}
```

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
