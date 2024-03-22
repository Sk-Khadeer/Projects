<%@page isELIgnored="false" import="java.util.*"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Show Balance</h1>
<b>your balance is : <%=new Random().nextInt(10000000) %> </b>
<a href="/home">Home</a>
<a href="/logout">logout</a>
</body>
</html>