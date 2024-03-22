package com.app1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body style='color:red'>");
	
		for(int i=0;i<6;i++)//HHH
        {
            for(int j=0;j<8;j++)
            {
            	
//                if((i==0 || i==1 || i==4 || i==5) && (j>0 && j<4))
//                {
//                	out.print("&nbsp;");
//               
//                }
//                else {
//                   out.print("*&nbsp;");
//                    
//                }
            	
            	if(j==0||j==7) {
            		   out.print("*");
            	}
            	else if((i==2||i==3)&&(j==2||j==4||j==6)) {
            		out.print("*");
            	}
            	else {
            		out.print("&nbsp;");
            	}
            }
            out.print("<br/>");  
            out.println();     
            }
		out.print("</body>");
		out.print("</html>");
		
	}

}
