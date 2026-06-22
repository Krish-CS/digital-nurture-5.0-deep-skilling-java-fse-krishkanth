package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(5, 2 + 3);
    }

    @Test
    public void testMultiply() {
        assertEquals(12, 3 * 4);
    }
}
