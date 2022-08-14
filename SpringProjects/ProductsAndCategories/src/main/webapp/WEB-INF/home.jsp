<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login and Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3 p-3">
	<div class="row mb-3">
		<h1 class="text-center">Home Page</h1>
		<a class="btn btn-primary g-3" href="/products/new" role="button">Add New Product</a>
		<a class="btn btn-primary g-3" href="/categories/new" role="button">Add New Categories</a>
	</div>

	<div class="row justify-content-between">
		
		<!-- Products card -->
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Products</h5>		
			</div>
			<ul class="list-group list-group-flush">
				<c:forEach var="product" items="${products}">
			    	<li class="list-group-item"> <a href="products/${product.id}"><c:out value="${product.name}"/></a>  </li>
			    </c:forEach>
			</ul>
		</div>
		
		<!-- Categories card -->
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Categories</h5>		
			</div>
			<ul class="list-group list-group-flush">
				<c:forEach var="category" items="${categories}">
			    	<li class="list-group-item"> <a href="products/${category.id}"><c:out value="${category.name}"/></a>  </li>
			    </c:forEach>
			</ul>
		</div>
		
	</div>
</div>

</body>
</html>