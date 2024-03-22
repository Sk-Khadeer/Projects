package com.jdbc.app8.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String status="";
	public User() {
	try 
	{
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "khadeer");
		st = con.createStatement();
	}
	catch(Exception e){
		e.printStackTrace();
		}
	}
	public String checkLogin(String uname,String upwd) {
	try {
		   rs=st.executeQuery("select * from users where UNAME='"+uname+"'and UPWD='"+upwd+"'");
		  boolean b=rs.next();
		  if(b==true)
	     	{
			status="login sucess";
			
		   }
		  else
		  {
			status="login failure";
		  }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return status;
	}

}
