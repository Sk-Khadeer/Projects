<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;" align="center">user registration form</h2>
<form action="./registration.jsp" method="POST">

<table>
<tr><td>user name </td>
<td><input type="text" name="uname"> </td></tr>
<tr><td>password </td>
<td><input type="password" name="upwd"> </td></tr>
<tr><td>User Email id </td>
<td><input type="text" name="uemail"> </td></tr>
<tr><td>User Mobile No </td>
<td><input type="text" name="umobile"> </td></tr>
<tr>
<td><input type="submit" value="Registration"> </td></tr>
</table>


</form>
</body>
</html>