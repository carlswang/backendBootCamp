package com.example.backendbootcamp.controller;

import com.example.backendbootcamp.entity.User;
import com.example.backendbootcamp.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public Long createUser(@RequestBody User user) {
        userService.createUser(user);
        return user.getId();
    }

    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
}
