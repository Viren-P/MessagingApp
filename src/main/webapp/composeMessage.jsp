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

	<h1>Compose Message</h1>

	<form action="/messageSent" method="post"> To: <br> 
		<select name="To">
			<c:forEach items="${users}" var="currentUser">
				<c:choose>
					<c:when test="${currentUser.credentials.username != sessionScope.user.credentials.username}">
						<option value="${currentUser.credentials.username}">${currentUser.credentials.username }</option>
					</c:when>
				</c:choose>
			</c:forEach>
		</select> 
		<br> 
		Title:
		<br> 
		<input type="text" name="Title"><br>
		<br> 
		Message: 
		<br> 
		<input type="text" name="Message"><br>
		<br> 
		<input type="submit" value="Send">
	</form>

<br>
<a href="/profile">Back</a>

</body>
</html>