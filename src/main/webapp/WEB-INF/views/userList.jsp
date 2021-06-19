<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 19.06.2021
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${list.size() != 0}">
            <c:forEach items="${list}" var="item">
                <div>
                    Login: ${item.login}
                </div>
                <div>
                    Password: ${item.password}
                </div>
                <div>
                    <a href="/admin/delete/${item.login}">Delete user</a>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h1>Empty</h1>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
