<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<h1>USER</h1>

${user.credentials.username}
<br> ${user.id}
<br> ${user.role }
<br>


<br>
<h3>Inbox:</h3>
<!--  Received Messages -->
<c:forEach items="${user.received}" var="message">
	<tr>
		<td>From: <c:out value="${message.sender.credentials.username}" /></td>
		<br>
		<td>Title: <c:out value="${message.title}" /></td>
		<br>
		<td>Body: <c:out value="${message.content}" /></td>
		<br>
		<br>
	</tr>
</c:forEach>

<br>
<h3>Sent Messages:</h3>
<!--  Sent Messages -->
<c:forEach items="${user.sent}" var="message">
	<tr>
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



<a href="/composeMessage">Compose</a>
<br>
<a href="/logout">Logout</a>








</head>
<body>

</body>
</html>