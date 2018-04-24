<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 24.04.2018
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="/mobile_operator/registration">
    <input type="text" name="name"/ >
    <input type="text" name="surname"/ >
    <input type="text" name="adress"/ >
    <input type="text" name="passport"/ >
    <input type="text" name="email"/ >
    <input type="date" name="date_birth"/ >
    <input type="number" name="type_id"/>
    <input type="password" name="password"/>

    <input type="submit" value="Submit"/>
</form>
</body>
</html>
