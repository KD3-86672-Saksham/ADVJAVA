<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Result</title>
</head>
<body>
	<h1>Voting Result</h1>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBean"/>
	${rb.fetchCandidates()}
		<table>
		
		<thead>
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Party</th>
		<th>Votes</th>
		<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${rb.candList}">
		<tr>
		<td>${c.id}</td>
		<td>${c.name}</td>
		<td>${c.party}</td>
		<td>${c.votes}</td>
		<td><a href="deletecand.jsp?id=${c.id}">delete</a></td>
		
		</tr>
		</c:forEach>
		</tbody>
		
		</table>
	
</body>
</html>