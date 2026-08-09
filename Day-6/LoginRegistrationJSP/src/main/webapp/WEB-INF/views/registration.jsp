<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>

<body>

<h2>Create Account</h2>

<% if (request.getAttribute("error") != null) { %>

    <p style="color:red;">
        <%= request.getAttribute("error") %>
    </p>

<% } %>

<form action="${pageContext.request.contextPath}/register"
      method="post">

    Name:
    <input type="text" name="name" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    Password:
    <input type="password" name="password" required>
    <br><br>

    Mobile:
    <input type="text" name="mobile" required>
    <br><br>

    City:
    <input type="text" name="city" required>
    <br><br>

    <button type="submit">
        Register
    </button>

</form>

<br>

<a href="${pageContext.request.contextPath}/login">
    Already have an account? Login
</a>

</body>
</html>