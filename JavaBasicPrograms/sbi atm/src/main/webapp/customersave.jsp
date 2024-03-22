<%@ page import="com.sbi.AtmDao"%>
<jsp:useBean id="b" class="com.sbi.Atm"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<!DOCTYPE html>
<html>
<head>
<style>
h2{
color:red;
}

</style>
<meta charset="ISO-8859-1">
<title>Added</title>
</head>

<body>
<%@ include file="newcustomer.html" %>
<%
int i=AtmDao.save(b);
if(i>0)
{
out.print("<h2  style='color:blue;'>Customer Added Sucessfully !!!</h2>");
}
else
{
	out.print("<h2 >Something Went Wrong</h2>");
}
%>
</body>
</html>