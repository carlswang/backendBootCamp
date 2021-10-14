package com.example.backendbootcamp.repository;

import com.example.backendbootcamp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    private Long createUser(User user) {
        userList.add(user);
        return user.getId();
    }
}
