package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.Reviews;
import com.csc340.crud_api_jpa_demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342") // Adjust if your frontend runs on a different port
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Reviews> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Reviews getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public Reviews addReview(@RequestBody Reviews review) {
        return reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public Reviews editReview(@PathVariable int id, @RequestBody Reviews updatedReview) {
        return reviewService.editReview(id, updatedReview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}
