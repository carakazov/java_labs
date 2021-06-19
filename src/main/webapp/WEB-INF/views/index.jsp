<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 19.06.2021
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/registration">Registration</a>
</div>
<div>
    Hello: ${login}
</div>
<div>
    <a href="/ticket/cinemas">Cinemas</a>
</div>
<div>
    <c:forEach items="${tickets}" var="item">
        <div>
            Film: ${item.film.title}
        </div>
        <div>
            Cinema: ${item.cinema.address}
        </div>
    </c:forEach>
</div>
</body>
</html>
