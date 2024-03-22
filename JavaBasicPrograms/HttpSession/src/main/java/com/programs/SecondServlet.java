package com.programs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SecondServlet() {
        super();
        
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try{  
	    	  
	        response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	          
	        HttpSession session=request.getSession(false);  
	        String a=(String)session.getAttribute("uname");  
	        String b=(String)session.getAttribute("upwd");  
	        out.print("Hello "+a+" is it correct password check it "+b);  
	  
	        out.close();  
	  
	                }catch(Exception e){System.out.println(e);}  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
