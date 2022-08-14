<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-sm mt-3">
	
	<div class="row justify-content-between">
		<h1> Edit Expense</h1>
		<a class="btn btn-outline-secondary" href="/">Go Back</a>
	</div>
	
	<div class="row">
		<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense" class="form">
		
			<input type="hidden" name="_method" value="put">
			<div class="form-group p-3">
				<form:label path="name">Name of Product(s):</form:label>
				<form:errors path="name" class="error"/>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			
			<div class="form-group p-3">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="error"/>
				<form:input path="description" type="text" class="form-control"/>
			</div>
			
			<div class="form-group p-3">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="error"/>
				<form:input path="vendor" type="text" class="form-control"/>
			</div>
			
			<div class="form-group p-3">
				<form:label path="price">Price:</form:label>
				<form:errors path="price" class="error"/>
				<form:input path="price" type="number" step="0.01" class="form-control"/>
			</div>
			
			<input type="submit" value="Update" class="btn btn-primary"/>
		</form:form>
	</div>
</div>


</body>
</html>