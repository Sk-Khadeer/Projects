package com.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	private String  dbDriver= "oracle.jdbc.driver.OracleDriver";
	private String dbURL ="jdbc:oracle:thin:@localhost:1521:xe";
	private String dbUsername="system";
	private String dbPassword="khadeer";
	public void loadDriver(String dbDriver)  {
		
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			 con = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
		}
	public String insert(Member member)  {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String result="data entered sucessfully";
		String sql="insert into member values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,member.getUname());
			ps.setString(2,member.getPwd());
			ps.setString(3,member.getEmail());
			ps.setString(4,member.getPhone());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			result="data not entered";
		}
		return result;
	}
}
