<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3 p-3 border rounded">

	<div class="row mb-3 justify-content-between">
		<div class="col-6">
			<h1>Welcome, <c:out value="${loggedInUser.userName}"/></h1>
			<p>TV Shows</p>
		</div>
		<div class="col-6 text-end">
			<a href="/logout">logout</a>
			<a href="/shows/new">Add a show!</a>
		</div>
	</div>
	
	<div class="row mb-3">
	
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Show Title</th>
					<th>Network</th>
					<th>Description</th>
					<th>Rating</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="show" items="${tvShows}"> <!-- items has to come from the service object -->
					<tr>
						<td> <c:out value="${show.id}"/> </td>
											
						<td> <a href="shows/${show.id}/details"><c:out value="${show.title}"/></a> </td>
						
						<td> <c:out value="${show.network}"/> </td>
						
						<td> <c:out value="${show.description}"/> </td>
						
						<td> <c:out value="${show.rating}"/> </td>
						
						
					</tr>
				</c:forEach>		
			</tbody>
		</table>
	</div>
	

</div>

</body>
</html>