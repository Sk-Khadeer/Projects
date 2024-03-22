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
List<Book> l1=BookDao.getBookById(a);

int c=0;
for(Book g:l1)
{
	c=1;
		out.print("<table align='center'>");
		out.print("<tr><td><b>Book Id</td><td> "+g.getId()+"</td></tr>");
		out.print("<tr><td><b>Book name</td><td> "+g.getBook_name()+"</td></tr>");
		out.print("<tr><td><b>Author name</td><td>"+g.getAuthor_name()+"</td></tr>");
		out.print("<tr><td><b>Book Cost</td><td>"+g.getCost()+"</td></tr>");
		out.print("<tr><td><b>Total number of Copies</td><td>"+g.getTotal_number_of_copies()+"</td></tr>");
		out.print("<tr><td><b>Available Copies</td><td>"+g.getAvailable_copies()+"</td></tr>");
		out.print("</table>");
}
if(c!=0){}
else 
	out.print("book id is not found");
	
%>
</form>

</body>
</html>