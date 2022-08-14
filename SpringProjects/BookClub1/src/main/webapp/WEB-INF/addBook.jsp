<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3 p-3">
	<div class="row mb-3">
		<h1>Add a Book to Your Shelf!</h1>
		<a href="/home">Back to the shelves</a>
	</div>
	
	<div class="row mb-3">
		<form:form action="/books" modelAttribute="book" class="form" method="post">
				
			<div class="row mb-3">
				<form:label path="title" class="col-sm-4 col-form-label">Title:</form:label>
				<div class="col-sm-8">
					<form:errors path="title" class="error"/>
					<form:input path="title" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="row mb-3">
				<form:label path="author" class="col-sm-4 col-form-label">Author:</form:label>
				<div class="col-sm-8">
					<form:errors path="author" class="error"/>
					<form:input path="author" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="row mb-3">
				<form:label path="thoughts" class="col-sm-4 col-form-label">My Thoughts:</form:label>
				<div class="col-sm-8">
					<form:errors path="thoughts" class="error"/>
					<form:input path="thoughts" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="row mb-3">
					<form:errors path="user" class="error"/>
					<form:input path="user" value="${user.id}" type="hidden" class="form-control"/>
			</div>
			
			<button class="btn btn-primary">Add!</button>
			
		</form:form>
	</div>		
</div>

</body>
</html>

