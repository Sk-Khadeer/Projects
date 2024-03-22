package com.jdbc.app9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scrollable {

	public static void main(String[] args) throws SQLException {
		
			Connection c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet r=s.executeQuery("select * from emp");
			System.out.println("Employees details in Forward Direction");
			System.out.println("----------------------------------------------");
			while(r.next()) 
			{
			 System.out.println(r.getInt(1)+"\t"+r.getString(2));
		    }
	      	System.out.println("Employees details in Backward Direction");
	      	System.out.println("----------------------------------------");
		    while(r.previous())
	     	{
			 System.out.println(r.getInt(1)+"\t"+r.getString(2));
		    }
		   c.close();
	}

}
