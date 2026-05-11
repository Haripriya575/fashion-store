<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Login</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/login.css">

</head>

<body>

<!-- Navbar -->

<jsp:include page="partials/navbar.jsp" />

<div class="login-container">

    <div class="login-card">

        <h1>Welcome Back</h1>

        <p class="subtitle">
            Login to continue shopping.
        </p>

        <form action="login"
              method="post"
              onsubmit="return validateLoginForm()">

            <!-- Email -->

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       id="email"
                       placeholder="Enter your email">

            </div>

            <!-- Password -->

            <div class="form-group">

                <label>Password</label>

                <input type="password"
                       name="password"
                       id="password"
                       placeholder="Enter your password">

            </div>

            <!-- Button -->

            <button type="submit" class="login-btn">
                Login
            </button>

        </form>

        <p class="register-link">

            Don't have an account?

            <a href="register.jsp">
                Register
            </a>

        </p>

    </div>

</div>

<script
src="${pageContext.request.contextPath}/assets/js/login.js">
</script>

</body>
</html>