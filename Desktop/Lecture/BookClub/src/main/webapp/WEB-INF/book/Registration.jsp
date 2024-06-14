<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/main.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="d-flex justify-content-center gap-3 position-absolute top-50 start-50 translate-middle">
<div class="p-3 mb-2 bg-light text-dark border border-dark">

<h3>Registration</h3>
<form:form action="/register" method="post" modelAttribute="user">
        <form:label path="userName">userName</form:label>
    <p>
        <form:errors path="userName" />
        <form:input class="form-control" path="userName"/>
    </p>
        <form:label path="email">email</form:label>
    <p>
        <form:errors path="email"/>
        <form:input class="form-control" path="email"/>
    </p>
        <form:label path="password">password</form:label>
    <p>
        <form:errors path="password"/>
        <form:input type ="password" class="form-control" path="password"/>
    </p>
        <form:label path="confirm">confirm</form:label>
    <p>
        <form:errors path="confirm"/>     
        <form:input type ="password" class="form-control" path="confirm"/>
    </p>   

    <input type="submit" class="btn btn-outline-primary " value="Submit"/>
</form:form>
</div>
<div class="p-3 mb-2 bg-light text-dark border border-dark">

<h3>User Login</h3>
<form:form action="/login" method="post" modelAttribute="newLogin">
        <form:label path="email">email</form:label>
    <p>
        <form:errors path="email"/>
        <form:input  class="form-control" path="email"/>
    </p>
        <form:label path="password">password</form:label>
    <p>
        <form:errors path="password"/>
        <form:input class="form-control" type ="password" path="password"/>
    </p>
    <input type="submit" class="btn btn-outline-primary" value="Submit"/>
</form:form>
</div>
</div>
</body>
</html>