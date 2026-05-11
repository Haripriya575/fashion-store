<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionstore.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Products</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/products.css">

</head>

<body>

<!-- Navbar -->

<jsp:include page="partials/navbar.jsp" />

<div class="products-container">

    <!-- Header -->

    <div class="products-header">

        <h1>
            Our Fashion Collection
        </h1>

        <p>
            Explore trendy outfits, footwear and accessories.
        </p>

    </div>

    <!-- Product Grid -->

    <div class="product-grid">

        <%
            List<Product> productList =
                (List<Product>) request.getAttribute("productList");

            if(productList != null) {

                for(Product product : productList) {
        %>

        <!-- Product Card -->

        <div class="product-card">

            <!-- Product Image -->

            <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>"
     alt="Product Image">
            <!-- Product Info -->

            <div class="product-info">

                <h3>
                    <%= product.getProductName() %>
                </h3>

                <p class="brand">
                    <%= product.getBrand() %>
                </p>

                <p>
                    Color:
                    <%= product.getColor() %>
                </p>

                <p>
                    Size:
                    <%= product.getSize() %>
                </p>

                <p class="price">
                    ₹<%= product.getPrice() %>
                </p>

            </div>

            <!-- View Details Button -->

            <a href="product-details?id=<%= product.getProductId() %>"
               class="view-btn">

                View Details

            </a>

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