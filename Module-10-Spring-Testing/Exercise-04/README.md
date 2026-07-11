# Exercise 4: Integration Test with Spring Boot

## Objective
Write an integration test that tests the full flow from controller to database using `@SpringBootTest` and H2 database.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- H2 Database (in-memory)
- MockMvc / @SpringBootTest
- Maven

## Solution Test (`Exercise4_IntegrationTest.java`)
```java
package com.bank;

import com.bank.entity.User;
import com.bank.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Exercise4_IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.deleteAll();
        userRepository.save(new User(1L, "Charlie"));
    }

    @Test
    public void testGetUserIntegration() throws Exception {
        mockMvc.perform(get("/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Charlie"));
    }
}
```

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
