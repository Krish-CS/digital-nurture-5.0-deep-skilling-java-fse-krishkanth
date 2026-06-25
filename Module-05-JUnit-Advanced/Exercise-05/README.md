# Exercise 5: Timeout and Performance Testing

## Scenario
You want to ensure that a method completes within a specified time limit.

## Steps
1. Create a class `PerformanceTester` with a method `performTask`.
2. Write a test using `@Timeout` to assert it completes within the time limit.

## Solution Code

```java
// PerformanceTester.java
public class PerformanceTester {
    public void performTask() throws InterruptedException {
        // Simulating a fast task
        Thread.sleep(100);
        System.out.println("Task completed.");
    }
}

// PerformanceTesterTest.java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testPerformTaskWithinTimeLimit() throws InterruptedException {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask(); // Must complete within 1 second
    }
}
```

## Output
```
Task completed.
Tests run: 1, Failures: 0 — Task completed within timeout.
```
