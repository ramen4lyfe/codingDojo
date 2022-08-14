<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Ninja</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-sm">
	<div class="row p-3 bg-light">
		<h1>New Dojo</h1>
		<form:form action="/ninja/createNinja" modelAttribute="ninja" method="POST">
			
			<div class="form-group mb-3">
				<form:label path="dojo">Select a Dojo:</form:label>
				<form:errors path="dojo" class="error"/>
				<form:select path="dojo" class="form-select">
					<option selected>Choose...</option>
					<c:forEach items="${allDojos}" var="dojo">
						<option value="${dojo.id}">${dojo.name}</option>
					<!-- // value of primary key will go in here to append to model -->
					</c:forEach>
					
				</form:select>
			</div>
			
			<div class="form-group mb-3">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" class="error"/>
				<form:input path="firstName" type="text" class="form-control"/>
			</div>
			
			<div class="form-group mb-3">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" class="error"/>
				<form:input path="lastName" type="text" class="form-control"/>			</div>
			
			<div class="form-group mb-3">
				<form:label path="age">Age:</form:label>
				<form:errors path="age" class="error"/>
				<form:input path="age" type="int" class="form-control"/>
			</div>
			
			<button class="btn btn-primary">Create Ninja</button>			
		</form:form>
	</div>
</div> 
</body>
</html>