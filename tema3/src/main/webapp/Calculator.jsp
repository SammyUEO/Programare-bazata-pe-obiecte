<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator - Input</title>
</head>
<body>

<h2>Introdu datele</h2>
<form action="Calculator - Output.jsp" method="get">
    <label for="num1">Numărul 1:</label>
    <input type="number" id="num1" name="num1" required><br><br>

    <label for="num2">Numărul 2:</label>
    <input type="number" id="num2" name="num2" required><br><br>

    <label for="text">Text:</label>
    <input type="text" id="text" name="text" required><br><br>

    <input type="submit" value="Trimite">
</form>

</body>
</html>
