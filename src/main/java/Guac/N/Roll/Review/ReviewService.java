package Guac.N.Roll.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return (reviews != null) ? reviews : new ArrayList<>();
    }

    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public Review replyReview(int reviewId, String reply) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setProviderReply(reply);
            return reviewRepository.save(review);
        }
        return null;
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public void updateReview(int reviewId, String comment, int rating) {
        Review review = getReviewById(reviewId);
        if (review != null) {
            review.setComment(comment);
            review.setRating(rating);
            reviewRepository.save(review);
        }
    }

    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
