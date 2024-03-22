package javaaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcccccccccccccc {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
//		try {
//				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","khadeer@944");
//				Statement s=c.createStatement();
//					int r=s.executeUpdate("insert into customer values(3,'sreedar','hyd')");  
//				System.out.println("inserted sucessfully");
//			 } catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
		
//		try (			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","khadeer@944");
//			Statement s=c.createStatement();
//			){
//			String sql = "CREATE DATABASE SREEDAR";
//	         s.executeUpdate(sql);
//	         System.out.println("Database created successfully...");   
//	         String sql1="use sreedar";
//	         s.executeUpdate(sql1);
//	         System.out.println("Database changed...");   
//	         String sql2="create table srujana(id int(5),name varchar(20),loc varchar(20))";
//	         s.executeUpdate(sql2);
//	         System.out.println("table created...");   
//	         s.executeUpdate("insert into srujana values(1,'srujana','hyd')");
//	         s.executeUpdate("insert into srujana values(2,'sreedar','hyd')");
//				System.out.println("inserted sucessfully");
//				   ResultSet rs = s.executeQuery("select * from srujana");  
//		            if (rs != null) 
//		                while (rs.next()) 
//		                System.out.println("________________________________________");  
//		                System.out.println("Id : " + rs.getInt(1));  
//		                System.out.println("Name : " + rs.getString(2));  
//		                System.out.println("Loc  : " + rs.getString(3));  
//		                System.out.println("________________________________________");  
//		             
//		           
//		         
//		 } catch (SQLException e) 
//		
//		{
//			e.printStackTrace();
//		}
		
//		Connection con = null;
//		ResultSet rs = null,rs1=null;
//		String url = "jdbc:mysql://localhost:3306/";
//		String user = "root";
//		String password = "khadeer@944";
//		try
//		{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(url, user, password);
//			Statement s=con.createStatement();
		//rs = con.getMetaData().getCatalogs();
//		if(rs.next())
//			{
//				String catalogs = rs.getString(1);
//				if(dbName.equals(catalogs))
//				{
//					System.out.println("the database "+dbName+" exists");
//				}
//				else {
//					String sql = "CREATE DATABASE sreedar";
//					s.executeUpdate(sql);
//					System.out.println("Database sreedar created successfully...");   
//				}
//			}
//		 System.out.println(con.getMetaData().getCatalogs());
//		}
//		catch(Exception ex){
//		ex.printStackTrace();
//		}
//		finally{
//		 rs.close(); con.close();
//		 }
			Connection con = null;
			ResultSet rs = null,rs1=null;
			String url = "jdbc:mysql://localhost:3306/";
			String user = "root";
			String password = "khadeer@944";
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				Statement s=con.createStatement();
				String dbName = "sreedar";
				rs = s.executeQuery("Show Databases");
				
				int p=0;
				while(rs.next())
				{
		    	  if(rs.getString(1).equals(dbName))
		    	  {
		    		  System.out.println("Sorry the database is already exist");
		    		  p++;
		    	  }
				} 
				if(p==0)
				{
		    	  String sql = "CREATE DATABASE sreedar";
					s.executeUpdate(sql);
					System.out.println("Database sreedar created successfully...");
				}	
		      
		      
		      String sql1="use "+dbName;
			  s.executeUpdate(sql1);
			  System.out.println("Current Database is :"+dbName);
			         
			         
			  String tableName="aswanth";
			  rs1 = s.executeQuery("Show tables");
			  int q=0;
			  while(rs1.next())
			  {
				if(rs1.getString(1).equals(tableName))
				{ 
				  System.out.println("Sorry the table is already exist");
//				  s.executeUpdate("insert into "+tableName+" values(1,'salman','hyd')");
//				  System.out.println("values  inserted successfully in table :"+tableName);
				  q++;
				}
			  }
			  if(q==0)
			  {
				 String sql2="create table "+tableName+"(id int(5),name varchar(20),loc varchar(20))";
				 s.executeUpdate(sql2);
				 System.out.println("table created...");
			  }
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally {
			rs.close();
			con.close();
		}

		
	}
}

