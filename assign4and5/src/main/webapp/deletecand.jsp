<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>del</title>
</head>
<body>

	<jsp:useBean id="del" class="com.sunbeam.beans.DeleteCand"></jsp:useBean>
	<jsp:setProperty property="id" name="del" param="id"/>
	${del.delCand()}
<c:choose>
	<c:when test="${del.count == 1 }">
		<c:redirect url="votingResult.jsp" />
	</c:when>
	<c:otherwise>
	<h1>failed to delete</h1>
	</c:otherwise>
</c:choose>
</body>
</html>