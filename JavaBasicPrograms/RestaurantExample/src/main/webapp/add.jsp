<%@ page import="com.rest.RestaurantDao" %>
<jsp:useBean id="r" class="com.rest.Restaurant"></jsp:useBean>
<jsp:setProperty property="*" name="r"/>


<%@ include file="index.html" %>
<%
int i=RestaurantDao.save(r);
if(i>0)
{
out.print("<h1>added sucessfully</h1>");
}
else
{
	out.print("<h1>something went wrong</h1>");
}
%>