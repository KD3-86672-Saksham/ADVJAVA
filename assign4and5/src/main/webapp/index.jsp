<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form method="post" action="login.jsp" >
	Email: <input type="email" name="email" /><br/><br/>
	Password: <input type="password" name="passwd" /><br/><br/>
	<input type="submit" value="login" />
	</form>
	<br/><br/>
	<a href = "newuser.jsp">sign UP</a>
</body>
</html>