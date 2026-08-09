<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
</head>

<body>

<h2>Login</h2>

<% if (request.getAttribute("message") != null) { %>

    <p style="color:green;">
        <%= request.getAttribute("message") %>
    </p>

<% } %>

<% if (request.getAttribute("error") != null) { %>

    <p style="color:red;">
        <%= request.getAttribute("error") %>
    </p>

<% } %>

<form action="${pageContext.request.contextPath}/login"
      method="post">

    Email:
    <input type="email" name="email" required>
    <br><br>

    Password:
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">
        Login
    </button>

</form>

<br>

<a href="${pageContext.request.contextPath}/register">
    Create new account
</a>

</body>

</html>