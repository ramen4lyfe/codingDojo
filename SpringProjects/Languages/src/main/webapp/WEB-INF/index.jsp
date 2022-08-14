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

	<div class="container-md bg-light p-3 ">
		<div class="row text-center">
			<h1>Coding Languages</h1>
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="language" items="${languages}">
					<tr>
						<td><a href="/languages/${language.id}"><C:out value="${eachLanguage.name}"/></a></td>
						<td><c:out value="${language.creator}"/></td>
						<td><c:out value="${language.version}"/></td>
						<td>
						<a href="/edit/<c:out value="${language.id}"/>">edit</a> 
						<form action="/languages/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class="btn-danger">
						</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="row text-center">
			<h2>Add New Language</h2>
		
			<form:form action="/languages" method="post" modelAttribute="language">
			
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
				
				<input type="submit" value="Add Language" class="btn-primary"/>
			
			</form:form>
			
		</div>
	</div>

</body>
</html>