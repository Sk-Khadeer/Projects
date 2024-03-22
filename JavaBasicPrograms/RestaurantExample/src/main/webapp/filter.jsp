<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.rest.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.b {
  padding-top: 20px;
  padding-right: 30px;
  padding-bottom: 10px;
  padding-left: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<%@ include file="index.html" %>
<div class="b" style='background-color:yellow;'>
<%
String f1=request.getParameter("f");
if(f1==null){
	f1="";
}

int pageid;
String spageid=request.getParameter("page");  
if(spageid==null)
{
	pageid=1;
}
else pageid=Integer.parseInt(spageid);  


int total=5;
if(pageid==1){}  
else{  
    pageid=pageid-1;  
    pageid=pageid*total+1;  
}
List<Restaurant> l=RestaurantDao.getAllRecord(pageid,total); 

//List<Restaurant> l1=RestaurantDao.getAllRecords();  

out.print("<table  align='center' border='1' cellpadding='4' width='60%'>");  
out.print("<tr><th>ID</th><th>TITLE</th><th>Amount</th><th>Date</th></tr>"); 
for(Restaurant r:l)
{
		String d=r.getDate().substring(0, 4);
		if(f1.equals(d))
		{
			out.print("<tr><td>"+r.getId()+"</td><td>"+r.getTitle()+"</td><td>"+r.getAmount()+"</td><td>"+r.getDate()+"</td></tr>");
		}
}
out.print("</table>");  
%>
  <h2 >
<a href="filter.jsp?page=1&f=<%=f1%>">1</a>  
<a href="filter.jsp?page=2&f=<%=f1%>">2</a>  
<a href="filter.jsp?page=3&f=<%=f1%>">3</a>  
</h2> 
</div>
</body>
</html>