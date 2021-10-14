package com.example.backendbootcamp.repository;

import com.example.backendbootcamp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public Long createUser(User user) {
        userList.add(user);
        return user.getId();
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public User findUserById(Long id) {
        return userList.stream().filter(item -> (item.getId().equals(id))).collect(Collectors.toList()).get(0);
    }

    public List<User> deleteUserById(Long id) {
        userList.remove(findUserById(id));
        return userList;
    }
}
