<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionstore.model.Product" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Fashion Store</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/home.css">

</head>

<body>

<!-- Navbar -->

<jsp:include page="partials/navbar.jsp" />

<!-- Hero Section -->

<section class="hero">

    <div class="hero-content">

        <h1>Fashion Meets Style</h1>

        <p>
            Discover the latest fashion trends and premium collections.
        </p>

        <a href="products" class="shop-btn">
            Shop Now
        </a>

    </div>

</section>

<!-- Featured Products -->

<div class="container">

    <h2 class="section-title">
        Featured Products
    </h2>

    <div class="product-grid">

        <%
            List<Product> productList =
                (List<Product>) request.getAttribute("productList");

            if(productList != null) {

                for(Product product : productList) {
        %>

        <div class="product-card">
<img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>"
     alt="Product Image">

            <div class="product-info">

                <h3>
                    <%= product.getProductName() %>
                </h3>

                <p>
                    <%= product.getBrand() %>
                </p>

                <p>
                    Color: <%= product.getColor() %>
                </p>

                <p>
                    Size: <%= product.getSize() %>
                </p>

                <p class="price">
                    ₹<%= product.getPrice() %>
                </p>

            </div>

        </div>

        <%
                }
            }
        %>

    </div>

</div>

<!-- Footer -->

<jsp:include page="partials/footer.jsp" />

</body>
</html>