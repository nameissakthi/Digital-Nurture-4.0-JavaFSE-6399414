package com.sakthivel.service;

import com.sakthivel.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserById(Long id){
        return new User(id, "Sakthivel");
    }
}