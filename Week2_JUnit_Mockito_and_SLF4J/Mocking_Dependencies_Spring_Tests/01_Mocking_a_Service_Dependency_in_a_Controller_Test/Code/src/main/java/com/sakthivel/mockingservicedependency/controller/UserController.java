package com.sakthivel.mockingservicedependency.controller;

import com.sakthivel.mockingservicedependency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController( @Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/name")
    public String getUserName() {
        return userService.getUserName();
    }
}