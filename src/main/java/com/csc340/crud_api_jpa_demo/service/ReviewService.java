package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Reviews;
import com.csc340.crud_api_jpa_demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get all reviews by service ID
    public List<Reviews> getReviewsByServiceId(int serviceId) {
        return reviewRepository.findByServiceId(serviceId);
    }

    public Reviews getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + reviewId));
    }

    public Reviews addReview(Reviews review) {
        return reviewRepository.save(review);
    }

    public Reviews editReview(int reviewId, Reviews updatedReview) {
        Reviews existingReview = getReviewById(reviewId);

        // Update only the fields provided, preserving others
        if (updatedReview.getDetails() != null) {
            existingReview.setDetails(updatedReview.getDetails());
        }
        if (updatedReview.getRating() != null) { // Handles null ratings
            existingReview.setRating(updatedReview.getRating());
        }
        if (updatedReview.getReply() != null) {
            existingReview.setReply(updatedReview.getReply());
        }
        if (updatedReview.getStatus() != null) {
            existingReview.setStatus(updatedReview.getStatus());
        }

        return reviewRepository.save(existingReview);
    }

    public void deleteReview(int reviewId) {
        Reviews review = getReviewById(reviewId);
        reviewRepository.delete(review);
    }

    // Add a reply to a review
    public Reviews addReply(int reviewId, String reply) {
        Reviews review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + reviewId));
        review.setReply(reply);
        return reviewRepository.save(review);
    }
}
