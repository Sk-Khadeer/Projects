<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
/**1. hidden varaibles**/
String uname=request.getParameter("un");
String pass=request.getParameter("pwd");

/** 2.COOKIES
String uname=request.getParameter("un");
String pass=request.getParameter("pwd");
Cookie c1=new Cookie("cun",uname);
Cookie c2=new Cookie("cpwd",pass);

response.addCookie(c1);
response.addCookie(c2);**/

session.setAttribute("sun",uname);
session.setAttribute("spwd", pass);

%>
<form action="./getdata.jsp" method="post">
<!--1..... hidden variables -->
<!-- <input type="hidden" name="hun" value=<%=uname %>> -->
<!--<input type="hidden" name="hpwd" value=<%=pass %>>-->



first name<input type="text" name="fn"><br>
last name <input type="text" name="ln"><br>
<button type="submit">submit</button>
</form>
</body>
</html>