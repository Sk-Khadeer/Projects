package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
protected static Connection database()throws SQLException, ClassNotFoundException
	{
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUsername = "system";
		String dbPassword = "khadeer";
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
		return con;
	}
}
