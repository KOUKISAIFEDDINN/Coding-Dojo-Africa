<%--
  Created by IntelliJ IDEA.
  User: Anisr
  Date: 03/02/2024
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Show Dojo</h2>
<h3>Dojo Name: ${dojo.name}</h3>
<h3>Ninjas:</h3>
<ul>
    <c:forEach var="ninja" items="${dojo.ninjas}">
        <li>${ninja.firstName} ${ninja.lastName}</li>
    </c:forEach>
</ul>
</body>
</html>
