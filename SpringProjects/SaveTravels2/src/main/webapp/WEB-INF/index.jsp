<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-md bg-light p-3">
		<div class="row">
			<h1>Save Travels</h1>
		
			<table class="table">
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
				</tr>
				
				<c:forEach var="eachExpense" items="${expenses}">
				
				<tr>
					<td><a href="/expenses/${eachExpense.id}"><c:out value="${eachExpense.name}"/></a></td>
				
					<td><c:out value="${eachExpense.vendor}"/></td>
					
					<td>$<c:out value="${eachExpense.price}"/></td>
					
					<td><a href="/edit/<c:out value="${eachExpense.id}"/>">edit</a> 
						<form action="/expenses/${eachExpense.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="btn-danger">
					</form>
					</td>
				</tr>
				
				</c:forEach>
			
			</table>
		</div>	
		
		<div class="row">
			<h2>Add an Expense:</h2>
			
			<form:form action="/expenses" method="post" modelAttribute="expense">
			
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
				
				<input type="submit" value="Add Expense" class="btn-primary"/>
			
			</form:form>
		</div>
	</div>
</body>
</html>