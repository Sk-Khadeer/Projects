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

<%@ page import="com.sbi.AtmDao"%>
<jsp:useBean id="b" class="com.sbi.Atm"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<form action="deposit_verify_pin.jsp" >
<%
String s=request.getParameter("debit_card_number");
List<String> i=AtmDao.debitCardNumber();
int c=0;
for(String a:i)
{
	if(a.equals(s))
		c=1;
}
if(c!=0)
{
	out.print("Your entered debit card number is correct <h1>"+s+"</h1>");
	out.print("<input type='hidden' name='debit_card_number' value='"+s+"'</input>");
	out.print("<h3>Enter pin to proceed :<input type='tel' name ='pin_number'  pattern='[0-9]{4}' </h3>"+"<br>");
	out.print("<button type='submit'>submit</button>");
}
else{ 
	out.print("you entered debit card is incorrect,please ");
	out.print("<a href='deposit.jsp'>try again !!!!!</a>");
}
%>
</form>
<a href="index.html"> back</a>
</body>
</html>