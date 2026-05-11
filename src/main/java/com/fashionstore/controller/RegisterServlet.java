package com.fashionstore.controller;

import java.io.IOException;

import com.fashionstore.dao.UserDAO;
import com.fashionstore.dao.impl.UserDAOImpl;
import com.fashionstore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get Form Data

        String fullName =
                request.getParameter("fullName");

        String email =
                request.getParameter("email");

        String phone =
                request.getParameter("phone");

        String password =
                request.getParameter("password");

        String address =
                request.getParameter("address");

        // Create User Object

        User user = new User();

        user.setFullName(fullName);

        user.setEmail(email);

        user.setPhone(phone);

        user.setPassword(password);

        user.setAddress(address);

        // DAO Object

        UserDAO userDAO = new UserDAOImpl();

        boolean status =
                userDAO.registerUser(user);

        // Redirect Based On Result

        if(status) {

            response.sendRedirect("login-page");

        } else {

            response.getWriter()
                    .println("Registration Failed");
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/register.jsp")
                .forward(request, response);
    }
}