<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>

<h1>Orders Page</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Product</th>
			<th>Detalii</th>
		</tr>		
		<c:forEach var="order" items="${all}">
			<tr>
				<th><c:out value="${order.id}"/></th>
				<th><c:out value="${order.customerName}"/></th>
				<th><c:out value="${order.product}"/></th>
				<th><a href="<c:url value='/order?id=${order.id}' />">Detalii</a></th>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>