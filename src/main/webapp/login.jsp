<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>

	<h1>Messaging App using Spring Boot</h1>
	<br>

	<c:choose>
		<c:when test="${sessionScope.loggedIn == -2}">
			Entered Username is not registered.<br>
		</c:when>
		<c:when test="${sessionScope.loggedIn eq -1}">
			Username or Password is incorrect.<br>

		</c:when>
		<c:otherwise>
			Login<br>
		</c:otherwise>
	</c:choose>
	<br>

	<form action="validate" method="post">
		Username:<br> <input type="text" name="username"><br>
		<br> Password:<br> <input type="password" name="password"><br>
		<br> <input type="submit">
	</form>
	
	<br>
	<a href="/register">Register</a>

</body>
</html>
