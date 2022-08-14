<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-sm mt-3">

	<div class="row mb-3">
		<h1 class="text-center"> <c:out value="${product.name}"/> </h1>
		<a class="btn btn-primary g-3" href="/" role="button">Home</a>
	</div>

	<div class="row mb-3">
		<table class="table">
			<thead>
				<tr>
					<th>Products</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="category" items="${categories}">
					<tr>
						<td> <c:out value="${category.name}"/> </td>
					</tr>
				</c:forEach>		
			</tbody>
		</table>
	</div>
	
	<div class="row mb-3">
		<form:form action="/addProduct" modelAttribute="addProduct" method="post">
			<form:select class="form-select" path="productName">
				<form:option value="NONE" label="--- Select ---" />
				<form:options items="${productList}" />
			</form:select>
		</form:form>
	</div>
	

</div>

</body>
</html>