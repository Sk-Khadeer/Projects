<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="AB" class="com.beanJSP.Ashu"></jsp:useBean>
<%
int a=AB.cube(4);
out.print(a);
%>
</body>
</html>