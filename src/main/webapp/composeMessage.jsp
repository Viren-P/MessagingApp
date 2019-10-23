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

<form action="/messageSent" method ="post">
	To:
	<br>
	<input type="text" name="To"><br><br>
	Title:
	<br>
	<input type="text" name="Title"><br><br>
	Message:
	<br>
	<input type="text" name="Message"><br><br>
	<input type="submit" value="Send">
</form>


</body>
</html>