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
String s=request.getParameter("id");
out.print("<table align='center'>");
out.print("<h2 align='center'>Select in which data u have to delete</h2>");
out.print("<tr><td><a href='deleteBook.jsp?hide="+s+"&name=book'><input type='submit'  value='book'></a> </td><td>   </td><td> </td><td>   <a href='deleteCustomer.jsp?hide="+s+"&name=customer'><input type='submit' value='customer'></a></td></tr>");
out.print("</table>");
%>
</body>
</html>