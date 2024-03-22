<%@page import="com.library.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.library.*"%>
<jsp:useBean id="b" class="com.library.Book"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="newBook.jsp" %>
<%
int i=BookDao.save(b);
if(i>0)
{
	response.sendRedirect("newBook.jsp?s=Book Added Successfully..&c=green");

}
else
{
	response.sendRedirect("newBook.jsp?s=Something Went Wrong..&c=red");
	
}
%>
<table align="center"> <a href="newBook.jsp"> <button type="submit">Back</button></a></table>
</body>
</html>