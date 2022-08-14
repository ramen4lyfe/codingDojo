<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container-sm">
	<div class="row p-3 bg-light">
		<h1>New Dojo</h1>
		<form:form action="/dojo/createDojo" modelAttribute="dojo" method="POST">
			<div class="form-group mb-3">
				<form:label path="name">Enter New Dojo Name:</form:label>
				<form:errors path="name" class="error"/>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			<button class="btn btn-primary">Create Dojo</button>			
		</form:form>
	</div>
</div> 

</body>
</html>