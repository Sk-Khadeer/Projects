package com.sbi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class AtmDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944");
		}catch(Exception e) {
			e.printStackTrace();		}
		return con;
		}
	
public static int save(Atm a)
{
int s=0;
try {
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("insert into atm values(?,?,?,?,?,?)");
	ps.setInt(1, a.getId());
	ps.setString(2, a.getCustomer_name());
	ps.setString(3,a.getDebit_card_number());
	ps.setInt(4, a.getPin_number());
	ps.setString(5,a.getBalance());
	
	DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now=LocalDateTime.now();
	ps.setString(6,df.format(now));
	s=ps.executeUpdate();
	}catch(Exception e) 
	{
	e.printStackTrace();		
	}
   return s;
}

public static List<String> debitCardNumber() {
	List<String> l1 = new ArrayList<String>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select debit_card_number from atm");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			l1.add(rs.getString(1));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l1;
}


public static List<Atm> verifyPin(){
List<Atm> l1=new ArrayList<Atm>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select debit_card_number,pin_number from atm");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		   Atm a=new Atm();
		   a.setDebit_card_number(rs.getString("debit_card_number"));
		   a.setPin_number(rs.getInt("pin_number"));
			l1.add(a);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l1;
}

public static List<String> debit() {
	List<String> l = new ArrayList<String>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select debit_card_number,balance from atm");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			l.add(rs.getString(1));
			l.add(rs.getString(2));	
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}

public static void update(String s,double amount){
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update atm set balance="+amount+" where debit_card_number="+s);
		ps.execute();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	
	}
}

public static List<String> bal() {
	List<String> list = new ArrayList<String>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select debit_card_number,balance from atm");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(rs.getString(1));
			list.add(rs.getString(2));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
public static List<String> changePin() {
	List<String> l = new ArrayList<String>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select pin_number from atm");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			l.add(rs.getString(1));
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}

public static void updatePin(String pin,String debit) {
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update atm set pin_number="+pin+" where debit_card_number="+debit);
		ps.execute();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	
	}
}

public static int saveMini(List<String> u,String k) {
	int status=0;
	try {
		Connection con=getConnection();
		DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String date=dft.format(now);
		PreparedStatement ps=con.prepareStatement("insert into ministmt values("+u.get(0)+","+u.get(1)+","+u.get(2)+",'"+k+"','"+date+"');");
		status=ps.executeUpdate();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	
	}
	return status;
}



}
