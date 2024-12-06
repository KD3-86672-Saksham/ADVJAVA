<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Page</title>
</head>
<body>
<h1>Candidate List</h1>

	<jsp:useBean id="cl" class="com.sunbeam.beans.CanndidateListBeans" />
	${cl.fetchCandidates()}
	
	<form method="post" action="vote.jsp">
	
		<c:forEach var="c" items="${cl.candList}">
			<input type="radio" name="candidate" value=${c.id} />${c.name} - ${c.party} <br/>				
		</c:forEach>
		<br/>
		<input type="submit" value="Vote"/>
	
	
	</form>

</body>
</html>