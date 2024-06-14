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
<h1>ALL Dojos : </h1>
<c:forEach items="${allDojos}" var="oneDojo">
    <p>Dojo Name is : ${oneDojo.name}</p>
</c:forEach>
<h1 class="col-2">Add A Dojo</h1>
<form:form action="/dojos/new" method="post" modelAttribute="newDojo" cssClass="flex-box">
    <p>
        <form:label path="name">Dojo Name : </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
