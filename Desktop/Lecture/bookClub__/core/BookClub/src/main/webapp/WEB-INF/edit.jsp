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
    <h1>Change Your Entry</h1>
    <a href="/books">Back To the Shelf</a>
    <form:form action="/books/${oneBook.id}/edit" method="post"
               modelAttribute="book">
        <input type="hidden" name="_method" value="put">
        <p>${oneBook.thoughts}</p>
        <p>
            <form:label path="title" >Title</form:label>
            <form:errors path="title"/>
            <form:input path="title" />
        </p>
        <p>
            <form:label path="author">Author</form:label>
            <form:errors path="author"/>
            <form:input path="author"  />
        </p>
        <p>
            <form:label path="toughts">My Thoughts</form:label>
            <form:errors path="toughts"/>
            <form:input path="toughts" />
        </p>

        <input type="submit" value="Submit" />
    </form:form>
</div>
</body>
</html>