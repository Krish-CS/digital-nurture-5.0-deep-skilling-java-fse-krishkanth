# Exercise 1: Parameterized Tests

## Scenario
You want to test a method that checks if a number is even. Instead of writing multiple test cases, you will use parameterized tests to run the same test with different inputs.

## Steps
1. Create a class `EvenChecker` with a method `isEven(int number)`.
2. Write a parameterized test class `EvenCheckerTest` using `@ParameterizedTest` and `@ValueSource`.

## Solution Code

```java
// EvenChecker.java
public class EvenChecker {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// EvenCheckerTest.java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100})
    void testIsEven(int number) {
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    void testIsOdd(int number) {
        assertFalse(checker.isEven(number));
    }
}
```

## Output
```
Tests run: 10 (5 even + 5 odd), Failures: 0
```
