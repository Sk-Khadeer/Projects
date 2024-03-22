package com.jdbc.app2;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class app2 {

	public static void main(String[] args) {
		
				Connection c=null;
				Statement s= null;
			
				try {
				 c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
				 s=c.createStatement();
				 s.executeUpdate("insert into emplo values(8,'kkk')");
				System.out.println("inserted sucessfully");
				 } catch (SQLException e) 
				{
					e.printStackTrace();
				}
		

	}

}
