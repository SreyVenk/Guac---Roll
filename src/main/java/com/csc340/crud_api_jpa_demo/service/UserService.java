package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.User;
import com.csc340.crud_api_jpa_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Method to update an existing user
    public User updateUser(int id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
        user.setUserName(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRewardsPoints(userDetails.getRewardsPoints());
        user.setAccountStatus(userDetails.getAccountStatus());
        return userRepository.save(user);
    }

    // Method to delete a user by ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    // Method to update a user's account status (for SysAdmin functionalities)
    public User updateUserStatus(int id, String status) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
        user.setAccountStatus(status);
        return userRepository.save(user);
    }
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user) {
        return userRepository.save(user);
    }




}
