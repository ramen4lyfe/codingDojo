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

<div class="container-md-6">
	<div class="row">
		<h1>New Person</h1>
		
		<form:form action="/persons/new" method="post">
		
			<div class="form-group p-3">
				<form:label path="firstName" required>First Name</form:label>
				<form:errors path="firstName" class="error"/>
				<form:input path="firstName" type="text" class="form-control"/>
			</div>
			<div class="form-group p-3">
				<form:label path="lastName" required>Last Name</form:label>
				<form:errors path="lastName" class="error"/>
				<form:input path="lastName" type="text" class="form-control"/>
			</div>
			<div class="input"><input type="submit" class="button primary" value="create"/></div>
		</form:form>
	</div>
</div>

</body>
</html>