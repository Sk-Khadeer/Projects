<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*,java.io.*" %>

<%
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String email=request.getParameter("email");
String userid=request.getParameter("userid");
String password=request.getParameter("password");
String image1=request.getParameter("myimg");

Connection con=null;
PreparedStatement ps=null;
FileInputStream fis=null;

try
{
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar", "root", "khadeer@944");
//Statement st=con.createStatement();
//File image=new File(image1);
File image=new File("C:/Users/user181/Downloads/download.jpg");
//int i=st.executeUpdate("insert into users(fname,lname,email,userid,password,image)values('"+fname+"','"+lname+"','"+email+"','"+userid+"','"+password+"','"+image+"')");
ps = con.prepareStatement("insert into users(fname, lname, email,userid,password,image) " + "values(?,?,?,?,?,?)"); 
		ps.setString(1, fname); 
		ps.setString(2, lname); 
		ps.setString(3, email);
		ps.setString(4,userid);
		ps.setString(5,password);
		
		fis=new FileInputStream(image);
		ps.setBinaryStream(6, (InputStream) fis, (int) (image.length())); 
		int count = ps.executeUpdate(); 
if(count>0){
out.println("Thank you for register ! Please <a href='index.html'>Login</a> to continue.");
}
}
catch(Exception e)
{
System.out.print(e);
	e.printStackTrace();
}
%>