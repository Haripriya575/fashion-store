package com.fashionstore.dao;

import com.fashionstore.model.User;

public interface UserDAO {

    // Register User
    boolean registerUser(User user);

    // Login User
    User loginUser(String email, String password);

    // Get User By ID
    User getUserById(int userId);

    // Update User Profile
    boolean updateUser(User user);
}