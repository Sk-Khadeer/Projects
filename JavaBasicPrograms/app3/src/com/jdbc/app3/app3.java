package com.jdbc.app3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class app3 {

	public static void main(String[] args) {
		Connection c=null;
		Statement s= null;
		// r=0;
		try {
		 c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
		 s=c.createStatement();
		 s.executeUpdate("update emp set ename='kk' where eno=1");
		System.out.println("Updated Record Sucessfully");
		 } catch (SQLException e) 
		{
			e.printStackTrace();
		}


	}

}
