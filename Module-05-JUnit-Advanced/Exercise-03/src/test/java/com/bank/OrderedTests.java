package com.bank;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(2)
    public void testB() {
        assertTrue(5 > 3);
    }

    @Test
    @Order(1)
    public void testA() {
        assertEquals(5, 2 + 3);
    }

    @Test
    @Order(3)
    public void testC() {
        assertFalse(5 < 3);
    }
}
