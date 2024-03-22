package com.programs;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletConfig extends HttpServlet{
	
protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
	PrintWriter out= res.getWriter();
	out.println("Hi ");
	
	ServletContext cg=getServletContext();
	String s=cg.getInitParameter("name");
	out.print(s);
//	
//	ServletConfig cg=(ServletConfig) getServletConfig();
//	String s=cg.getInitParameter("name");
//	out.print(s);
}
}
