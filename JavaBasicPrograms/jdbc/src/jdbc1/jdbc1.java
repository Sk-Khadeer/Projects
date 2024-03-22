package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;



public class jdbc1 {

	public static void main(String[] args) throws  Exception {
		Class.forName("Oracle.jdbc.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","khadeer");
       Statement s = c.createStatement();
       ResultSet b=s.executeQuery("select * from emp");
       System.out.println();
       while(b.next()) {
    	   System.out.println(b.getInt(1)+"\t"+b.getString(2));
       }
       
       c.close();
      

	}

}
