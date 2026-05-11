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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get Form Data

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        // DAO Object

        UserDAO userDAO = new UserDAOImpl();

        // Validate User

        User user =
                userDAO.loginUser(email, password);

        if(user != null) {

            // Create Session

            HttpSession session =
                    request.getSession();

            session.setAttribute("loggedInUser", user);

            // Redirect To Home

            response.sendRedirect("home");

        } else {

            response.getWriter()
                    .println("Invalid Email or Password");
        }
    }
}
