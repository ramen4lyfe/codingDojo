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

<div class="container-md mt-3">
	<div class="row">
		<h3><span style="color: red;"><c:out value="${book.user.userName}"/></span> read <span style="color: rebeccapurple;"><c:out value="${book.title}"/></span> by <span style="color: darkgreen;"><c:out value="${book.author}"/></span></h3>
	</div>
	
	<div class="row">
		<h4>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h4>
		<p><c:out value="${book.thoughts}"/></p>
	</div>
	
	<a class="btn btn-warning" href="/books/${book.id}/edit">Edit</a>
</div>

</body>
</html>