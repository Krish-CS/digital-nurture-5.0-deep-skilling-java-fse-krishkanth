package com.bank;

import com.bank.entity.User;
import com.bank.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class Exercise4_IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindUser() {
        User user = new User(null, "Alice");
        User saved = userRepository.save(user);

        assertNotNull(saved.getId());

        User found = userRepository.findById(saved.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("Alice", found.getName());
    }
}
