package com.fashionstore.dao;

import java.util.List;

import com.fashionstore.model.Category;

public interface CategoryDAO {

    // Get All Categories
    List<Category> getAllCategories();

    // Get Category By ID
    Category getCategoryById(int categoryId);
}