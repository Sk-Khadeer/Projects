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
String p=request.getParameter("book_name");
String up=p.toUpperCase();
String s1=request.getParameter("cost");
String s2=request.getParameter("author_name");
String s3=request.getParameter("total_number_of_copies");
int i=Integer.parseInt(s3);
String s4=request.getParameter("available_copies");
int i1=Integer.parseInt(s4);
String s5="";
if(i>=i1){
 s5=request.getParameter("available_copies");
 Connection con = null;
 PreparedStatement ps = null;
 try
 {
 Class.forName(driverName);
 con = DriverManager.getConnection(url,user,psw);
 String sql="Update book set id=?,book_name=?,cost=?,author_name=?,total_number_of_copies=?,available_copies=? where id="+hide_id;
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
 out.print("<h1 align='center' style='color:blue;'>"+up+" Book Updated Successfully </h1>");
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
	out.print("available copies should be less than total number of copies");
	out.print("<a href='editBook.jsp?id="+hide_id+"'>     try again !!!!!</a>");
}
//out.print(p+" "+s1+" "+s2+" "+s3+" "+s5);
%>
</body>
</html>