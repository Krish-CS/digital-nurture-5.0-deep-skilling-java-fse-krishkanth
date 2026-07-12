package com.bank;

import com.bank.entity.User;
import com.bank.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class Exercise7_CustomQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        userRepository.save(new User(null, "Alice"));
        userRepository.save(new User(null, "Bob"));
        userRepository.save(new User(null, "Alice"));

        List<User> result = userRepository.findByName("Alice");

        assertEquals(2, result.size());
        result.forEach(user -> assertEquals("Alice", user.getName()));
    }
}
