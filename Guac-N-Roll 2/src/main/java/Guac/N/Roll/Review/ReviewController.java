package Guac.N.Roll.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @GetMapping("/{reviewId}")
    public Review getOneReview(@PathVariable int reviewId){
        return reviewService.getReviewById(reviewId);
    }
    @PutMapping("/reply/{reviewId}")
    public Review replyReview(@PathVariable int reviewId, @RequestBody String reply){
        reviewService.replyReview(reviewId, reply);
        return reviewService.getReviewById(reviewId);
    }
}
