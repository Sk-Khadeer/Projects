<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="com.library.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String s=request.getParameter("id");
int a=Integer.parseInt(s);
List<Customer> l1=BookDao.getCustomerById(a);

int c=0;
for(Customer g:l1)
{
	c=1;
		out.print("<table align='center'>");
		out.print("<tr><td><b>Customer Id</td><td> "+g.getId()+"</td></tr>");
		out.print("<tr><td><b>Customer name</td><td> "+g.getCustomer_name()+"</td></tr>");
		out.print("<tr><td><b>City</td><td>"+g.getCity()+"</td></tr>");
		out.print("<tr><td><b>Email</td><td>"+g.getEmail()+"</td></tr>");
		out.print("<tr><td><b>Date of Join</td><td>"+g.getDate_of_join()+"</td></tr>");
		out.print("<tr><td><b>Total no of Books Taken</td><td>"+g.getTotal_no_books()+"</td></tr>");
		out.print("</table>");
}
if(c!=0){}
else 
	out.print("Customer id is not found");
	
%>
</body>
</html>