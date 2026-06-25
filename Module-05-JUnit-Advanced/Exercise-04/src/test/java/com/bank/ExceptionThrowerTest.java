package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    private ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
    }

    @Test
    public void testNoException() {
        assertDoesNotThrow(() -> {
            thrower.throwException(false);
        });
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            thrower.divide(10, 0);
        });
    }

    @Test
    public void testDivideSuccess() {
        assertEquals(5, thrower.divide(10, 2));
    }
}
