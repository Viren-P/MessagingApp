<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<h1>ADMIN</h1>
${user.credentials.username}
<br> ${user.id}
<br> ${user.role }
<br>
<br>

<br>
<h3>All Users:</h3>
<!--  All Messages -->
<c:forEach items="${users}" var="user">
	<tr>
		<td><c:out value="${user.id}" /></td>
		<br>
		<td>Username: <c:out value="${user.credentials.username}" /></td>
		<br>
		<td>Password: <c:out value="${user.credentials.password}" /></td>
		<br>
		<c:choose>
			<c:when
				test="${user.credentials.username != sessionScope.user.credentials.username}">
				<a href="/deleteUser?id=${user.id}">remove</a>
				<br>
			</c:when>
		</c:choose>
	</tr>
	<br>
</c:forEach>
<br>
<br>

<a href="/profile">Back</a>

</head>
<body>

</body>
</html>