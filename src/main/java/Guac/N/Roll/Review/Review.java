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

    @Column(nullable = false)
    private String comment;
    private int rating;
    private String providerReply;

    public Review(int reviewId, String customerName, String comment, int rating, String providerReply) {
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.comment = comment;
        this.rating = rating;
        this.providerReply = providerReply;
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
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public String getCustomerName(){
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
    public String getProviderReply(){
        return providerReply;
    }
    public void setProviderReply(String providerReply) {
        this.providerReply = providerReply;
    }
}
