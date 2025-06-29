package com.example.CustomRepoQuery.repository;

import com.example.CustomRepoQuery.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName_shouldReturnMatchingUsers() {
        User u1 = new User("Alice");
        User u2 = new User("Sakthi");
        User u3 = new User("Alice");

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        List<User> result = userRepository.findByName("Alice");

        assertThat(result).hasSize(2);
        assertThat(result).allMatch(user -> user.getName().equals("Alice"));
    }
}
