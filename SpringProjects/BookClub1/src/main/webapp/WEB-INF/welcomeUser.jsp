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
			<h1>Welcome, <c:out value="${user.userName}"/></h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div class="col-6 text-end">
			<a href="/">logout</a>
			<a href="/addPage">Add book to my shelf!</a>
		</div>
	</div>
	
	<div class="row mb-3">
	
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td> <c:out value="${book.id}"/> </td>
											
						<td> <a href="books/${book.id}"><c:out value="${book.title}"/></a> </td>
						
						<td> <c:out value="${book.author}"/> </td>
						
						<td> <c:out value="${book.user.userName}"/> </td>
					</tr>
				</c:forEach>		
			</tbody>
		</table>
	</div>
	

</div>

</body>
</html>