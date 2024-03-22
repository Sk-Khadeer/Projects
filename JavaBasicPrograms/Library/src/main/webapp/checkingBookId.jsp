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
<form action="issuingBook.jsp">
<% 
String book_id=request.getParameter("id");
String customer_id=request.getParameter("hide");
//out.print(customer_id);
int a=Integer.parseInt(book_id);
List<Book> l1=BookDao.getBookById(a);
String s1=request.getParameter("customer_name");
String s2=request.getParameter("total_no_books");
//out.print(s+" "+s1+" "+s2);
int c=0;
for(Book g:l1)
{
	c=1;
		out.print("<table align='center'>");
		out.print("<input type='hidden' name='book_id' value='"+book_id+"'</input>");
		out.print("<input type='hidden' name='customer_id' value='"+customer_id+"'</input>");
		out.print("<tr><td><b>Book name</td><td> "+g.getBook_name()+"</td></tr>");
		out.print("<tr><td><b>Total number of Copies</td><td>"+g.getTotal_number_of_copies()+"</td></tr>");
		out.print("<tr><td><b>Available Copies</td><td>"+g.getAvailable_copies()+"</td></tr>");
		out.print("<tr><td><b>Customer Name</td><td>"+s1+"</td></tr>");
		out.print("<tr><td><b>Total No of Books</td><td>"+s2+"</td></tr>");
		out.print("<tr><td><b>Do you want to issue the "+g.getBook_name()+" book to "+s1+"</td><td><input type='submit' value='yes'>   <input type='reset' value='no'></td></tr>");
		out.print("</table>");
}
if(c!=0){}
else {
	out.print("book id is not found");
	out.print("<a href='checkingCustomer.jsp?id="+customer_id+"'>try again</a>");
}
%>
</form>

</body>
</html>