package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class Inserting {

	public static void main(String[] args) {
		Connection c=null;
	   PreparedStatement p=null;
	   Scanner sc=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","khadeer@944");
			String s="insert into employee values(?,?,?,?)";
		    p=c.prepareStatement(s);
           sc=new Scanner(System.in);
		while(true) {
			System.out.print("Employee id :");
			int eno=sc.nextInt();
			System.out.print("Employee name :");
			String ename=sc.next();
			System.out.print("Employee location :");
			String loc=sc.next();
			System.out.print("Employee salary :");
			float sal=sc.nextFloat();
			
		p.setInt(1, eno);
		p.setString(2, ename);
		p.setString(3,loc);
		p.setFloat(4, sal);
		
		int rowCount=p.executeUpdate();
		if(rowCount==1)
		{
			System.out.println("EMPLOYEE "+eno+" inserted sucessfully");
			System.out.print("add one more employee[yes/no] : ");
			String option =sc.next();
			if(option.equalsIgnoreCase("yes")){
			continue;
		    }else
		    {
			break;
			}
		}
		else
			{
				System.out.println("EMPLOYEE "+eno+" inserted failure");
			}
		}
	
		}
		catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			p.close();
			c.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	}

}
