<%@page isELIgnored="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1 style="color:red;text-align:center;">
	<b> Your approved loan is:</b>
	<h3 style="color:blue;text-align:center;border:3px solid green;width:100px" ><%=new Random().nextInt(1000000000) %></h3> 
	</h1>
</center>


<center><h4><a href="/home">Home</a></h4></center>
<center><h4><a href="/signout">logout</a></h4></center>

</body>
</html>