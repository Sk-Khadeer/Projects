<%@page import="java.util.HashMap"%>
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
<%@ page import="com.sbi.*"%>
<jsp:useBean id="b" class="com.sbi.Atm"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<form action="deposit_success.jsp" >
<%
String s=request.getParameter("debit_card_number");
String s1=request.getParameter("pin_number");

List<Atm> i=AtmDao.verifyPin();
int c=0;
for(Atm a:i)
{
	String a1=a.getDebit_card_number();
	int a2=a.getPin_number();
	String s2=Integer.toString(a2);
	
	if(s.equals(a1) && s1.equals(s2)){
		c=1;
	}
}
if(c!=0)
{
		out.print("Ur debit card and pin number is matched");
	out.print("<input type='hidden' name='debit_card_number' value='"+s+"'</input>");
		out.print("<h3>Enter Amount:<input type='tel' name ='amount' pattern='[1-9]{1}[0-9]*(.?){1}[0-9]*'"+"<br>");
		out.print("<button type='submit'>submit</button>");
}
else
{
		out.print("U entered wrong password");
		out.print("<a href='deposit_verify.jsp?debit_card_number="+s+"'>try again !!!!!</a>");
			
}
%>
</form>
</body>
</html>