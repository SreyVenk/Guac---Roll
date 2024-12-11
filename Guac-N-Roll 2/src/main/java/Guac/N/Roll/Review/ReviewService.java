package Guac.N.Roll.Review;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
    public Review getReviewById(int reviewId){
        return reviewRepository.findById(reviewId).orElse(null);
    }
    public Review replyReview(int reviewId, String reply){
        Review review = getReviewById(reviewId);
        review.setComment(reply);

        return reviewRepository.save(review);
    }
}
