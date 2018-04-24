<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 23.04.2018
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tariffs</title>
</head>
<body>
<c:if test="${not empty tariffs}">
<c:forEach items="${tariffs}" var="tariff">
    <p>${tariff.name} - ${tariff.active}</p>
</c:forEach>
</c:if>
</body>
</html>
