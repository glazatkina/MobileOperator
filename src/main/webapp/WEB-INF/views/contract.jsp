<%@ page import="ru.tsystems.javaschool.mobile_operator.entity.Contract" %>
<%@ page import="ru.tsystems.javaschool.mobile_operator.dto.ContractDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 22.04.2018
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<html>
<head>
    <title>Contract Information</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <h3 class="text-center">${contract.phoneNumber}

        <% ContractDTO contract = (ContractDTO)request.getAttribute("contract");
            if (contract.isActive()) {%>
            <span class="label label-success">Active</span>
        <%} else {%>
            <span class="label label-warning">Blocked</span>
        <%} %>
    </h3>
</div>

<div class="container">
    <p>Balance: ${contract.balance}</p>
    <p>Tariff: ${contract.tariff.name}<button class="btn btn-info
    <% if (contract.isActive()) {%>
    active
    <%} else {%>
    disabled
    <%} %>"> Edit </button></p>
    <p>Options: <button class="btn btn-info
    <% if (contract.isActive()) {%>
    active
    <%} else {%>
    disabled
    <%} %>">Edit</button></p>

    <button class="btn
        <% if (contract.isActive()) {%>
            btn-danger">Lock
        <%} else {%>
            btn-success">Unlock
        <%} %></button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
