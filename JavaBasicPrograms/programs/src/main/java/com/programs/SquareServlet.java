package com.programs;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SquareServlet  extends HttpServlet{
	
	private static final long serialVersionUID = -791666970940530587L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		out.println("this is SquareServlet class");
	}
}
