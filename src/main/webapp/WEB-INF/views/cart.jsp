<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionstore.model.CartItem" %>
<%@ page import="com.fashionstore.model.Product" %>
<%@ page import="com.fashionstore.dao.ProductDAO" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Cart</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/cart.css">

</head>

<body>

<!-- Navbar -->

<jsp:include page="partials/navbar.jsp" />

<div class="cart-container">

    <h1 class="cart-title">
        Shopping Cart
    </h1>

    <%
        List<CartItem> cartItemList =
            (List<CartItem>) request.getAttribute("cartItemList");

        ProductDAO productDAO =
            (ProductDAO) request.getAttribute("productDAO");

        double totalAmount = 0;
    %>

    <%
        if(cartItemList != null &&
           !cartItemList.isEmpty()) {

        	for(CartItem cartItem : cartItemList) {

        	    Product product =
        	        productDAO.getProductById(
        	                cartItem.getProductId());

        	    double subtotal =
        	        product.getPrice().doubleValue() *
        	        cartItem.getQuantity();

        	    totalAmount += subtotal;
    %>

    <!-- Cart Card -->

    <div class="cart-card">

        <!-- Product Image -->

        <div class="cart-image">

           <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>"
     alt="Product Image">
        </div>

        <!-- Product Details -->

        <div class="cart-details">

            <h2>
                <%= product.getProductName() %>
            </h2>

            <p>
                Brand:
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

            <p>
                Quantity:
                <%= cartItem.getQuantity() %>
            </p>

            <p class="price">
                ₹<%= product.getPrice() %>
            </p>

            <p class="subtotal">
                Subtotal:
                ₹<%= subtotal %>
            </p>

        </div>

    </div>

    <%
            }
    %>

    <!-- Total -->

    <div class="cart-total">

        <h2>
            Total Amount:
            ₹<%= totalAmount %>
        </h2>

       <a href="checkout"
   class="checkout-btn">

    Proceed To Checkout

</a>
    </div>

    <%
        } else {
    %>

    <!-- Empty Cart -->

    <div class="empty-cart">

        <h2>
            Your cart is empty
        </h2>

        <a href="products"
           class="shop-btn">

            Continue Shopping

        </a>

    </div>

    <%
        }
    %>

</div>

<!-- Footer -->

<jsp:include page="partials/footer.jsp" />

</body>
</html>