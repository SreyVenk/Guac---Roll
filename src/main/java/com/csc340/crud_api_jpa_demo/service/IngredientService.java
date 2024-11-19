package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Ingredient;
import com.csc340.crud_api_jpa_demo.repository.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(int id, Ingredient ingredientDetails) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();
        ingredient.setItemName(ingredientDetails.getItemName());
        ingredient.setNumberInStock(ingredientDetails.getNumberInStock()); // Updated method
        ingredient.setPointsEarned(ingredientDetails.getPointsEarned());
        ingredient.setRewardsPrice(ingredientDetails.getRewardsPrice());
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(int id) {
        ingredientRepository.deleteById(id);
    }
}
