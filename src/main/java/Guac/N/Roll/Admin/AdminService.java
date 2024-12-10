package Guac.N.Roll.Admin;

import Guac.N.Roll.User.User;
import Guac.N.Roll.User.UserRepository;
import Guac.N.Roll.Review.Review;
import Guac.N.Roll.Review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // Ban a user
    public boolean banUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBanned(true); // Assuming a `banned` field exists in the User entity
            userRepository.save(user);
            return true;
        }
        return false;
    }

    // Unban a user
    public boolean unbanUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBanned(false); // Assuming a `banned` field exists in the User entity
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean suspendUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setSuspended(true); // Mark user as suspended
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean unsuspendUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setSuspended(false); // Remove suspension
            userRepository.save(user);
            return true;
        }
        return false;
    }

    // Edit a review
    public boolean editReview(int reviewId, String newComment, int newRating) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setComment(newComment);
            review.setRating(newRating);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    // Delete a review
    public boolean deleteReview(int reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    // Get statistics
    public long getUserCount() {
        return userRepository.count();
    }

    public long getProviderCount() {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().contains("provider")) // Assuming providers are identified by email
                .count();
    }

    public boolean isUserBanned(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(User::isBanned).orElse(false);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll(); // Retrieve all users from the database
    }
}
