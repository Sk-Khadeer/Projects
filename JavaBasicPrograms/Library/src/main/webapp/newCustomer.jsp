<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String clear=request.getParameter("c");
String m=" ";
String sl=request.getParameter("s");
if(sl==null)
	sl="";
else
	m=clear;
%>
<form action="customersave.jsp" method="post">
<table align='center'>
<tr><td><b>Customer name</td><td><input type="text" name ="customer_name"  required ></td></tr>
<tr><td><b>City</td><td><input type="text" name ="city" required ></td></tr>
<tr><td><b>Email</td><td><input type="email" name ="email" required  ></td></tr>
<tr><td><b>date of join</td><td><input type="date" name ="date_of_join"  required  ></td></tr>
<tr><td><b>Total Number of Books Taken</td><td><input type="text" name ="total_no_books" pattern="[0]{1}" value="0"  required  ></td></tr>

<tr><td></td><td><input type="submit" value="submit">      <input type="reset" value="reset"></td></tr>
<h3 align="center" style="color:<%=m %>;"><%=sl %> </h3>
</table>
</form>
<table align="center"> <a href="index.html"> <button type="submit">Back</button></a></table>
</body>
</html>