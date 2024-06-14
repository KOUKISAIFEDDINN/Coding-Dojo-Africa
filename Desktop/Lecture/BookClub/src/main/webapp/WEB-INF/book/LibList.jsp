<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${libs}" var="lib">
<c:out value="${lib.name}"/>
<c:forEach items="${lib.books}" var="book">
<li> <c:out value="${book.title }"/>
</c:forEach>
</c:forEach>
</body>
</html>