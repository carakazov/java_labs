<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 19.06.2021
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:forEach items="${list}" var="item">
        <div>
            Address: ${item.address}
        </div>
        <div>
            <a href="/ticket/cinemas/${item.id}">Films</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
