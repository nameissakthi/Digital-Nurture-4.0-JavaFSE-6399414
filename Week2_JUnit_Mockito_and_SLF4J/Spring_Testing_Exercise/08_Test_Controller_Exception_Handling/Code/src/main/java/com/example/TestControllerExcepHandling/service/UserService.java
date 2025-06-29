package com.example.TestControllerExcepHandling.service;

import com.example.TestControllerExcepHandling.entity.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    public User getUserById(Long id) {
        throw new NoSuchElementException("User not found");
    }
}
