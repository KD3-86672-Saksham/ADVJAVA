<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="regist" class="com.sunbeam.beans.RegistrationBeans"/>
	<jsp:setProperty property="firstName" name="regist" param="fname"/>
	<jsp:setProperty property="lastName" name="regist" param="lname"/>
	<jsp:setProperty property="email" name="regist" param="email"/>
	<jsp:setProperty property="password" name="regist" param="passwd"/>
	<jsp:setProperty property="dob" name="regist" param="date"/>
	${regist.saveUser()}
	
	<c:choose>
		<c:when test="${regist.count == 1}">
			registration successful
			<a href="index.jsp"></a>
		</c:when>
		<c:otherwise>
			registration failed
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>