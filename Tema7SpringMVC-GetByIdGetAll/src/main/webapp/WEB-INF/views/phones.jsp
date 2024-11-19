<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone</title>
</head>
<body>


<h1>Phones Page</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Detalii</th>
		</tr>		
		<c:forEach var="phone" items="${all}">
			<tr>
				<th><c:out value="${phone.id}"/></th>
				<th><c:out value="${phone.brand}"/></th>
				<th><c:out value="${phone.price}"/></th>
				<th><a href="<c:url value='/phone?id=${phone.id}' />">Detalii</a></th>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>