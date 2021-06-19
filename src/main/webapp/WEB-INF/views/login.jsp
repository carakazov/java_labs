<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 19.06.2021
  Time: 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Welcome!</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div>
        <label>
            <input type="text" name="login" placeholder="Login"/>
        </label>
    </div>
    <div>
        <label>
            <input type="password" name="password" placeholder="Password"/>
        </label>
    </div>
    <div>
        <label>
            <button type="submit" class="button-primary">Submit</button>
        </label>
    </div>
</form>
</body>
</html>
