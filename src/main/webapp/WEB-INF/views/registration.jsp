<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 19.06.2021
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form action="/registration" modelAttribute="user" method="post">
    <div>
        <form:input path="login"/>
    </div>
    <div>
        <form:input path="password"/>
    </div>
    <div>
        <button type="submit">Create user</button>
    </div>
</form:form>
</body>
</html>
