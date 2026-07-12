package com.bank;

import com.bank.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise9_ParameterizedTest {

    private UserService userService = new UserService();

    @ParameterizedTest
    @CsvSource({"1,2,3", "10,20,30", "0,0,0", "-1,1,0"})
    public void testAddMultiple(int a, int b, int expected) {
        assertEquals(expected, userService.add(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, -3, 100, 1})
    public void testAddWithZero(int num) {
        assertEquals(num, userService.add(num, 0));
    }
}
