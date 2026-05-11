package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Product;

public interface ProductDAO {

    // Get All Products
    List<Product> getAllProducts();

    // Get Product By ID
    Product getProductById(int productId);

    // Get Products By Category
    List<Product> getProductsByCategory(int categoryId);

    // Search Products
    List<Product> searchProducts(String keyword);
}