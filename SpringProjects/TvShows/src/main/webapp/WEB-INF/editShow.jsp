<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Entry</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-md mt-3 p-3 border rounded">
	
	<div class="row mb-3">
		<h1>Update Show Details</h1>
		
	</div>
	
	<div class="row mb-3">
		<form:form action="/shows/${editShow.id}/update" modelAttribute="editShow" class="form" method="put">
			
			<input type="hidden" name="_method" value="put"/>
			
			<div class="row mb-3">
				<form:label path="title" class="col-sm-4 col-form-label">Title:</form:label>
				<div class="col-sm-8">
					<form:errors path="title" class="text-danger"/>
					<form:input path="title" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="row mb-3">
				<form:label path="network" class="col-sm-4 col-form-label">Network:</form:label>
				<div class="col-sm-8">
					<form:errors path="network" class="text-danger"/>
					<form:input path="network" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="row mb-3">
				<form:label path="description" class="col-sm-4 col-form-label">Description:</form:label>
				<div class="col-sm-8">
					<form:errors path="description" class="text-danger"/>
					<form:input path="description" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="row mb-3">
				<form:label path="rating" class="col-sm-4 col-form-label">Rating:</form:label>
				<div class="col-sm-8">
					<form:errors path="rating" class="text-danger"/>
					<form:select class="form-control" path="rating">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </form:select>
				</div>
			</div>
			
			<div class="row mb-3">
					<form:errors path="user" class="text-danger"/>
					<form:input path="user" value="${user.id}" type="hidden" class="form-control"/>
			</div>
			
			<button class="btn btn-primary">Submit</button>
			
			<a class="btn btn-secondary" href="/shows">Cancel</a>
			
			</form:form>
		</div>
</div>


</body>
</html>