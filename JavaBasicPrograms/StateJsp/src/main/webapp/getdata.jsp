<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>user entered data is</h1>
<%
/** 2. COOKIES

Cookie c[]=request.getCookies();
if(c!=null){
	for(int i=0;i<c.length;i++){
		Cookie c1=c[i];
		out.print("name is : "+c1.getName()+"--");
		out.print("value is : "+c1.getValue()+"<br>");
	}
}**/
String uname=(String)session.getAttribute("sun");
String supwd=(String)session.getAttribute("spwd");

%>


<!-- 1.HIDDEN VARIABLES
username is <%=request.getParameter("hun") %><br>
password is <%=request.getParameter("hpwd") %><br>
-->
un is <%=uname %>
password is <%=supwd %>
firstname is <%=request.getParameter("fn") %><br>
lastname is <%=request.getParameter("ln") %><br>


</body>
</html>