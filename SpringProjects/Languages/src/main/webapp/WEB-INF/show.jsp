<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Language</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container-md">
	
		<h1>Language Details</h1>
		
		<table class="table">
			<tr>
				<th>Language Details:</th>
				<td><c:out value="${language.name}"/></td>
			</tr>
			<tr>
				<th>Language Creator:</th>
				<td><c:out value="${language.creator}"/></td>
			</tr>
			<tr>
				<th>Language Version:</th>
				<td><c:out value="${language.version}"/></td>
			</tr>
			
		</table>
		
		<a href="/">Go back</a>
	</div>


</body>
</html>