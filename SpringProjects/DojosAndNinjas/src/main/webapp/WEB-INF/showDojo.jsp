<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-sm">

	<div class="row mb-3">
		
		<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<!--Need to loop through each -->			
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="ninja">
					<tr>
						<td><c:out value="${ninja.firstName}"/></td>
						<td><c:out value="${ninja.lastName}"/></td>
						<td><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>