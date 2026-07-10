# Exercise 3: Testing a REST Controller with MockMvc

## Objective
Test a REST controller endpoint that returns a user. Use `@WebMvcTest` and `MockMvc` to test controller logic in isolation without starting the servlet container.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- Mockito
- MockMvc
- Maven

## Classes Involved

### Controller (`UserController.java`)
```java
package com.bank.controller;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
```

## Solution Test (`Exercise3_UserControllerMockMvcTest.java`)
```java
package com.bank;

import com.bank.controller.UserController;
import com.bank.entity.User;
import com.bank.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class Exercise3_UserControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        // Arrange
        User user = new User(1L, "Alice");
        when(userService.getUserById(1L)).thenReturn(user);

        // Act & Assert
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice"));

        verify(userService, times(1)).getUserById(1L);
    }
}
```

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
