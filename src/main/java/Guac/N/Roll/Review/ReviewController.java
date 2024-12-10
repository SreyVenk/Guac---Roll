package Guac.N.Roll.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "provider_reviews"; // For providers
    }

    @PostMapping("/{reviewId}/reply")
    public String replyReview(@PathVariable int reviewId, @RequestParam("reply") String reply) {
        reviewService.replyReview(reviewId, reply);
        return "redirect:/reviews";
    }
    // Show the review submission form
    @GetMapping("/submit")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "submit_review"; // Points to submit_review.html
    }

    // Handle review submission and redirect to the review listing page
    @PostMapping("/submit")
    public String submitReview(@ModelAttribute("review") Review review) {
        reviewService.addReview(review);
        return "redirect:/reviews/view"; // Redirect to the view reviews page
    }

    // Show the page with all reviews
    @GetMapping("/view")
    public String showAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "view_reviews"; // Points to view_reviews.html
    }
}
