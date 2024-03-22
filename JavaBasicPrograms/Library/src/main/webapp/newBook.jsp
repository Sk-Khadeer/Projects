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
<form action="booksave.jsp" method="post">
<table align='center'>
<tr><td><b>Book name</td><td><input type="text" name ="book_name" pattern="[A-Za-z]*" required ></td></tr>
<tr><td><b>Author name</td><td><input type="text" name ="author_name"  pattern="[A-Za-z]*" required ></td></tr>
<tr><td><b>Book Cost</td><td><input type="text" name ="cost" pattern="[1-9]{1}[0-9]*" required  ></td></tr>
<tr><td><b>Total number of Copies</td><td><input type="text" name ="total_number_of_copies" pattern="[1-9]{1}[0-9]*" required  ></td></tr>
<tr><td></td><td><input type="submit" value="submit">      <input type="reset" value="reset"></td></tr>
<h2 align="center" style="color:<%=m %>;"><%=sl %> </h2>
</table>
</form>
<table align="center"> <a href="index.html"> <button type="submit">Back</button></a></table>
</body>
</html>