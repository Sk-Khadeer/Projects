<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.library.*"%>
<jsp:useBean id="c" class="com.library.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="newCustomer.jsp" %>
<%
String s=request.getParameter("date_of_join");
Date given_date=new SimpleDateFormat("yyyy-MM-dd").parse(s);//given date is converting into date format

Date d=new Date();//current date

if(given_date.compareTo(d)<=0)
{
	int i=BookDao.save(c);
	if(i>0)
		response.sendRedirect("newCustomer.jsp?s=Customer Added Successfully..&c=green");
	else
	out.print("<h2 align='center' style='color:blue;'>Something Went Wrong></h2>");
}
else
	response.sendRedirect("newCustomer.jsp?s=Date is high compare to today,please select less or equal date..&c=red");
	
%>
<table align="center"> <tr><td></td><td><a href="newCustomer.jsp"> <button type="submit">Back</button></a></td></tr></table>

</body>
</html>