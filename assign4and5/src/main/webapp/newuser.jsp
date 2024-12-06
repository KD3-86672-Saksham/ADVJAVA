<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>

	<h1>New User</h1>
	<form method="post" action="register.jsp" >
	First Name: <input type="text" name="fname" /><br/><br/>
	Last Name: <input type="text" name="lname" /><br/><br/>
	Email: <input type="email" name="email" /><br/><br/>
	Password: <input type="password" name="passwd" /><br/><br/>
	DOB: <input type="date" name="date" /><br/><br/>
	<input type="submit" value="register" />
	</form>

</body>
</html>