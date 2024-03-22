<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>form Page</title>
	<style>
     	.container
     	 {
         		width:40%;
        	border:1px solid black;
         	margin:auto;
         	padding:20px;
         }
	</style>
</head>
<body>
  <div class="container">
     <h1>My form</h1>
      <form action="/Register" method="post">  
         <table>
            <tr><td> UserName : </td> <td><input type="text" name="uname"></td></tr>
            <tr><td> Password : </td> <td><input type="password" name="upwd"></td></tr>
            <tr><td> Email : </td> <td><input type="text" name="uemail"></td></tr>
            <tr><td> mobileno : </td> <td><input type="text" name="umn"></td></tr>
            <tr><td></td> <td><button type="submit">Register</button><button type="reset">Reset</button></td>
  		</table> 
	</form>
	</div> 

</body>
</html>