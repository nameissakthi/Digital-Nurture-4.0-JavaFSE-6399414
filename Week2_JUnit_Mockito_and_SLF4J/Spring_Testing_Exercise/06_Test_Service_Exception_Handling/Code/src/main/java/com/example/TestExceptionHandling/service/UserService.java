package com.example.TestExceptionHandling.service;

import com.example.TestExceptionHandling.exception.UserNotFoundException;
import com.example.TestExceptionHandling.model.User;
import com.example.TestExceptionHandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
