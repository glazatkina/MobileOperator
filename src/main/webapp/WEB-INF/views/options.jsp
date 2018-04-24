<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 24.04.2018
  Time: 6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Options</title>
</head>
<body>
<c:forEach items="${options}" var="option">
 <li><a href="./options/${option.id}">${option.name}</a></li>
</c:forEach>
</body>
</html>
