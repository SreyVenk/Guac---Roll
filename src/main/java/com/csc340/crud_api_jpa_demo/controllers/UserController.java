package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.User;
import com.csc340.crud_api_jpa_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        // Find the user by ID
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }

        // Update fields
        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setRewardsPoints(updatedUser.getRewardsPoints());
        user.setAccountStatus(updatedUser.getAccountStatus());

        // Save updated user
        userService.saveUser(user);
        return ResponseEntity.ok(user); // Return updated user
    }
}
