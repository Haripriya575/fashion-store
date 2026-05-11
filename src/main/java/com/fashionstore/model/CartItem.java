package com.fashionstore.model;

public class CartItem {

    private int cartItemId;

    private int userId;

    private int productId;

    private int quantity;

    // Default Constructor

    public CartItem() {

    }

    // Parameterized Constructor

    public CartItem(int cartItemId,
                    int userId,
                    int productId,
                    int quantity) {

        this.cartItemId = cartItemId;

        this.userId = userId;

        this.productId = productId;

        this.quantity = quantity;
    }

    // Getter And Setter Methods

    public int getCartItemId() {

        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {

        this.cartItemId = cartItemId;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public int getProductId() {

        return productId;
    }

    public void setProductId(int productId) {

        this.productId = productId;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }
}