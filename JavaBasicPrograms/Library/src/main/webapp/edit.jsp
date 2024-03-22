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
<form action="updateCustomer.jsp">
<%
String s=request.getParameter("id");
//out.print(s);
int a=Integer.parseInt(s);
List<Customer> l1=BookDao.getCustomerById(a);
//String customer_name="",city="",email="",date_of_join="";int total_no_books=0;
for(Customer g:l1)
{
	/**out.print(g.getCustomer_name()+" "+g.getCity()+" "+g.getDate_of_join()+" "+g.getEmail()+" "+g.getTotal_no_books());
	customer_name=g.getCustomer_name();
	city=g.getCity();
	email=g.getEmail();
	date_of_join=g.getDate_of_join();
	total_no_books=g.getTotal_no_books();**/

	List<String> l=BookDao.editCustomer();
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
		out.print("<tr><td><b>Customer name</td><td><input type='text' name ='customer_name' value='"+g.getCustomer_name()+"' required ></td></tr>");
		out.print("<tr><td><b>City</td><td><input type='text' name ='city' value='"+g.getCity()+"' required ></td></tr>");
		out.print("<tr><td><b>Email</td><td><input type='email' name ='email' value='"+g.getEmail()+"' required  ></td></tr>");
		out.print("<tr><td><b>Date of Join</td><td><input type='date' name ='date_of_join' value='"+g.getDate_of_join()+"' required  ></td></tr>");
		out.print("<tr><td><b>Total no of Books taken</td><td><input type='number' name ='total_no_books' value='"+g.getTotal_no_books()+"'  required  ></td></tr>");
		out.print("<tr><td></td><td><input type='submit' value='submit'>      <input type='reset' value='reset'></td></tr>");
		out.print("</table>");
	//out.print("id is present in db");
	}
	else
		out.print("customer id is not found");
}
%>
</form>
<table align="center"> <a href="EditBookDetails.jsp"> <button type="submit">Back</button></a></table>

</body>
</html>