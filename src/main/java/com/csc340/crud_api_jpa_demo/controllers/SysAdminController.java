package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.Reviews;
import com.csc340.crud_api_jpa_demo.service.ReviewService;
import com.csc340.crud_api_jpa_demo.service.StatisticsService;
import com.csc340.crud_api_jpa_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysadmin")
public class SysAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private StatisticsService statisticsService;

    // Update User Status
    @PutMapping("/users/{id}/status")
    public String updateUserStatus(@PathVariable int id, @RequestParam String status) {
        userService.updateUserStatus(id, status);
        return "User status updated to " + status;
    }

    // Moderate Services: Get all reviews for a service
    @GetMapping("/services/{serviceId}/reviews")
    public List<Reviews> getReviewsByServiceId(@PathVariable int serviceId) {
        return reviewService.getReviewsByServiceId(serviceId);
    }

    // View Usage Statistics
    @GetMapping("/statistics")
    public List<?> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    // Edit Review
    @PutMapping("/reviews/{reviewId}")
    public String editReview(@PathVariable int reviewId, @RequestBody Reviews review) {
        reviewService.editReview(reviewId, review);
        return "Review updated successfully.";
    }

    // Delete Review
    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable int reviewId) {
        reviewService.deleteReview(reviewId);
        return "Review deleted successfully.";
    }

    // Add Reply to Review
    @PostMapping("/reviews/{reviewId}/reply")
    public String addReply(@PathVariable int reviewId, @RequestParam String reply) {
        reviewService.addReply(reviewId, reply);
        return "Reply added to the review.";
    }
}
