<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Expense Details</title>
</head>
<body class="container mt-4">

<h2>Expense Details</h2>

<table class="table table-bordered">
    <tr>
        <td><b>Name:</b></td>
        <td>${expense.name}</td>
    </tr>
    <tr>
        <td><b>Vendor:</b></td>
        <td>${expense.vendor}</td>
    </tr>
    <tr>
        <td><b>Amount:</b></td>
        <td>$${expense.amount}</td>
    </tr>
    <tr>
        <td><b>Description:</b></td>
        <td>${expense.description}</td>
    </tr>
</table>

<a href="/expenses" class="btn btn-danger">Back to Expenses</a>

</body>
</html>
