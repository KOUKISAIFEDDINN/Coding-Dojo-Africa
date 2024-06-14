<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
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

</head>
<body>
<div class="container">
    <h1>Add A Book To your shelf</h1>
    <a href="/books">Back To the Shelf</a>
    <form:form action="/books/create" method="post"
               modelAttribute="book">
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title" />
        </p>
        <p>
        <form:label path="author">Author</form:label>
        <form:errors path="author"/>
        <form:input path="author" />
        </p>
        <p>
            <form:label path="toughts">Toughts</form:label>
            <form:errors path="toughts"/>
            <form:textarea path="toughts" cols="60" rows="5"/>
        </p>
        <input type="submit" value="Submit" />
    </form:form>
</div>
</body>
</html>