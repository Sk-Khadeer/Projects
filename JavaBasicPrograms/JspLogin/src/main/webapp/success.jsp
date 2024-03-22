<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;" align="center">User <%= session.getAttribute("operation") %> Status</h2>
<h1 style="blue;" align="center">User <%= session.getAttribute("operation") %> Success</h1>
<h3 align="center">
<a href="./login.jsp">|Login Form|</a>
</h3>

</body>
</html>