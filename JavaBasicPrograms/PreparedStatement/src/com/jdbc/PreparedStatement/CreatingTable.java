package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class CreatingTable 
{
      public static void main(String[] args) 
      {
		Connection c=null;
	    Statement s=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","khadeer@944");
			s=c.createStatement();
			String tn="employee";
			String s1="CREATE TABLE  "+tn +
	                   "(id INTEGER not NULL  AUTO_INCREMENT , " +
	                   " name VARCHAR(255), " + 
	                   " loc VARCHAR(255), " + 
	                   " sal Float(6), " + 
	                   " DOJ date, " + 
	                   " PRIMARY KEY ( id ))";
			s.executeUpdate(s1);
			System.out.println("Successfully created table with name :"+tn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				s.close();
				c.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
