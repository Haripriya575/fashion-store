package com.fashionstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionstore.dao.ProductDAO;
import com.fashionstore.model.Product;
import com.fashionstore.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

    private Connection connection;

    public ProductDAOImpl() {

        connection = DBConnection.getConnection();
    }

    // Get All Products
    @Override
    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();

        try {

            String query = "SELECT * FROM products";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Product product = new Product();

                product.setProductId(resultSet.getInt("product_id"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setBrand(resultSet.getString("brand"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setStockQuantity(resultSet.getInt("stock_quantity"));
                product.setSize(resultSet.getString("size"));
                product.setColor(resultSet.getString("color"));
                product.setImageUrl(resultSet.getString("image_url"));
                product.setCreatedAt(resultSet.getTimestamp("created_at"));

                productList.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productList;
    }

    // Get Product By ID
    @Override
    public Product getProductById(int productId) {

        Product product = null;

        try {

            String query = "SELECT * FROM products WHERE product_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                product = new Product();

                product.setProductId(resultSet.getInt("product_id"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setBrand(resultSet.getString("brand"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setStockQuantity(resultSet.getInt("stock_quantity"));
                product.setSize(resultSet.getString("size"));
                product.setColor(resultSet.getString("color"));
                product.setImageUrl(resultSet.getString("image_url"));
                product.setCreatedAt(resultSet.getTimestamp("created_at"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return product;
    }

    // Get Products By Category
    @Override
    public List<Product> getProductsByCategory(int categoryId) {

        List<Product> productList = new ArrayList<>();

        try {

            String query = "SELECT * FROM products WHERE category_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, categoryId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Product product = new Product();

                product.setProductId(resultSet.getInt("product_id"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setBrand(resultSet.getString("brand"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setStockQuantity(resultSet.getInt("stock_quantity"));
                product.setSize(resultSet.getString("size"));
                product.setColor(resultSet.getString("color"));
                product.setImageUrl(resultSet.getString("image_url"));
                product.setCreatedAt(resultSet.getTimestamp("created_at"));

                productList.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productList;
    }

    // Search Products
    @Override
    public List<Product> searchProducts(String keyword) {

        List<Product> productList = new ArrayList<>();

        try {

            String query = "SELECT * FROM products WHERE product_name LIKE ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "%" + keyword + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Product product = new Product();

                product.setProductId(resultSet.getInt("product_id"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setBrand(resultSet.getString("brand"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setStockQuantity(resultSet.getInt("stock_quantity"));
                product.setSize(resultSet.getString("size"));
                product.setColor(resultSet.getString("color"));
                product.setImageUrl(resultSet.getString("image_url"));
                product.setCreatedAt(resultSet.getTimestamp("created_at"));

                productList.add(product);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productList;
    }
}