<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DETAILS</title>
	<style>
     	.container
     	 {
     	    background-color:lightyellow;
            width:25%;
        	border:4px solid blue;
         	margin:auto;
         	padding:20px;
         }
	</style>
</head>
<body>
 <div class="container">
<table align="center">
<h1 align="center">	View Details</h1>
<tr><h6  align="center">-------------------------------</h6></tr>
  <tr><td><h3><b>Name :</b></td> <td> ${name}</h3></td></tr>
<tr><td><h3><b>Email :</b></td> <td>  ${mail}</h3></td></tr>
<tr><td><h3><b>Mobile no :</b></td> <td>  ${mn}</h3></td></tr>
<tr><td><h3><b>Id :</b> </td> <td> ${id}</h4></t3></tr>
<tr><td><h3><b>Address :</b></td> <td>  ${add}</h3></td></tr>
</table>
</div>
</body>
</html>
