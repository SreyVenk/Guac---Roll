package com.csc340.crud_api_jpa_demo.repository;

import com.csc340.crud_api_jpa_demo.objects.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
