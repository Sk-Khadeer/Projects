<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="com.library.*"%>
     <%@ page import="java.sql.*" %>
<jsp:useBean id="b" class="com.library.Book"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/sreedar";%>
<%!String user = "root";%>
<%!String psw = "khadeer@944";%>
<%
String book_id=request.getParameter("book_id");
int a=Integer.parseInt(book_id);
String customer_id=request.getParameter("customer_id");
int x=Integer.parseInt(customer_id);
//out.print(book_id+" "+customer_id);
List<Book> l1=BookDao.getBookById(a);
List<Customer> l2=BookDao.getCustomerById(x);
int available_copies=0;
int total_no_books=0;
int f=0;
for(Book c:l1){
	f=c.getAvailable_copies();
   if(f>0)
   {
	   int status=0;
	   available_copies=c.getAvailable_copies()-1;
	  for(Customer d:l2)
		{
			total_no_books=d.getTotal_no_books()+1;
			Connection con = null;
			PreparedStatement ps = null,ps1=null;
			try
			{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,psw);
			String sql="Update book set available_copies=? where id="+book_id;
			String sql2="Update customer set total_no_books=? where id="+customer_id;
			ps = con.prepareStatement(sql);
			ps1 =con.prepareStatement(sql2);
			ps.setInt(1, available_copies);
			ps1.setInt(1, total_no_books);
			int k= ps.executeUpdate();
			int m=ps1.executeUpdate();
			if(k > 0)
			{
			out.print("<h2 align='center' style='color:blue;'> Both Book and </h2>");
			}
			else
			{
			out.print("There is a problem in updating Record.");
			} 
			if(m > 0)
			{
			out.print("<h2 align='center' style='color:blue;'> Customer Updated Successfully </h2>");
			}
			else
			{
			out.print("There is a problem in updating Record.");
			} 
			} 
			catch(SQLException sql)
			{
			request.setAttribute("error", sql);
			out.println(sql);
			}
		}
   	// out.print(available_copies+" "+total_no_books);
   }
   else {
	out.print("<h2 align='center' style='color:red;'>Sorry,Books all are completed try with other book</h2>");  
	out.print("<h1 align='center' style='color:green;'><a href='checkingCustomer.jsp?id="+customer_id+"'>try again</a></h1>");
   }
   }
%>

</body>
</html>