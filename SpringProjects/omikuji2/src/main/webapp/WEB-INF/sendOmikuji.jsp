<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Send Omikuji</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-sm p-3">
	<div class="row">
	
		<h1 class="text-center">Send an Omikuji!</h1>
		<form action="/omikuji/show" method="post">
			
			<div class="form-group mb-3">
				<label class="form-label">Pick any number from 5 to 25:</label>
				<input name="number" type="number" class="form-control"/>
			</div>
			
			<div class="form-group mb-3">
				<label class="form-label">Enter the name of any city:</label>
				<input name="city" type="text" class="form-control"/>
			</div>
			
			<div class="form-group mb-3">
				<label class="form-label">Enter the name of any real person:</label>
				<input name="person" type="text" class="form-control"/>
			</div>
			
			<div class="form-group mb-3">
				<label class="form-label">Enter professional endeavor or hobby:</label>
				<input name="hobby" type="text" class="form-control"/>
			</div>
			
			<div class="form-group mb-3">
				<label class="form-label">Enter any type of living thing:</label>
				<input name="livingThing" type="text" class="form-control"/>
			</div>
			
			<div class="form-group mb-3">
				<label class="form-label">Say something nice to someone:</label>
				<textarea name= "nice" cols="30" rows="10" class="form-control"></textarea>
			</div>
			
			<p>Send and show a friend</p>
			<button class="button btn-primary">Send</button>
		</form>
	</div>
	
	
</div>

</body>
</html>