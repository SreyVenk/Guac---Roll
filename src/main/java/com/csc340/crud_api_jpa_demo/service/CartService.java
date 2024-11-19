package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Cart;
import com.csc340.crud_api_jpa_demo.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(int id, Cart cartDetails) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.setUserId(cartDetails.getUserId());
        cart.setCartItems(cartDetails.getCartItems());
        cart.setCreateAt(cartDetails.getCreateAt());
        return cartRepository.save(cart);
    }

    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}
