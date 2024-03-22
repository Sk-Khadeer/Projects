<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Customer> list=BookDao.getAllCustomer();


out.print("<table border='1' align='center' cellpadding='4' width='60%'>");  
out.print("<tr><th>Id</th><th>Customer Name</th><th>City</th><th>Email</th><th>Date of Join</th><th>Total No Books taken</th>");  
for(Customer c:list){  
    out.print("<tr><td>"+c.getId()+"</td><td>"+c.getCustomer_name()+"</td><td>"+c.getCity()+"</td><td>"+c.getEmail()+"</td><td>"+c.getDate_of_join()+"</td><td>"+c.getTotal_no_books()+"</td></tr>");  
}  
out.print("</table>");  
%> 
<table align="center"> <a href="index.html"> <button type="submit">Back</button></a></table>
</body>
</html>