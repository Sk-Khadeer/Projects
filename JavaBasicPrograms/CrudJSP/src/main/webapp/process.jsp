<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserted</title>
</head>
<body align="center" style='color:red;'>
<%@page import="java.sql.*,java.util.*"%>
<%
String first_name=request.getParameter("first_name");
String last_name=request.getParameter("last_name");
String city_name=request.getParameter("city_name");
String email=request.getParameter("email");
String mobileno=request.getParameter("mobileno");
try
{
         Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar", "root", "khadeer@944");
           Statement st=conn.createStatement();
           int i=st.executeUpdate("insert into user(first_name,last_name,city_name,email,mobileno)values('"+first_name+"','"+last_name+"','"+city_name+"','"+email+"','"+mobileno+"')");
        out.println("<h1>Data is successfully inserted!</h1>");
        }
        catch(Exception e)
        {
        System.out.print(e);
        e.printStackTrace();
        }
 %>
</body>
</html>