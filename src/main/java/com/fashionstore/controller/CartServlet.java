package com.fashionstore.controller;

import java.io.IOException;
import java.util.List;

import com.fashionstore.dao.CartDAO;
import com.fashionstore.dao.ProductDAO;
import com.fashionstore.dao.impl.CartDAOImpl;
import com.fashionstore.dao.impl.ProductDAOImpl;
import com.fashionstore.model.CartItem;
import com.fashionstore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Open Cart Page

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // Check Login

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login-page");

            return;
        }

        // Logged In User

        User user =
                (User) session.getAttribute("loggedInUser");

        int userId =
                user.getUserId();

        // DAO Objects

        CartDAO cartDAO =
                new CartDAOImpl();

        ProductDAO productDAO =
                new ProductDAOImpl();

        // Fetch Cart Items

        List<CartItem> cartItemList =
                cartDAO.getCartItemsByUserId(userId);

        // Send Data To JSP

        request.setAttribute("cartItemList",
                             cartItemList);

        request.setAttribute("productDAO",
                             productDAO);

        // Open Cart JSP

        request.getRequestDispatcher(
                "/WEB-INF/views/cart.jsp")
                .forward(request, response);
    }

    // Add Product To Cart

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // Check Login

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login-page");

            return;
        }

        // Logged In User

        User user =
                (User) session.getAttribute("loggedInUser");

        int userId =
                user.getUserId();

        // Product ID

        int productId =
                Integer.parseInt(
                        request.getParameter("productId"));

        // Create Cart Item

        CartItem cartItem =
                new CartItem();

        cartItem.setUserId(userId);

        cartItem.setProductId(productId);

        cartItem.setQuantity(1);

        // Add To Cart

        CartDAO cartDAO =
                new CartDAOImpl();

        cartDAO.addToCart(cartItem);

        // Redirect To Cart

        response.sendRedirect("cart");
    }
}