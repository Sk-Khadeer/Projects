<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

h2{
color: black;
}
div{
color: blue;
}
div.b{
margin-left: 200px;
}
body{
background-color:yellow;
}

</style>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
</head>
<body align="center">
<h2  align="center">Withdraw Amount</h2>
<div>
<form action="verify.jsp">
<table  align="center">
<tr><td><h3>Enter Debit Card number</h3></td><td><input type="tel" name ="debit_card_number"  pattern="[0-9]{12}"></td></tr>
<tr><td></td><td><input type="submit" value="Verify Card Number"></td></tr>
</table>
</form>
</div>
<div class="b">
<table align="center"> <tr><td></td><td></td><td><a href="index.html"> <button type="submit">Back</button></a></td></tr></table>
</div>
</body>
</html>