package com.jdbc.app5;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Html
{
   public static void main(String[] args) 
   {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "khadeer");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp");
	        String data="";
	        data=data+"<html><body><center><table border='1' bgcolor='lightgreen' ";
			data=data+"<tr><td>ENO</td><td>ENAME</td></tr>";
			while(rs.next())
			{
				data = data+"<tr>";
				data = data+"<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td>";
				data = data+"</tr>";
			}
			data=data+ "</table></center></body></html>";
			FileOutputStream f=new FileOutputStream("D:/html/emp1.html",true);
			byte[] b=data.getBytes();
			f.write(b);
			System.out.println("Sucessfully Created file and stored in what u have given location path,");
			System.out.println( "Once go and open that file you will see the employees data present in emp table ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				st.close();
				con.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
   }
