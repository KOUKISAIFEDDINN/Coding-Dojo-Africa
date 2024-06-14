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
<h2>Create New Ninja</h2>
<form action="<%= request.getContextPath() %>/ninjas/new" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required>
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required>
    <label for="dojo">Dojo:</label>
    <select id="dojo" name="dojo">
        <c:forEach var="dojo" items="${dojos}">
            <option value="${dojo.id}">${dojo.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Create</button>
</form>
</body>
</html>
