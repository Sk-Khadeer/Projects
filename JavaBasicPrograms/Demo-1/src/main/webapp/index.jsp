<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>
	<style>
     	.container
     	 {
     	      
         		width:20%;
        	border:3px solid black;
         	margin:auto;
         	margin-top:10%;
         	padding:20px;
         }
         .h1{
         padding-top: 200px;
         }
	</style>
</head>
<body>

<div class="container">
<h1 align='center'>Login Form</h1>
<form action="login"> 
<table align="center"> 
<tr><td ><b>UserName : </b></td><td><input type="text" placeholder="Enter Username" name="name"/><td></tr>

<tr><td><b>Password :  </b></td><td><input type="Password" placeholder="Enter Password" name="pass"/> <td></tr>
<tr></tr> 
<tr><td> </td><td><input type="submit" name="submit">&nbsp;&nbsp; <input type="reset" name="reset">
</table>

</form>  
</div> 
</body>
</html>