package com.servletDB;
import java.io.*;  
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

public class Register  extends HttpServlet {  
	
	private static final long serialVersionUID = -1180061498431636646L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	  
	response.setContentType("text/html");  
	PrintWriter out = response.getWriter();  
	String a=request.getParameter("userName");  
	String b=request.getParameter("userPass");  
	String c=request.getParameter("userEmail");  
	String d=request.getParameter("userCountry");  
	          
	try{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","khadeer");  
	PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?)");  
	ps.setString(1,a);  
	ps.setString(2,b);  
	ps.setString(3,c);  
	ps.setString(4,d);  
	int i=ps.executeUpdate();  
	if(i>0)  
	out.print("You are successfully registered...");  
	}catch(Exception e2) 
	{
		System.out.println(e2);
	}  
	out.close();  
	}  
}  


