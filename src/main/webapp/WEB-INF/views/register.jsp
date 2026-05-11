<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Register</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/register.css">

</head>

<body>

<!-- Navbar -->

<jsp:include page="partials/navbar.jsp" />

<div class="register-container">

    <div class="register-card">

        <h1>Create Account</h1>

        <p class="subtitle">
            Join FashionStore today.
        </p>

        <form action="register"
              method="post"
              onsubmit="return validateForm()">

            <!-- Full Name -->

            <div class="form-group">

                <label>Full Name</label>

                <input type="text"
                       name="fullName"
                       id="fullName"
                       placeholder="Enter your full name">

            </div>

            <!-- Email -->

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       id="email"
                       placeholder="Enter your email">

            </div>

            <!-- Phone -->

            <div class="form-group">

                <label>Phone</label>

                <input type="text"
                       name="phone"
                       id="phone"
                       placeholder="Enter your phone number">

            </div>

            <!-- Password -->

            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       id="password"
                       placeholder="Enter your password">

            </div>

            <!-- Address -->

            <div class="form-group">

                <label>Address</label>

                <textarea name="address"
                          id="address"
                          placeholder="Enter your address"></textarea>

            </div>

            <!-- Button -->

            <button type="submit" class="register-btn">
                Register
            </button>

        </form>

        <p class="login-link">

            Already have an account?

            <a href="login.jsp">
                Login
            </a>

        </p>

    </div>

</div>

<script
src="${pageContext.request.contextPath}/assets/js/register.js">
</script>

</body>
</html>