<%@page import="com.sbi.Atm"%>
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
<form action="setPin.jsp">
<%
String debit=request.getParameter("debit_card_number");
String old_pin=request.getParameter("pin_number");
List<Atm> i=AtmDao.verifyPin();
int c=0;
for(Atm a:i)
{
	String a1=a.getDebit_card_number();
	int a2=a.getPin_number();
	String s2=Integer.toString(a2);
	
	if(debit.equals(a1) && old_pin.equals(s2)){
		c=1;
		
	}
}
if(c!=0){
	out.print("Ur debit card and pin number is matched");
	out.print("<table align='center'>");
	out.print("<input type='hidden' name='debit_card_number' value='"+debit+"'</input>");
	out.print("<input type='hidden' name='pin_number' value='"+old_pin+"'</input>");
	out.print("<tr><td>New pin</td><td><input type='tel' name ='new_pin'  pattern='[0-9]{4}'></td></tr>");
	out.print("<tr><td>Re-enter pin</td><td><input type='tel' name ='re-enter_pin'  pattern='[0-9]{4}'></td></tr>");
	out.print("<tr><td></td><td><input type='submit' value='submit'><input type='reset' value='reset'></td></tr>");
out.print("</table>");
	
}
	else{
		out.print("U entered wrong password");
		out.print("<a href='changePin.jsp?debit_card_number="+debit+"'>try again !!!!!</a>");
	}

%>
</form>
</body>
</html>