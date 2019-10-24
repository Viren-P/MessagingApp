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
<!--  All Messages -->
<c:set var="sender" value="[Deleted]" scope="page" />
<c:set var="receiver" value="[Deleted]" scope="page" />
<c:forEach items="${messages}" var="message">
	<tr>
		<c:if test="${not empty message.sender.credentials.username}">
			<c:set var="sender" value="${message.sender.credentials.username }"/>			
		</c:if>
		<c:if test="${not empty message.receiver.credentials.username}">
			<c:set var="receiver" value="${message.receiver.credentials.username }"/>			
		</c:if>
		<td><c:out value="${message.id}" /></td>
		<br>
		<td>From: <c:out value="${sender}" /></td>
		<br>
		<td>To: <c:out value="${receiver}" /></td>
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