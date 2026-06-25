# Exercise 4: Exception Testing

## Scenario
You want to test that a method throws the expected exception.

## Steps
1. Create a class `ExceptionThrower` with a method `throwException`.
2. Write a test class `ExceptionThrowerTest` verifying the method throws the expected exception.

## Solution Code

```java
// ExceptionThrower.java
public class ExceptionThrower {
    public void throwException() {
        throw new IllegalArgumentException("Invalid argument provided");
    }
}

// ExceptionThrowerTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testThrowsException() {
        ExceptionThrower thrower = new ExceptionThrower();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> thrower.throwException()
        );

        assertEquals("Invalid argument provided", exception.getMessage());
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Exception correctly thrown and verified.
```
