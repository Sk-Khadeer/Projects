<%@page import="com.library.BookDao"%>
<%@page import="com.library.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String s=request.getParameter("hide");
String table_name=request.getParameter("name");
int a=Integer.parseInt(s);
int del=BookDao.delete(a, table_name);
if(del>0)
out.print("<h1 align='center' style='color:red;'>Deleted Sucessfully</h1>");
else
	out.print("<h1 align='center' style='color:red;'>Your deleting id is not present in "+table_name+" table</h1>");

%>
</body>
</html>