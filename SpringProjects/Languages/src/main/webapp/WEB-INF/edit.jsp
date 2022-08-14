<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container-md bg-light p-3">
		<div class="row text-center">
			<h2>Edit Mode</h2>
			
			<form:form action="/languages/${language.id}" method="post" modelAttribute="language" class="form">
				<input type="hidden" name="_method" value="put">
				
				<div class="form-group p-3">
					<form:label path="name">Name</form:label>
					<form:errors path="name" class="error"/>
					<form:input path="name" type="text" class="form-control"/>
				</div>
				
				<div class="form-group p-3">
					<form:label path="creator">Creator</form:label>
					<form:errors path="creator" class="error"/>
					<form:input path="creator" type="text" class="form-control"/>
				</div>
				
				<div class="form-group p-3">
					<form:label path="name">Name</form:label>
					<form:errors path="name" class="error"/>
					<form:input path="name" type="text" class="form-control"/>
				</div>
				
				<div class="form-group p-3">
					<form:label path="version">Version</form:label>
					<form:errors path="version" class="error"/>
					<form:input path="version" type="number" step="0.01" class="form-control"/>
				</div>
				
				<input type="submit" value="Update" class="btn-primary"/>
			</form:form>
		</div>
	</div>
	
</body>
</html>