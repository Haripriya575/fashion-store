package com.fashionstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionstore.dao.OrderDAO;
import com.fashionstore.model.Order;
import com.fashionstore.model.OrderItem;
import com.fashionstore.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    private Connection connection;

    public OrderDAOImpl() {

        connection = DBConnection.getConnection();
    }

    // Place Order
    @Override
    public boolean placeOrder(Order order) {

        boolean status = false;

        try {

            String query = "INSERT INTO orders(user_id, total_amount, payment_method, order_status, delivery_address) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setBigDecimal(2, order.getTotalAmount());
            preparedStatement.setString(3, order.getPaymentMethod());
            preparedStatement.setString(4, order.getOrderStatus());
            preparedStatement.setString(5, order.getDeliveryAddress());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                status = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // Get Orders By User ID
    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> orderList = new ArrayList<>();

        try {

            String query = "SELECT * FROM orders WHERE user_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Order order = new Order();

                order.setOrderId(resultSet.getInt("order_id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setTotalAmount(resultSet.getBigDecimal("total_amount"));
                order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setOrderStatus(resultSet.getString("order_status"));
                order.setDeliveryAddress(resultSet.getString("delivery_address"));
                order.setOrderDate(resultSet.getTimestamp("order_date"));

                orderList.add(order);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return orderList;
    }

    // Get Order By ID
    @Override
    public Order getOrderById(int orderId) {

        Order order = null;

        try {

            String query = "SELECT * FROM orders WHERE order_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                order = new Order();

                order.setOrderId(resultSet.getInt("order_id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setTotalAmount(resultSet.getBigDecimal("total_amount"));
                order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setOrderStatus(resultSet.getString("order_status"));
                order.setDeliveryAddress(resultSet.getString("delivery_address"));
                order.setOrderDate(resultSet.getTimestamp("order_date"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return order;
    }

    // Get Order Items By Order ID
    @Override
    public List<OrderItem> getOrderItems(int orderId) {

        List<OrderItem> orderItemList = new ArrayList<>();

        try {

            String query = "SELECT * FROM order_items WHERE order_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                OrderItem orderItem = new OrderItem();

                orderItem.setOrderItemId(resultSet.getInt("order_item_id"));
                orderItem.setOrderId(resultSet.getInt("order_id"));
                orderItem.setProductId(resultSet.getInt("product_id"));
                orderItem.setQuantity(resultSet.getInt("quantity"));
                orderItem.setPrice(resultSet.getBigDecimal("price"));

                orderItemList.add(orderItem);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return orderItemList;
    }
}