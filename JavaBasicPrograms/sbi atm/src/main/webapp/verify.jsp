<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.sbi.AtmDao"%>
<jsp:useBean id="b" class="com.sbi.Atm"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

h2{
color: green;
}
div{
color: blue;
}

body{
background-color:powderblue
}
button {
	margin-left: 100px;
}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align='center'>

<div>
<form action="verifyPin.jsp" >
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
	out.print("<table align='center' >");
	out.print("<tr><td><h3>Your Entered  Number is Correct : </h3></td><td><h2 style='color:red;'>"+s+"</h2></td></tr>");
	out.print("</table>");
	out.print("<table align='center'>");
	out.print("<tr><td><h2>Enter pin to proceed :<input type='tel' name ='pin_number'  pattern='[0-9]{4}' </h2> </td></tr>"+"<br>");
	out.print("<tr><td><button type='submit'>Submit</button></td></tr>");
	out.print("</table>");
	out.print("<input type='hidden' name='debit_card_number' value='"+s+"'</input>");
}
else{ 
	out.print("<table align='center'>");
	out.print("you entered debit card is incorrect,please ");
	out.print("<a href='withdraw.jsp'>try again !!!!!</a>");
	out.print("</table>");
}
%>
</form>

<div class="b">
<table align="center"> <a href="withdraw.jsp"> <button type="submit">Back</button></a></table>
</div>
</div>
</body>
</html>