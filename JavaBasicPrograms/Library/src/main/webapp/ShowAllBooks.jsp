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
List<Book> list=BookDao.getAllBook(); 
out.print("<table border='1' align='center' s cellpadding='4' width='60%'>");  
out.print("<tr><th>Id</th><th>Book Name</th><th>Cost</th><th>Author Name</th><th>Total Number Of Copies</th><th>Available Copies</th>");  
for(Book e:list){  
    out.print("<tr><td>"+e.getId()+"</td><td>"+e.getBook_name()+"</td><td>"+e.getCost()+"</td><td>"+e.getAuthor_name()+"</td><td>"+e.getTotal_number_of_copies()+"</td><td>"+e.getAvailable_copies()+"</td></tr>");  
}  
out.print("</table>");  
%> 
<table align="center"> <a href="index.html"> <button type="submit">Back</button></a></table>
</body>
</html>