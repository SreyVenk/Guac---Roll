package Guac.N.Roll.Admin;

import Guac.N.Roll.User.User;
import Guac.N.Roll.Review.Review;
import Guac.N.Roll.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ReviewService reviewService;

    // Dashboard
    @GetMapping("/dashboard")
    public String showAdminDashboard(Model model) {
        model.addAttribute("userCount", adminService.getUserCount());
        model.addAttribute("providerCount", adminService.getProviderCount());
        return "admin_dashboard"; // Points to admin_dashboard.html
    }

    @PostMapping("/users/ban")
    public String banUser(@RequestParam Long userId) {
        adminService.banUser(userId);
        return "redirect:/admin/users/manage";
    }

    @PostMapping("/users/unban")
    public String unbanUser(@RequestParam Long userId) {
        adminService.unbanUser(userId);
        return "redirect:/admin/users/manage";
    }

    @PostMapping("/users/suspend")
    public String suspendUser(@RequestParam Long userId) {
        adminService.suspendUser(userId);
        return "redirect:/admin/users/manage";
    }

    @PostMapping("/users/unsuspend")
    public String unsuspendUser(@RequestParam Long userId) {
        adminService.unsuspendUser(userId);
        return "redirect:/admin/users/manage";
    }

    // Manage Reviews
    @GetMapping("/reviews/manage")
    public String manageReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "admin_manage_reviews"; // Corresponds to admin_manage_reviews.html
    }

    // Show edit review form
    @GetMapping("/reviews/edit/{reviewId}")
    public String editReviewForm(@PathVariable int reviewId, Model model) {
        Review review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
        return "admin_edit_review"; // Corresponds to admin_edit_review.html
    }

    // Edit a review
    @PostMapping("/reviews/edit/{reviewId}")
    public String editReview(@PathVariable int reviewId,
                             @RequestParam("comment") String comment,
                             @RequestParam("rating") int rating) {
        adminService.editReview(reviewId, comment, rating);
        return "redirect:/admin/reviews/manage";
    }

    // Delete a review
    @PostMapping("/reviews/delete/{reviewId}")
    public String deleteReview(@PathVariable int reviewId) {
        adminService.deleteReview(reviewId);
        return "redirect:/admin/reviews/manage";
    }

    @GetMapping("/users/manage")
    public String manageUsers(Model model) {
        List<User> users = adminService.getAllUsers();
        model.addAttribute("users", users); // Adding the users list to the model
        return "manage_users"; // Corresponds to manage_users.html
    }

    @GetMapping("/statistics")
    public String viewStatistics(Model model) {
        model.addAttribute("userCount", adminService.getUserCount());
        model.addAttribute("providerCount", adminService.getProviderCount());
        model.addAttribute("users", adminService.getAllUsers()); // Adding user details
        return "admin_statistics"; // Corresponds to admin_statistics.html
    }

    @GetMapping("/home")
    public String showAdminHomePage() {
        return "admin_home"; // Corresponds to admin_home.html
    }
}
