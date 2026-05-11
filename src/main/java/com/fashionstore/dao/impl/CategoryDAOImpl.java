package com.fashionstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionstore.dao.CategoryDAO;
import com.fashionstore.model.Category;
import com.fashionstore.util.DBConnection;

public class CategoryDAOImpl implements CategoryDAO {

    private Connection connection;

    public CategoryDAOImpl() {

        connection = DBConnection.getConnection();
    }

    // Get All Categories
    @Override
    public List<Category> getAllCategories() {

        List<Category> categoryList = new ArrayList<>();

        try {

            String query = "SELECT * FROM categories";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Category category = new Category();

                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCreatedAt(resultSet.getTimestamp("created_at"));

                categoryList.add(category);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return categoryList;
    }

    // Get Category By ID
    @Override
    public Category getCategoryById(int categoryId) {

        Category category = null;

        try {

            String query = "SELECT * FROM categories WHERE category_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, categoryId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                category = new Category();

                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCreatedAt(resultSet.getTimestamp("created_at"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return category;
    }
}