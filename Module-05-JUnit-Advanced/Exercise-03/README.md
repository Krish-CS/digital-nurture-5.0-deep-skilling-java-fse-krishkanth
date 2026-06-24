# Exercise 3: Test Execution Order

## Scenario
You want to control the order in which tests are executed.

## Steps
1. Create a test class `OrderedTests`.
2. Use JUnit's `@TestMethodOrder` and `@Order` annotations.

## Solution Code

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("Executing test 1 first");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Executing test 2 second");
        assertEquals(4, 2 + 2);
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Executing test 3 last");
        assertNotNull("value");
    }
}
```

## Output
```
Executing test 1 first
Executing test 2 second
Executing test 3 last
Tests run: 3, Failures: 0
```
