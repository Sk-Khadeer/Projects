package com.jdbc.app5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteMethods {

	public static void main(String[] args) {
		Connection c=null;
		Statement s= null;
		ResultSet r=null;
		boolean b;
		int i=0;
		try {
		 c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
		 s=c.createStatement();
		 r=s.executeQuery("select * from emp");
		 while(r.next()) {
			 System.out.println(r.getInt(1)+"\t"+r.getString(2));
		 }
		 System.out.println();
		 i=s.executeUpdate("insert into emp values(13,'ZZZ')");
		 System.out.println("Inserted Record sucessfully :"+i);
	
		 
		 } catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
