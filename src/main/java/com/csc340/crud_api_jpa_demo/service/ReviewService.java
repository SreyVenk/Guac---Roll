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

    public List<Reviews> getReviewsByServiceId(int serviceId) {
        return reviewRepository.findByServiceId(serviceId);
    }

    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
    public Reviews saveReview(Reviews review) {
        return reviewRepository.save(review);
    }

}
