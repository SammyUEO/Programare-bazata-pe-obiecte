<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Detalii Laptop</title>
</head>
<body>
    <h1>Detalii Laptop</h1>
    <p>Brand: <c:out value="${lap.brand}" /></p>
    <p>Pret: <c:out value="${lap.price}" /> RON</p>
    <p>RAM: <c:out value="${lap.ram}" /> GB</p>
</body>
</html>
