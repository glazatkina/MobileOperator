<%@ page import="ru.tsystems.javaschool.mobile_operator.dto.OptionDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.tsystems.javaschool.mobile_operator.dto.OptionOptionDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: glaza_000
  Date: 24.04.2018
  Time: 6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Option</title>
</head>
<body>
<h1>${option.name}</h1>
<hr>
<p>${option.description}</p>
<p>${option.cost}</p>
<p>Price: $ ${option.cost} per ${option.measureDTO.name}</p>
<p>Connection price: $ ${option.priceConn}</p>
<hr>

<%
    OptionDTO optionDTO = (OptionDTO)request.getAttribute("option");
    List<OptionDTO> requiredOptions = new ArrayList<>();
    List<OptionDTO> unsupportedOptions = new ArrayList<>();

    for (OptionOptionDTO depend: optionDTO.getDependentOptions()) {
        if (!depend.isBinded()) {
            unsupportedOptions.add(depend.getMainOption());
        } else {
            requiredOptions.add(depend.getMainOption());
        }
    }

    if (!requiredOptions.isEmpty()) { %>
<p>Required options:</p>
<ul>
        <%for (OptionDTO option: requiredOptions) {%>
    <li><a href="../options/<%= option.getId()%>"><%= option.getName()%></a></li>
    <%}
    }
%>
</ul>

<%if (!unsupportedOptions.isEmpty()) { %>
<p>Unsupported options:</p>
<ul>
    <%for (OptionDTO option: unsupportedOptions) {%>
    <li><a href="../options/<%= option.getId()%>"><%= option.getName()%></a></li>
<%    }
} %>
</ul>
</body>
</html>
