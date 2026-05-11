<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.fashionstore.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Product Details</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/product-details.css">

</head>

<body>

<!-- Navbar -->

<jsp:include page="partials/navbar.jsp" />

<%
    Product product =
            (Product) request.getAttribute("product");
%>

<div class="details-container">

    <div class="details-card">

        <!-- Product Image -->

        <div class="details-image">

           <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>"
     alt="Product Image">
        </div>

        <!-- Product Info -->

        <div class="details-info">

            <h1>
                <%= product.getProductName() %>
            </h1>

            <p class="brand">
                Brand: <%= product.getBrand() %>
            </p>

            <p class="price">
                ₹<%= product.getPrice() %>
            </p>

            <p class="description">
                <%= product.getDescription() %>
            </p>

            <p>
                <strong>Color:</strong>
                <%= product.getColor() %>
            </p>

            <p>
                <strong>Size:</strong>
                <%= product.getSize() %>
            </p>

            <p>
                <strong>Stock:</strong>
                <%= product.getStockQuantity() %>
            </p>

            <form action="cart" method="post">

    <!-- Hidden Product ID -->

    <input type="hidden"
           name="productId"
           value="<%= product.getProductId() %>">

    <!-- Add To Cart Button -->

    <button type="submit"
            class="cart-btn">

        Add To Cart

    </button>

</form>

        </div>

    </div>

</div>

<!-- Footer -->

<jsp:include page="partials/footer.jsp" />

</body>
</html>