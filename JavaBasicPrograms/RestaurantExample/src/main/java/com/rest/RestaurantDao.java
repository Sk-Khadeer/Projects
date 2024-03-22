package com.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944");
		}catch(Exception e) {
			e.printStackTrace();		}
		return con;
		}
	
public static int save(Restaurant r)
{
int s=0;
try {
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("insert into Restaurant values(?,?,?,?)");
	ps.setInt(1, r.getId());
	ps.setString(2,r.getTitle());
	ps.setDouble(3, r.getAmount());
	ps.setString(4,r.getDate());
	s=ps.executeUpdate();
	}catch(Exception e) 
	{
	e.printStackTrace();		
	}
   return s;
}


public static List<Restaurant> getAllRecords() {
	List<Restaurant> l=new ArrayList<Restaurant>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from restaurant");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Restaurant r=new Restaurant();
			r.setId(rs.getInt("id"));
			r.setTitle(rs.getString("title"));
			r.setAmount(rs.getDouble("amount"));
			r.setDate(rs.getString("date"));
			l.add(r);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}


public static List<Restaurant> getAllRecord(int start,int total) {
	List<Restaurant> l=new ArrayList<Restaurant>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from restaurant limit "+(start-1)+","+total);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Restaurant r=new Restaurant();
			r.setId(rs.getInt("id"));
			r.setTitle(rs.getString("title"));
			r.setAmount(rs.getDouble("amount"));
			r.setDate(rs.getString("date"));
			l.add(r);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}
}


