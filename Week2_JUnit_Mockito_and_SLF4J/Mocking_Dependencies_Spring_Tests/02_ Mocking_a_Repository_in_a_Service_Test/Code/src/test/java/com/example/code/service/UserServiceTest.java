package com.example.code.service;

import com.example.code.model.User;
import com.example.code.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = new User(1L, "sakthivel");

        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getName(), result.getName());
    }

    @Test
    public void testGetUserById_whenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        User result = userService.getUserById(1L);

        assertNull(result);
    }
}