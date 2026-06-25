package com.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {

    private PerformanceTester tester = new PerformanceTester();

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testPerformTaskWithinTime() {
        String result = tester.performTask();
        assertTrue(result.startsWith("Task completed"));
    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void testSlowTaskWithinTime() {
        tester.slowTask();
    }
}
