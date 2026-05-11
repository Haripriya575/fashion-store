
package com.fashionstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionstore.dao.CartDAO;
import com.fashionstore.model.CartItem;
import com.fashionstore.util.DBConnection;

public class CartDAOImpl implements CartDAO {

    private Connection connection;

    public CartDAOImpl() {

        connection = DBConnection.getConnection();
    }

    // Add To Cart

    @Override
    public boolean addToCart(CartItem cartItem) {

        boolean status = false;

        try {

            String query =
                "INSERT INTO cart_items(user_id, product_id, quantity) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1,
                    cartItem.getUserId());

            preparedStatement.setInt(2,
                    cartItem.getProductId());

            preparedStatement.setInt(3,
                    cartItem.getQuantity());

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // Get Cart Items By User ID

    @Override
    public List<CartItem> getCartItemsByUserId(int userId) {

        List<CartItem> cartItemList =
                new ArrayList<>();

        try {

            String query =
                "SELECT * FROM cart_items WHERE user_id = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, userId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while(resultSet.next()) {

                CartItem cartItem =
                        new CartItem();

                cartItem.setCartItemId(
                        resultSet.getInt("cart_item_id"));

                cartItem.setUserId(
                        resultSet.getInt("user_id"));

                cartItem.setProductId(
                        resultSet.getInt("product_id"));

                cartItem.setQuantity(
                        resultSet.getInt("quantity"));

                cartItemList.add(cartItem);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return cartItemList;
    }

    // Update Quantity

    @Override
    public boolean updateCartItemQuantity(int cartItemId,
                                          int quantity) {

        boolean status = false;

        try {

            String query =
                "UPDATE cart_items SET quantity = ? WHERE cart_item_id = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, quantity);

            preparedStatement.setInt(2, cartItemId);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // Remove Cart Item

    @Override
    public boolean removeCartItem(int cartItemId) {

        boolean status = false;

        try {

            String query =
                "DELETE FROM cart_items WHERE cart_item_id = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, cartItemId);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // Clear Cart

    @Override
    public boolean clearCart(int userId) {

        boolean status = false;

        try {

            String query =
                "DELETE FROM cart_items WHERE user_id = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, userId);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    
}

}