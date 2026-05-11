package com.fashionstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fashionstore.dao.ProductDAO;
import com.fashionstore.dao.impl.ProductDAOImpl;
import com.fashionstore.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test-products")
public class TestProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        ProductDAO productDAO = new ProductDAOImpl();

        List<Product> productList = productDAO.getAllProducts();

        out.println("<h1>Product List</h1>");

        for (Product product : productList) {

            out.println("<hr>");

            out.println("<h3>" + product.getProductName() + "</h3>");

            out.println("<p>Brand: " + product.getBrand() + "</p>");

            out.println("<p>Price: ₹" + product.getPrice() + "</p>");

            out.println("<p>Color: " + product.getColor() + "</p>");

            out.println("<p>Size: " + product.getSize() + "</p>");
        }
    }
}