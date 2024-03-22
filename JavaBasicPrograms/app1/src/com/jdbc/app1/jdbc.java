package com.jdbc.app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

	public static void main(String[] args) {
		Connection c=null;
		Statement s= null;
		ResultSet r=null;
		try {
		 c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
		 s=c.createStatement();
		 r=s.executeQuery("select * from emp");
		 System.out.println("values present in table is displayed below ");
		 System.out.println("----------------------------------------------");
		 while(r.next()) {
			 System.out.println(r.getInt(1)+"\t"+r.getString(2));
		 }
		 } catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
