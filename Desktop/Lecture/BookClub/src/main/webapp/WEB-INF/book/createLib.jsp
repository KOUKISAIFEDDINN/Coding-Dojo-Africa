<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Create library</h1>
<form:form action="/library" method="post" modelAttribute="library">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name" />
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="location">location</form:label>
        <form:errors path="location"/>
        <form:input path="location"/>
    </p>
     <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>