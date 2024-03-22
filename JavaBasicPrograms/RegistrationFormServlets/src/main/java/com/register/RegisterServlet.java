 package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1705230675977591783L;
@Override
protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		try {
			Connection con = DBConnection.database();
			PreparedStatement st = con.prepareStatement("insert into register values(?, ?,?,?)");
			st.setString(1, request.getParameter("uname"));
			st.setString(2, request.getParameter("upwd"));
			st.setString(3, request.getParameter("uemail"));
			st.setString(4, request.getParameter("umn"));
			
			st.executeUpdate();
			st.close();
			con.close();
            PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted"+ "</b></body></html>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
}}
