<%@page import="java.util.List"%>
<%@page import="com.library.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateBook.jsp">
<%
String s=request.getParameter("id");
//out.print(s);
int a=Integer.parseInt(s);
List<Book> l1=BookDao.getBookById(a);
String book_name="",author_name="";int cost=0,total_number_of_copies=0,available_copies=0;
for(Book g:l1)
{
	//out.print(g.getAuthor_name()+" "+g.getBook_name()+" "+g.getAvailable_copies()+" ");
	book_name=g.getBook_name();
	author_name=g.getAuthor_name();
	cost=g.getCost();
	total_number_of_copies=g.getTotal_number_of_copies();
	available_copies=g.getTotal_number_of_copies();

	List<String> l=BookDao.editBook();
	int c=0;
	for(String i:l)
	{
		if(s.equals(i))
		{
			c=1;
		}
	}
	if(c!=0)
	{
		out.print("<table align='center'>");
		out.print("<input type='hidden' name='hide' value='"+s+"'</input>");
		out.print("<tr><td><b>Book name</td><td><input type='text' name ='book_name' value='"+g.getBook_name()+"' required ></td></tr>");
		out.print("<tr><td><b>Author name</td><td><input type='text' name ='author_name' value='"+g.getAuthor_name()+"' required ></td></tr>");
		out.print("<tr><td><b>Book Cost</td><td><input type='text' name ='cost' pattern='[1-9]{1}[0-9]*' value='"+g.getCost()+"' required  ></td></tr>");
		out.print("<tr><td><b>Total number of Copies</td><td><input type='text' name ='total_number_of_copies' value='"+g.getTotal_number_of_copies()+"' pattern='[1-9]{1}[0-9]*' required  ></td></tr>");
		out.print("<tr><td><b>Available Copies</td><td><input type='text' name ='available_copies' value='"+g.getAvailable_copies()+"' pattern='[1-9]{1}[0-9]*' required  ></td></tr>");
		out.print("<tr><td></td><td><input type='submit' value='submit'>      <input type='reset' value='reset'></td></tr>");
		out.print("</table>");
	}
	else
		out.print("book id is not found");
}
%>
</form>
<a href="EditBookDetails.jsp"> back</a>

</body>
</html>