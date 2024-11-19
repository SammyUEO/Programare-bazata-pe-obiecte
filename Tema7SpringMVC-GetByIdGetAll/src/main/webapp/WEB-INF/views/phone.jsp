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
	<h1>Single phone page</h1>
	
	<h3>Id -- <c:out value="${p.id}"/></h3>
	<h3>Brand -- <c:out value="${p.brand}"/></h3>
	<h3>Price -- <c:out value="${p.price}"/></h3>
	<h3>Ram -- <c:out value="${p.ram}"/></h3>
	<h3>Storage -- <c:out value="${p.storage}"/></h3>
</body>
</html>