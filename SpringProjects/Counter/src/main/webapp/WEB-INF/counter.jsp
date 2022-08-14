<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current count</title>
</head>
<body>

<p>You have visited <a href="/"><c:out value="${page}"/></a> <c:out value="${count}"/> time(s).</p>

<p><a href="/">Test another visit?</a></p>

<p><a href="/double-counter/">Add 2 visits</a></p>

<p><a href="/reset-counter/">Reset counter</a></p>

</body>
</html>