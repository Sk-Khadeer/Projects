package com.jdbc.app7;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TextFile {

	public static void main(String[] args) {
		
		
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "khadeer");
				Statement st = con.createStatement();
				ResultSet rs =st.executeQuery("select * from emp");
				FileOutputStream f=new FileOutputStream("D:/html/emp.txt");) {
		String data="ENO   ENAME\n";
		
	        
			while(rs.next())
			{
				data = data + rs.getInt(1)+"       "+rs.getString(2)+"\n";
			}
	        
			byte[] b=data.getBytes();
			
			f.write(b);
			System.out.println("Sucessfully Created file and send to D:/html/emp.txt");
			System.out.println("go and check once ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	

	}

}
