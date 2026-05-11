package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Order;
import com.fashionstore.model.OrderItem;

public interface OrderDAO {

    // Place Order
    boolean placeOrder(Order order);

    // Get Orders By User ID
    List<Order> getOrdersByUserId(int userId);

    // Get Order By ID
    Order getOrderById(int orderId);

    // Get Order Items By Order ID
    List<OrderItem> getOrderItems(int orderId);
}