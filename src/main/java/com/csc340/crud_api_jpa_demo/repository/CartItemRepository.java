package com.csc340.crud_api_jpa_demo.repository;

import com.csc340.crud_api_jpa_demo.objects.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // Additional query methods can be defined here if needed
}
