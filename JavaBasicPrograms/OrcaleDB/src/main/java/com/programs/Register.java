package com.programs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Register() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		Member member=new Member(uname,password,email,phone);
		RegisterDao rDao=new RegisterDao();
	
		String result = rDao.insert(member);
		response.getWriter().print(result);
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uname=request.getParameter("uname");
//		String password=request.getParameter("password");
//		String email=request.getParameter("email");
//		String phone=request.getParameter("phone");
//		Member member=new Member(uname,password,email,phone);
//		RegisterDao rDao=new RegisterDao();
//	
//		String result = rDao.insert(member);
//		response.getWriter().print(result);
doGet(request, response);
	}

}
