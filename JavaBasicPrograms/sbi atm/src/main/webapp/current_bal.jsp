<%@page import="java.util.List"%>
<%@page import="com.sbi.AtmDao"%>
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
String s=request.getParameter("debit_card_number");
//out.print(s);

List<String> l=AtmDao.bal();
for(String i:l){
if(s.equals(i)){out.print(l.get(l.indexOf(i)+1));}
}
%>
<a href="index.html"> back</a>
</body>
</html>