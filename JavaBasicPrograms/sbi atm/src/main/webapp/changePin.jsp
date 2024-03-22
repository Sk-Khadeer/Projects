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
<form action="changingPin.jsp">
<% 
String s=request.getParameter("debit_card_number");
//out.print(s);

List<String> i=AtmDao.debitCardNumber();
int c=0;
for(String a:i)
{
	if(a.equals(s))
		c=1;
}
if(c!=0)
{
	out.print("Your entered debit card number is correct ");
	out.print("<input type='hidden' name='debit_card_number' value='"+s+"'</input>");
	out.print("<table align='center'>");
	out.print("<tr><td>Enter old pin</td><td><input type='tel' name ='pin_number'  pattern='[0-9]{4}'></td></tr>");
	out.print("<tr><td><button type='submit'>submit</button></td></tr>");
	out.print("</table>");
	
	
}
else{ 
	out.print("you entered debit card is incorrect,please ");
	out.print("<a href='pin.jsp'>try again !!!!!</a>");
}
 %>
</form>
</body>
</html>