<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>All Books</title>

    <!-- Link Bootstrap CSS via CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <style>
        .table {
            background-color: #000000;
            border: 4px solid #000000
        }

    </style>
</head>
<body class="container">
<h1>All Books</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Language</th>
        <th>Number of Pages</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td><a href="${pageContext.request.contextPath}/books/${book.id}">${book.title}</a></td>
            <td>${book.language}</td>
            <td>${book.numberOfPages}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
