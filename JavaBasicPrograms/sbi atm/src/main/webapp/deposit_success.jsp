<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sbi.*"%>
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
String s1=request.getParameter("amount");
int g_amount=Integer.parseInt(s1);

List<String> l=AtmDao.debit();
for(String i:l){
if(s.equals(i)){
	double db_amount=Double.parseDouble(l.get(l.indexOf(i)+1));
		
		db_amount=db_amount+g_amount;
		AtmDao.update(s,db_amount);
		List<String> ms=new ArrayList();
		ms.add(s);
		ms.add(s1);
		String up=Double.toString(db_amount);
		ms.add(up);
		String k="credited";
		AtmDao.saveMini(ms,k);
		out.print("<h4 align='center'> Amount Credited to Your Account Successfully, added amount is </h3><h1> "+s1+"</h1>");
}	
}
%>
</body>
</html>