<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Register New User</h2>
	<c:choose>
		<c:when test="${sessionScope.register == -1}">
			<p style="color: red;">Entered username already exists.</p>
			<c:set var="user" value="${param.name}" scope="session" />
		</c:when>
		<c:otherwise>
			<p></p>
		</c:otherwise>
	</c:choose>
	<br>
	<form action="validate" method="post">
		Enter a new username:<br> <input type="text" name="username"><br>
		<br> Enter a password:<br> 
		<input type="password" name="password"><br> <br> 
			<input type="submit"value="Register"><br> <br>
			<a href="/login">Back</a>
	</form>



</body>
</html>