package com.sakthivel.Service;

import com.sakthivel.Model.User;
import com.sakthivel.Repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    public void testGetUserById() {
        UserRepository repo = mock(UserRepository.class);

        UserService service = new UserService(repo);

        User user = new User(1L, "Sakthivel");

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        User result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals(user, result);
    }
}