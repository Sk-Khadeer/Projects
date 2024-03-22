package com.jdbc.app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Salman {

	public static void main(String[] args) {
		Connection c=null;
		Statement s= null;
//		int r=0;
		try {
		 c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
		 s=c.createStatement();
		 s.executeUpdate("insert into salman values(4,'khadeer')");
		 System.out.println("values present in table is displayed below ");
		 System.out.println("----------------------------------------------");
//		 while(r.next()) {
//			 System.out.println(r.getInt(1)+"\t"+r.getString(2));
//		 }
		 } catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

	}


