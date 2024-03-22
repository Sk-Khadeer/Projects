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
<body align='center'>
<%
String debit=request.getParameter("debit_card_number");
String new_pin=request.getParameter("new_pin");

String Re_enter=request.getParameter("re-enter_pin");
String old_pin=request.getParameter("pin_number");
//out.print(debit+ " "+new_pin+" "+Re_enter+" "+old_pin);

List<String> i=AtmDao.changePin();

int c=0;
for(String a:i)
{
if(a.equals(new_pin)){
	c=1;
}
}
if(c!=1){
	if(new_pin.equals(Re_enter)){
		AtmDao.updatePin(new_pin,debit);
		out.print("pin is updated");
	}
	else{
		out.print("both pin are not matched");
	}
	
}
else
{
	out.print("old pin and new pin is same, change it");
	out.print("<a href='changingPin.jsp?pin_number="+old_pin+"&debit_card_number="+debit+"'>try again !!!!!</a>");
	
}


%>
</body>
</html>