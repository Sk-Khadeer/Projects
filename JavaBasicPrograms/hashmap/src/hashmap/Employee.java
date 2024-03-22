package hashmap;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


class Users{
Integer id;
    String name;
	 String loc;
	public Users()
	{ 
		super();
	}
	public Users(Integer id,String name,String loc)
	{
		this.id=id;
		this.name=name;
		this.loc=loc;
	}
	public Integer getId() {
	return id;
	}
	public void setId(Integer id) {
		this.id = id;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", loc=" + loc + "]";
	}
	
}
public class Employee
{
	public static Connection getConnection()
	 {
		 Connection con=null;
		 try 
		 {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar","root","khadeer@944");
		 }catch(SQLException ex)
		 {
			 ex.printStackTrace();
		 }
      return con;
	 }
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.new emp\n2.Exit");
		int n=sc.nextInt();
		int num=0;
		do {
			System.out.println("enter a number :");
			 num=sc.nextInt();
			if(n==1)
			{
			
		System.out.print("Enter user id :");
		int a=sc.nextInt();
		System.out.print("Enter user name :");
		String s1=sc.next();
		System.out.print("Enter user loc :");
		String s2=sc.next();
		
		HashMap<Integer, Users> m=new HashMap<Integer, Users>();
		Users u=new Users(a,s1,s2);
		m.put(2, u);
		
		Statement st=null;
		ResultSet rs=null;
		Connection con=getConnection();
		
	
		try 
		{
			st=con.createStatement();
			String sq="insert into aswanth values("+u.id+",'"+u.name+"','"+u.loc+"')";
			st.executeUpdate(sq);
			rs=st.executeQuery("select * from aswanth");
			while(rs.next())
			{
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				String loc=rs.getString("loc");
		
				u=new Users(id,name,loc);
				m.put(id, u);
			}
		}catch(Exception ex)
		{
            ex.printStackTrace();
        }
		
		for(Integer i:m.keySet()) 
		{
			Users ui=m.get(i);
			System.out.println(ui.getId()+" "+ui.getName()+" "+ui.getLoc());
		}
			}
		}while(n!=2);
	}
}
