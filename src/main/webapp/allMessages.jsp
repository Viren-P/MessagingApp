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
<h3>All Messages:</h3>
<br>
<!--  All Messages -->
<c:forEach items="${messages}" var="message">
	<tr>
		<td>From: <c:out value="${message.sender.credentials.username}" /></td>
		<br>
		<td>To: <c:out value="${message.receiver.credentials.username}" /></td>
		<br>
		<td>Title: <c:out value="${message.title}" /></td>
		<br>
		<td>Body: <c:out value="${message.content}" /></td>
		<br>
		<br>
	</tr>
</c:forEach>
<br>
<br>

<a href="/profile">Back</a>

</head>
<body>

</body>
</html>