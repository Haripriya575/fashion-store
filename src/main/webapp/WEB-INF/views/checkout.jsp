<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Checkout</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/checkout.css">

</head>

<body>

<jsp:include page="partials/navbar.jsp" />

<div class="checkout-container">

    <div class="checkout-card">

        <h1>
            Checkout
        </h1>

        <p>
            Your order has been placed successfully.
        </p>

        <a href="products"
           class="shop-btn">

            Continue Shopping

        </a>

    </div>

</div>

<jsp:include page="partials/footer.jsp" />

</body>
</html>