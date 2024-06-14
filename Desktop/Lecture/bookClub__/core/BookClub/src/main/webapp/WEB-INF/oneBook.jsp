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
    <h1>${oneBook.title}</h1>
    <a href="/books">Back To the Shelf</a>
    <c:choose >
        <c:when test="${oneBook.user.id ne sessionScope.user_id}">
            <p>${oneBook.user.userName} read ${oneBook.title} by${oneBook.author} .</p>
        </c:when>
        <c:otherwise>
            <p>you read And Here Your Thoughts</p>
        </c:otherwise>
    </c:choose>
    <p>Here are ${oneBook.user.userName}</p>
    <textarea rows="4" cols="50" readonly>
        ${oneBook.toughts}
    </textarea>
    <c:if test="${oneBook.user.id eq  sessionScope.user_id}">
        <button ><a href="/books/${oneBook.id}/edit">Edit</a></button>
        <form action="/books/${oneBook.id}/delete" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">
        </form>
    </c:if>
</div>
</body>
</html>