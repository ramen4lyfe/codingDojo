<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-sm mt-3">
	
	<div class="row s justify-content-between">
		<h1> Expense Details</h1>
		<a class="btn btn-outline-secondary" href="/expenses">Go Back</a>
	</div>
	
	<div class="row">
		<table class="table">
			<thead>
				<tr>
					<th>Expense Name:</th>
					<th>Expense Description:</th>
					<th>Vendor:</th>
					<th>Amount Spent:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${expensesDetails.name}"/></td>
					
					<td><c:out value="${expensesDetails.description}"/></td>
					
					<td><c:out value="${expensesDetails.vendor}"/></td>
					
					<td><c:out value="${expensesDetails.price}"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>