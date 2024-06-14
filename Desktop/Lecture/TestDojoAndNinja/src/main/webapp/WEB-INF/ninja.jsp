<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/main.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<h1 class="col-2">Create Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="newNinjas">
    <p>
        <form:label path="dojo">Dojo : </form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo" items="${allDojos}" itemValue="id" itemLabel="name"/>
    </p>
    <p>
        <form:label path="firstName">First Name : </form:label>
        <form:errors path="firstName" />
        <form:input path="firstName" />
    </p>
    <p>
        <form:label path="lastName">Last Name : </form:label>
        <form:errors path="lastName" />
        <form:input path="lastName" />
    </p>
    <p>
        <form:label path="age">Age : </form:label>
        <form:errors path="age" />
        <form:input path="age" />
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
