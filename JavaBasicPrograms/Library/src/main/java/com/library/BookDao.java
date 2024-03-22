package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class BookDao
{
	public static Connection getConnection() 
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944");
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	  return con;
	}
	
public static int save(Book b)
{
int s=0;
try {
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("insert into book values(?,?,?,?,?,?)");
	ps.setInt(1, b.getId());
	ps.setString(2, b.getBook_name());
	ps.setInt(3, b.getCost());
	ps.setString(4,b.getAuthor_name());
	ps.setInt(5, b.getTotal_number_of_copies());
	ps.setInt(6, b.getTotal_number_of_copies());
	s=ps.executeUpdate();
	}catch(Exception e) 
	{
	e.printStackTrace();		
	}
   return s;
}

public static int save(Customer c)
{
int s=0;
try {
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
	ps.setInt(1, c.getId());
	ps.setString(2, c.getCustomer_name());
	ps.setString(3, c.getCity());
	ps.setString(4,c.getEmail());
	ps.setString(5, c.getDate_of_join());
	ps.setInt(6,c.getTotal_no_books());
	s=ps.executeUpdate();
	}catch(Exception e) 
	{
	e.printStackTrace();		
	}
   return s;
}
public static List<String> editBook() {
	List<String> list = new ArrayList<String>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select id from book");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(rs.getString(1));
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}


public static List<Book> getBookById(int id) {
	List<Book> l=new ArrayList<Book>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from book where id="+id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Book b=new Book();
			b.setId(rs.getInt("id"));
			b.setBook_name(rs.getString("book_name"));
			b.setAuthor_name(rs.getString("author_name"));
			b.setCost(rs.getInt("cost"));
			b.setTotal_number_of_copies(rs.getInt("total_number_of_copies"));
			b.setAvailable_copies(rs.getInt("available_copies"));
			
			l.add(b);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}

public static List<String> editCustomer() {
	List<String> list = new ArrayList<String>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select id from customer");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(rs.getString(1));
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}

public static List<Customer> getCustomerById(int id) {
	List<Customer> l=new ArrayList<Customer>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Customer where id="+id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customer b=new Customer();
			b.setId(rs.getInt("id"));
			b.setCustomer_name(rs.getString("customer_name"));
	       b.setCity(rs.getString("city"));
	       b.setEmail(rs.getString("email"));
			b.setDate_of_join(rs.getString("date_of_join"));
			b.setTotal_no_books(rs.getInt("total_no_books"));
			
			l.add(b);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}

public static List<Book> getAllBook() {
	List<Book> l=new ArrayList<Book>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from book");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(2));
			Book b=new Book();
			b.setId(rs.getInt("id"));
			b.setBook_name(rs.getString("book_name"));
			b.setAuthor_name(rs.getString("author_name"));
			b.setCost(rs.getInt("cost"));
			b.setTotal_number_of_copies(rs.getInt("total_number_of_copies"));
			b.setAvailable_copies(rs.getInt("available_copies"));
			
			l.add(b);
			
		}
		System.out.println(l.get(0));
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}


public static List<Customer> getAllCustomer() {
	List<Customer> l=new ArrayList<Customer>();
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Customer");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customer b=new Customer();
			b.setId(rs.getInt("id"));
			b.setCustomer_name(rs.getString("customer_name"));
	       b.setCity(rs.getString("city"));
	       b.setEmail(rs.getString("email"));
			b.setDate_of_join(rs.getString("date_of_join"));
			b.setTotal_no_books(rs.getInt("total_no_books"));
			
			l.add(b);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return l;
}

public static int delete(int id,String table_name){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from "+table_name+" where id="+id);
		
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
}
