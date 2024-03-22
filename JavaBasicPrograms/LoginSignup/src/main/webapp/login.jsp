<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String userid=request.getParameter("usr");
String password=request.getParameter("password"); 
	
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("select * from users where userid='"+userid+"' and password='"+password+"'"); 

try{
	while(rs.next())
	{
		if(rs.getString("userid").equals(userid)&&rs.getString("password").equals(password)) 
		{ 
        	 out.println("Welcome "  +rs.getString("fname")); 
		} 
	else{
		 out.println("Invalid password or username.");
	}
	}
	}
catch(Exception e) {
e.printStackTrace();
}
%>