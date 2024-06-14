<%--
  Created by IntelliJ IDEA.
  User: Anisr
  Date: 03/02/2024
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Boot Dojo-Ninja App</title>
</head>
<body>
<div>
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath() %>/dojos/new">New Dojo</a></li>
            <li><a href="<%= request.getContextPath() %>/ninjas/new">New Ninja</a></li>
            <li><a href="<%= request.getContextPath() %>/ninjas/showAll">Show All Ninjas</a></li>
        </ul>
    </nav>
    <div>
        <%@ include file="dojos/newDojo.jsp" %>
    </div>
</div>
</body>
</html>
