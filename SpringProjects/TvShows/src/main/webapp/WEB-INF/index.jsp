<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login and Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3">
	<div class="row justify-content-around bg-light">
		<div class="mb-3 p-3">
			<h1>TV Shows Database</h1>
			<h3>A place to nerd out!</h3>
		</div>
		<div class="col-4 mb-3">
			<h2>Register</h2>
			
			<form:form action="/register" modelAttribute="newUser" method="post">
				
				<div class="row mb-3">
					<form:label path="userName" class="col-sm-4 col-form-label">User Name:</form:label>
					<div class="col-sm-8">
						<form:errors path="userName" class="text-danger"/>
						<form:input path="userName" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="row mb-3">
					<form:label path="email" class="col-sm-4 col-form-label">Email:</form:label>
					<div class="col-sm-8">
						<form:errors path="email" class="text-danger"/>
						<form:input path="email" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="row mb-3">
					<form:label path="password" class="col-sm-4 col-form-label">Password:</form:label>
					<div class="col-sm-8">
						<form:errors path="password" class="text-danger"/>
						<form:input path="password" type="password" class="form-control"/>
					</div>
				</div>
				
				<div class="row mb-3">
					<form:label path="confirm" class="col-sm-4 col-form-label">Confirm Password:</form:label>
					<div class="col-sm-8">
						<form:errors path="confirm" class="text-danger"/>
						<form:input path="confirm" type="password" class="form-control"/>
					</div>
				</div>
				
				<button class="btn btn-primary">Submit</button>
				
			</form:form>
		</div>
			
		<div class="col-4 mb-3">
			<h2>Login</h2>
			
			<form:form action="/login" modelAttribute="newLogin" method="post">
				
				<div class="row mb-3">
					<form:label path="email" class="col-sm-4 col-form-label">Email:</form:label>
					<div class="col-sm-8">
						<form:errors path="email" class="text-danger"/>
						<form:input path="email" type="text" class="form-control"/>
					</div>
				</div>
				
				<div class="row mb-3">
					<form:label path="password" class="col-sm-4 col-form-label">Password:</form:label>
					<div class="col-sm-8">
						<form:errors path="password" class="text-danger"/>
						<form:input path="password" type="password" class="form-control"/>
					</div>
				</div>
								
				<button class="btn btn-primary">Submit</button>
				
			</form:form>
		</div>

	</div>
</div>

</body>
</html>