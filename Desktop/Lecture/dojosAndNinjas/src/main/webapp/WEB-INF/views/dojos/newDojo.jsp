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
<h2>Create New Dojo</h2>
<form action="<%= request.getContextPath() %>/dojos/new" method="post">
    <label for="name">Dojo Name:</label>
    <input type="text" id="name" name="name" required>
    <button type="submit">Create</button>
</form>
</body>
</html>
