<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.library.BookDao"%>
     <%@ page import="com.library.*"%>
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
String hide_id=request.getParameter("hide");
String p=request.getParameter("customer_name");
String up=p.toUpperCase();
String s1=request.getParameter("city");
String s2=request.getParameter("email");
String s3=request.getParameter("date_of_join");
//int i=Integer.parseInt(s3);
String s4=request.getParameter("total_no_books");
//int i1=Integer.parseInt(s4);
Date given_date=new SimpleDateFormat("yyyy-MM-dd").parse(s3);//given date is converting into date format

Date d=new Date();//current date

if(given_date.compareTo(d)<=0)
{
 Connection con = null;
 PreparedStatement ps = null;
 try
 {
 Class.forName(driverName);
 con = DriverManager.getConnection(url,user,psw);
 String sql="Update customer set id=?,customer_name=?,city=?,email=?,date_of_join=?,total_no_books=? where id="+hide_id;
 ps = con.prepareStatement(sql);
 ps.setString(1,hide_id);
 ps.setString(2, p);
 ps.setString(3, s1);
 ps.setString(4, s2);
 ps.setString(5, s3);
 ps.setString(6, s4);
 int k= ps.executeUpdate();
 if(k > 0)
 {
 out.print("<h1 align='center' style='color:blue;'>"+up+" Updated Successfully </h1>");
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
else{
	out.print("<h2 align='center' style='color:red;'>Date is high compare to today,please select less or equal date..</h2>");
	out.print("<h2 align='center' style='color:red;'><a href='edit.jsp?id="+hide_id+"'>     Try Again !!!!!</a></h2>");
}
 
%>
</body>
</html>