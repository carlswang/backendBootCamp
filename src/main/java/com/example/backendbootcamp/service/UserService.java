package com.example.backendbootcamp.service;

import com.example.backendbootcamp.entity.User;
import com.example.backendbootcamp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser(User user) {
        userRepository.createUser(user);
        return user.getId();
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public List<User> deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }
}
