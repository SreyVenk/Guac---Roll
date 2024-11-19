package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.User;
import com.csc340.crud_api_jpa_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find a user by ID
    public User findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    // Update a user's account status
    public User updateUserStatus(int id, String status) {
        User user = findById(id);
        user.setAccountStatus(status);
        return userRepository.save(user);
    }

    // Delete a user
    public void deleteUser(int id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
