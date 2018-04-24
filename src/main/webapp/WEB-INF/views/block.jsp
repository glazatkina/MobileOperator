<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 24.04.2018
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Block information</title>
</head>
<body>
<h1>${block.blockedContract.phoneNumber}</h1>

<p>${block.startDate}</p>
<p>${block.endDate}</p>
<p>${block.blockingUser.name} ${block.blockingUser.surname} </p>
</body>
</html>
