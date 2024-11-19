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

	<h1>Single order page</h1>
	
	<h3>Id -- <c:out value="${o.id}"/></h3>
	<h3>Name -- <c:out value="${o.customerName}"/></h3>
	<h3>Product -- <c:out value="${o.product}"/></h3>
	<h3>Quantity -- <c:out value="${o.quanity}"/></h3>
	<h3>Price -- <c:out value="${o.price}"/></h3>
</body>
</html>