package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.User;
import com.csc340.crud_api_jpa_demo.objects.Reviews;
import com.csc340.crud_api_jpa_demo.objects.Statistics;
import com.csc340.crud_api_jpa_demo.service.UserService;
import com.csc340.crud_api_jpa_demo.service.ServiceService;
import com.csc340.crud_api_jpa_demo.service.ReviewService;
import com.csc340.crud_api_jpa_demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SysAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private StatisticsService statisticsService;

    // Manage User Access: Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Update User Status
    @PutMapping("/users/{id}/status")
    public User updateUserStatus(@PathVariable int id, @RequestParam String status) {
        return userService.updateUserStatus(id, status);
    }

    // Moderate Services: Get all reviews for a service
    @GetMapping("/services/{serviceId}/reviews")
    public List<Reviews> getReviewsByService(@PathVariable int serviceId) {
        return reviewService.getReviewsByServiceId(serviceId);
    }

    // View Usage Statistics
    @GetMapping("/statistics")
    public List<Statistics> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    // Delete a Service
    @DeleteMapping("/services/{serviceId}")
    public void deleteService(@PathVariable int serviceId) {
        serviceService.deleteService(serviceId);
    }

    // Moderate Reviews: Get all reviews
    @GetMapping("/reviews")
    public List<Reviews> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Delete a Review
    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewService.deleteReview(reviewId);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }



}
