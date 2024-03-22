package practice;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


	class Users{
	    private int Id;
	    private String name;
	    private String loc;
	 
	    public Users(){}
	    public Users(int id, String name,String loc){
	        this.Id = id;
	        this.name = name;
	        this.loc = loc;
	       
	    }
	    
	    public int getId(){
	        return this.Id;
	    }
	    
	    public String getName(){
	        return this.name;
	    }
	    
	       public String getloc(){
	        return this.name;
	    }
	       
	    
	     // create a tostring method to diplay data
	     public String ToString(){
	         return this.Id+" "+this.name+" "+this.loc;
	     }
	}


	public class Employee {
	   
	    // create a method to get the connection
	    public static Connection getConnection(){
	        
	        Connection con = null;
	        
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sreedar", "root", "khadeer@944");
	        } catch (SQLException ex) {
	            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return con;
	    }
	    
	    public static void main(String[] args){

	        // create the hashmap
	        HashMap<Integer,Users> map = new HashMap<Integer,Users>();
	        
	        Statement st = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	        Users u;
	        
	        try{
	            st = (Statement) con.createStatement();
	            rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM aswanth");
	            while(rs.next()){
	                Integer id = rs.getInt("id");
	                String name = rs.getString("name");
	                String loc= rs.getString("loc");
	               
	                
	                u = new Users(id,name,loc);
	                
	                // set data in the hashmap
	                map.put(id, u);
	            }
	        }catch(SQLException ex){
	            ex.printStackTrace();
	        }
	        
	        // display data from the hashmap
	        for(Integer i : map.keySet()){
	            Users us = map.get(i);
	            System.out.println(us.getId()+" "+us.getName()+" "+us.getloc());
	        }
	        
	        // show data from hashmap using our ToString Method
	        System.out.println("______With ToString______");
	        for(Integer i : map.keySet()){
	            Users us = map.get(i);
	            System.out.println(us.ToString());
	        }
	        
	        // now your data are displayed from mysql database using hashmap 
	    }
	}
