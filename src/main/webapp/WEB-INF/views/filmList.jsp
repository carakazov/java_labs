<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form:form action="/ticket/add/${item.id}" method="get">
                <div>
                    Title: ${item.title}
                </div>
                <div>
                    <button type="submit">Купить билет</button>
                </div>
            </form:form>
        </div>
    </c:forEach>
</div>
</body>
</html>
