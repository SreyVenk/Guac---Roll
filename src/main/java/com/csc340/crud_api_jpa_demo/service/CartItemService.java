package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.CartItem;
import com.csc340.crud_api_jpa_demo.repository.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(int id, CartItem cartItemDetails) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow();
        cartItem.setMenuItemId(cartItemDetails.getMenuItemId());
        cartItem.setCartId(cartItemDetails.getCartId());
        cartItem.setCreateAt(cartItemDetails.getCreateAt());
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    }
}
