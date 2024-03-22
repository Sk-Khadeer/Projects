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
<form action="checkingBookId.jsp">
<% 
String s=request.getParameter("id");
int a=Integer.parseInt(s);
List<Customer> l1=BookDao.getCustomerById(a);

int c=0;
for(Customer g:l1)
{
	c=1;
		out.print("<table align='center'>");
		out.print("<input type='hidden' name='hide' value='"+s+"'</input>");
		out.print("<tr><td><b>Customer name</td><td><input type='text' name ='customer_name' value='"+g.getCustomer_name()+"' required ></td></tr>");
		out.print("<tr><td><b>Total no of Books taken</td><td><input type='number' name ='total_no_books' value='"+g.getTotal_no_books()+"'  required  ></td></tr>");
		out.print("<tr><td><b>Enter Book ID </td><td><input type='number' name ='id'   required  ></td></tr>");
		out.print("<tr><td></td><td><input type='submit' value='submit'>      <input type='reset' value='reset'></td></tr>");
		out.print("</table>");
}
if(c!=0){}
else 
	out.print("Customer id is not found");
	
%>
</form>
</body>
</html>