<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 24.04.2018
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract Blockings</title>
</head>
<body>
    <c:forEach items="${blockings}" var="block">
        <p></p><a href="./contract_blockings/${block.id}">${block.blockedContract.phoneNumber}: ${block.startDate} - ${block.endDate}</a>
    </c:forEach>
</body>
</html>
