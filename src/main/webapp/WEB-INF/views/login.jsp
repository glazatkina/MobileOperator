<%@ page import="ru.tsystems.javaschool.mobile_operator.dao.UserDAO" %>
<%@ page import="ru.tsystems.javaschool.mobile_operator.controller.UserController" %>
<%@ page import="ru.tsystems.javaschool.mobile_operator.controller.impl.UserControllerImpl" %><%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 24.04.2018
  Time: 7:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:useBean id="obj" class="ru.tsystems.javaschool.mobile_operator.entity.User"/>
<jsp:setProperty property="*" name="obj"/>

<%
    boolean isExist = UserControllerImpl.validate(obj);
%>
</body>
</html>
