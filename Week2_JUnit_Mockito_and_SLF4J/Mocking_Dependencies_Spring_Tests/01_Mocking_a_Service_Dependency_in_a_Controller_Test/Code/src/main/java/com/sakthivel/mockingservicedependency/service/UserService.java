package com.sakthivel.mockingservicedependency.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserName() {
        return "Sakthivel";
    }
}
