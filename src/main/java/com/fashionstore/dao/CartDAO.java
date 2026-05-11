package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.CartItem;

public interface CartDAO {

    // Add Product To Cart

    boolean addToCart(CartItem cartItem);

    // Get Cart Items By User ID

    List<CartItem> getCartItemsByUserId(int userId);

    // Update Quantity

    boolean updateCartItemQuantity(int cartItemId,
                                   int quantity);

    // Remove Cart Item

    boolean removeCartItem(int cartItemId);

    // Clear Cart

    boolean clearCart(int userId);
}