<%--
  Created by IntelliJ IDEA.
  User: Anisr
  Date: 02/02/2024
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Rendering Books</title>
</head>
<body>
<h1>Book Details</h1>
<h3> ${book.title}</h3>
<p>Description: ${book.description}</p>
<p>Language: ${book.language}</p>
<p>Number of Pages: ${book.numberOfPages}</p>

</body>
</html>
