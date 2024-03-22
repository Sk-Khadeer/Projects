<%@page import="com.sbi.AtmDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="current_bal.jsp" method="post">
Debit Card number<input type="tel" name ="debit_card_number"  pattern="[0-9]{12}" required>
<input type="submit" value="submit">

</form>
<a href="index.html"> back</a>
</body>
</html>