<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Edit Expense</title>
</head>
<body class="container mt-4">

<h2>Edit Expense</h2>

<form:form modelAttribute="expense" action="/expenses/edit/${expense.id}" method="post">

    <div class="form-group">
        <label for="name">Name:</label>
        <form:input path="name" value="${expense.name}" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="vendor">Vendor:</label>
        <form:input path="vendor" value="${expense.vendor}" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="amount">Amount:</label>
        <form:input path="amount" value="${expense.amount}" type="number" step="0.01" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="description">Description:</label>
        <form:textarea path="description" value="${expense.description}" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>

<a href="/expenses" class="btn btn-danger">Back to Expenses</a>

</body>
</html>
