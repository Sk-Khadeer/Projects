package com.jdbc.app4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResources {

	public static void main(String[] args) {
		
		System.out.println("ORACLE DATABASE ");
		System.out.println("---------------------------");
		try (
			Connection c = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","khadeer");
			Statement s=c.createStatement();
				ResultSet r=s.executeQuery("select * from emp");
		){ while(r.next()) {
			 System.out.println(r.getInt(1)+"\t"+r.getString(2));
		 }
		 } catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
System.out.println("MYSQL DATABASE ");
System.out.println("---------------------------");
		try (
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","khadeer@944");
				Statement s=c.createStatement();
					ResultSet r=s.executeQuery("select * from customer");
			){ while(r.next()) {
				 System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t"+r.getString(3));
			 }
			 } catch (SQLException e) 
			{
				e.printStackTrace();
			}

	}

}
