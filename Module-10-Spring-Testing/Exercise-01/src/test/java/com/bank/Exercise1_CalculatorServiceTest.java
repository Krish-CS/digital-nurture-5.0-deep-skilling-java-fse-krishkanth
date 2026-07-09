package com.bank;

import com.bank.service.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1_CalculatorServiceTest {

    private UserService userService = new UserService();

    @Test
    public void testAdd() {
        int result = userService.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testAddNegative() {
        int result = userService.add(-1, 5);
        assertEquals(4, result);
    }
}
