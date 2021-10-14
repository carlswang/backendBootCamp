package com.example.backendbootcamp.controller;

import com.example.backendbootcamp.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
