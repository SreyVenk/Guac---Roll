package Guac.N.Roll.Review;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;


    @Column(nullable = false)
    private String customerName;
    private String comment;
    private int rating;

    public Review(int reviewId, String customerName, String comment, int rating) {
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.comment = comment;
        this.rating = rating;
    }
    public Review(String customerName, String comment, int rating) {
        this.customerName = customerName;
        this.comment = comment;
        this.rating = rating;
    }
    public Review() {
    }
    public int getReviewId(){
        return reviewId;
    }
    public void setReviewIdId(int reviewId) {
        this.reviewId = reviewId;
    }
    public String getCustomerNameName(){
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
