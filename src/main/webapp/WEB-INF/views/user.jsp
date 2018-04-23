<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Welcome, ${user.name} ${user.surname}!</h1>
    <table class="table table-hover table-striped">
        <tr><th>Phone Number</th><th>Balance</th></tr>
        <c:forEach items="${user.userContractsById}" var="contract">
            <tr><td><a href="../contracts/${contract.phoneNumber}">${contract.phoneNumber}</a></td><td>${contract.balance}</td></tr>
    </c:forEach>
    </table>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
