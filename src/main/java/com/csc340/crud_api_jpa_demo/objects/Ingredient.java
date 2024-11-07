package com.csc340.crud_api_jpa_demo.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @Column(nullable = false)
    private String itemName;
    private int numberInStock;
    private int pointsEarned;
    private int rewardsPrice;

    // Getters
    public int getIngredientId() {
        return ingredientId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getNumberInStock() { // Corrected method name
        return numberInStock;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public int getRewardsPrice() {
        return rewardsPrice;
    }

    // Setters
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setNumberInStock(int numberInStock) { // Corrected method name
        this.numberInStock = numberInStock;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public void setRewardsPrice(int rewardsPrice) {
        this.rewardsPrice = rewardsPrice;
    }
}
