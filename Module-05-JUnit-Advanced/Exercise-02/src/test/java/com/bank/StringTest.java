package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    public void testStringLength() {
        assertEquals(5, "Hello".length());
    }

    @Test
    public void testStringUpperCase() {
        assertEquals("HELLO", "hello".toUpperCase());
    }
}
