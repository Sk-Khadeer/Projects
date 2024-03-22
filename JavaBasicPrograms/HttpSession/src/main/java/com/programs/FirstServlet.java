package com.programs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public FirstServlet() {
        super();
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{  
			   response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
		        String a=request.getParameter("userName"); 
		        String b=request.getParameter("userPassword");  
		        out.print("Welcome "+a+" your password is "+b);  
		      
		        HttpSession session=request.getSession();  
		        session.setAttribute("uname",a); 
		          
		        session.setAttribute("upwd",b); 
		  out.println("<html>");
		  out.println("<body>");
		        out.print("<a href='servlet2'>visit</a>"); 
		        out.println("</body>");
		        out.println("</html>");
		                  
		        out.close();  
		  
		                }catch(Exception e){System.out.println(e);}  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
