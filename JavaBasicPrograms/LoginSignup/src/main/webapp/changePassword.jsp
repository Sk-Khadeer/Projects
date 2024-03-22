<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
String user=request.getParameter("user");
String password=request.getParameter("current");
String Newpass=request.getParameter("new");
String conpass=request.getParameter("confirm");
String connurl = "jdbc:mysql://localhost:3306/sreedar";
Connection con=null;
String pass="",username="";
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(connurl, "root", "khadeer@944");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select password,userid from users where password='"+password+"' and userid='"+user+"'");
while(rs.next()){
pass=rs.getString(1);
username=rs.getString(2);
}
System.out.println(username+" "+pass);
if(pass.equals(password))
{
 Statement st1=con.createStatement();
 if(Newpass.equals(conpass)){
  int i=st1.executeUpdate("update users set password='"+Newpass+"' where userid='"+user+"'and password='"+password+"'");
  out.println("Password changed successfully");
  st1.close();
  con.close();
}
 else{
	out.print("not matched");
 }
} 
else{
out.println("Invalid Current Password");
}
}
catch(Exception e){
out.println(e);
}
%>