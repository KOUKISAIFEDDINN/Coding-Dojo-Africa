<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Save Travels</title>
</head>
<body class="container mt-4">

<h2>List of Expense</h2>
<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Name</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="expense" items="${expenses}">
        <tr>
            <td><a href="/expenses/${expense.id}">${expense.name}</a></td>
            <td>${expense.vendor}</td>
            <td>$${expense.amount}</td>
            <td>
                <a href="/expenses/edit/${expense.id}" class="btn btn-danger">Edit</a>
                <a href="/expenses/delete/${expense.id}" class="btn btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Add Expense Form -->
<h2>Add Expense</h2>
<form:form action="/expenses/add" method="post" modelAttribute="expense" class="mb-4">
    <div class="form-group">
        <form:label path="name">Name:</form:label>
        <form:input path="name" class="form-control" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" class="form-control" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="amount">Amount:</form:label>
        <form:input path="amount" type="number" step="0.01" class="form-control" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="description">Description:</form:label>
        <form:textarea path="description" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-danger">Save</button>
</form:form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
