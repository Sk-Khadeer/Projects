<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align='center'>
<form action="deposit_verify.jsp">
<table>
<tr><td>Enter Debit Card number</td><td><input type="tel" name ="debit_card_number"  pattern="[0-9]{12}"></td></tr>
<tr><td></td><td><input type="submit" value="verify card number"></td></tr>
</table>
</form>
<a href="index.html"> back</a>
</body>
</html>