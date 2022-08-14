<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3 border rounded p-3">
	
	<div class="row p-3 mb-3">
		<h2> <c:out value="${show.title}"/> </h2>
		<p> Posted By: <c:out value="${show.user.userName}"/> </p>
		<p> Network: <c:out value="${show.network}"/> </p>
		<p> Description: <c:out value="${show.description}"/> </p>
		<p> Rating: <c:out value="${show.rating}"/> </p>
	</div>
	<div class="btn-group">
		<a class="btn btn-warning mr-3" href="/shows/${show.id}/edit" role="button">Edit Entry</a>
		
		<form action="/shows/${show.id}/delete" method="post">
		    <input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete" class=" btn btn-danger mr-2">
		</form>
		<a class="btn btn-secondary" href="/shows">Back to the Shows</a>
	</div>
</div>

</body>
</html>