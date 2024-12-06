<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Status</title>
</head>
<body>
	
	<jsp:useBean id="login" class="com.sunbeam.beans.LoginBeans" />
	<jsp:setProperty property="email" name="login" param="email"/>
	<jsp:setProperty property="password" name="login" param="passwd"/>
	${login.getUser()}
	
	<c:choose>
		<c:when test="${login.count == 1}">
			login successful
			 <c:redirect url="votingResult.jsp"/>
			 </c:when>
		<c:when test="${login.count == 2}">
			login successful
			 <c:redirect url="candidatelist.jsp"/> 
		</c:when>
		<c:otherwise>
			login failed
			<br/><br/>
			<a href="index.jsp">Try again</a>
		</c:otherwise>
	</c:choose>
	
</body>
</html>