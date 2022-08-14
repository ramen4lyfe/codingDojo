<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Send Omikuji</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="/css/main.css"> -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-sm bg-light p-3">
	<div class="row">
		<h1>Send an Omikuji!</h1>
		
			<form action="/processFormData" method = "post" class="bg-danger">
				<div class="mb-3">
				    <label for="name" class="form-label">Pick any number from 5 to 25</label>
				    <input type="number" class="form-control" path="name" name="name" required>
  				</div>
  				<input class="btn btn-primary" type="submit" value="submit">
  				
			</form>
	
	
		<form:form action="/processFormData" method = "post">
			<div class="form-group p-3">
				<form:label for="">Pick any number from 5 to 25</form:label>
				<form:input path="name" type="number" name="number" class="form-control"/>
			</div>
			
			<div class="form-group p-3">
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="error"/>
					<form:input path="description" type="text" class="form-control"/>
				</div>
			
			<div class="form-group p-3">
				<label for="">Enter the name of the city</label>
				<input type="text" name="city"/>
			</div>
			
			<div class="form-group p-3">
				<label for="">Enter the name of any real person</label>
				<input type="text" name="person"/>
			</div>
			
			<div class="form-group p-3">
				<label for="">Enter professional endeavor or hobby:</label>
				<input type="text" name="hobby"/>
			</div>
			
			<div class="form-group p-3">
				<label for="">Enter any type of living thing</label>
				<input type="text" name="livingThing"/>
			</div>
			
			<div class="form-group p-3">
				<label for="">Say something nice</label>
				<textarea name= "message" id="" cols="30" rows="10"></textarea>
			</div>
			
			<p>Send and show a friend</p>
			<input type="submit" value="send"/>
			
			 
			
			
		</form:form>
	</div>
</div>

</body>
</html>