<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Entry</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3 border rounded p-3">
	<div class="row">
		<h2><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></h2>
	</div>
	
	<div class="row p-3 mb-3">
		<h4>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h4>
		<div class="card mb-3">
			<div class="card-body"><c:out value="${book.thoughts}"/></div>
		</div>
	</div>
	
	<a class="btn btn-warning" href="/books/${book.id}/edit">Edit Entry</a>
	<a class="btn btn-secondary" href="/welcome">Back</a>
</div>

</body>
</html>