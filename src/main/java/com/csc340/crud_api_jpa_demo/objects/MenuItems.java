package com.csc340.crud_api_jpa_demo.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column(nullable = false)
    private String itemName;
    private int price;
    private int pointsEarned;
    private int rewardsPrice;

    // Getters
    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public int getRewardsPrice() {
        return rewardsPrice;
    }

    public int getItemId() {
        return itemId;
    }

    // Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public void setRewardsPrice(int rewardsPrice) {
        this.rewardsPrice = rewardsPrice;
    }
}
