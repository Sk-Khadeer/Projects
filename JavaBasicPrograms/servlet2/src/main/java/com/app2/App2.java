package com.app2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class App2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
static{System.out.println("static block");}
public App2() {System.out.println("constructor--->servlet instantaition");}
     @Override
    public void init() throws ServletException {
    	System.out.println("init()----->servlet initalization");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()");
	}
	@Override
	public void destroy() {
	System.out.println("destroy()");
	}

}
