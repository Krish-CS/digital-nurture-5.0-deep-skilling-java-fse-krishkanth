# Exercise 2: Mocking a Repository in a Service Test

## Objective
Test a service that uses a repository to fetch data. Use Mockito to mock the repository and verify the service class behavior.

## Technologies Used
- Java 17
- Spring Boot 3.2.0
- JUnit 5
- Mockito
- Maven

## Classes Involved

### Entity (`User.java`)
```java
package com.bank.entity;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    // getters and setters
}
```

### Repository (`UserRepository.java`)
```java
package com.bank.repository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

### Service (`UserService.java`)
```java
package com.bank.service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

## Solution Test (`Exercise2_UserServiceMockTest.java`)
```java
package com.bank;

import com.bank.entity.User;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Exercise2_UserServiceMockTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        // Arrange
        User user = new User(1L, "John Doe");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(userRepository, times(1)).findById(1L);
    }
}
```

## How to Run the Test
Navigate to this directory and run:
```bash
mvn test
```
