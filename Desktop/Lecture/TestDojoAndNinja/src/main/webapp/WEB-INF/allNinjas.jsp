<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
</head>
<body>
<h1>Burbank Location Ninjas</h1>
<table>
    <thead>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age </th>
    </thead>
    <tbody>

    <c:forEach items="${allDojos.ninjas }" var="oneDojo">
        <tr>
            <td>${oneDojo.firstName }</td>
            <td>${oneDojo.lastName }</td>
            <td>${oneDojo.age }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>