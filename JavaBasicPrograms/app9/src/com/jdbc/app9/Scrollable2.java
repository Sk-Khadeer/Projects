package com.jdbc.app9;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scrollable2 {

	public static void main(String[] args) throws Exception {
		Connection c=null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","khadeer@944");
		Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//		ResultSet r=s.executeUpdate("insert ");
	
		System.out.println("Employees details in before doing Updations");
		System.out.println("ENO   ENAME");
		System.out.println("----------------------------------------------");
//		while(r.next()) 
//		{
//		 System.out.println(r.getInt(1)+"\t"+r.getString(2));
//	    }
//      	System.out.println("Application is in pausing state,please update database");
//      System.in.read();
//      r.beforeFirst();
//      System.out.println("Employees details after doing Updations");
//  	System.out.println("ENO   ENAME");
//		System.out.println("----------------------------------------------");
//	    while(r.next())
//     	{
//	    	r.refreshRow();
//		 System.out.println(r.getInt(1)+"\t"+r.getString(2));
//	    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	  finally { 
		  try {
               c.close();
		  }
		  catch(Exception e) {
				e.printStackTrace();
			}
	  }

	}

}
