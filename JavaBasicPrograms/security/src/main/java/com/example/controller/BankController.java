package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class BankController {

	@GetMapping("/home")
	public String show() {
		return "home.jsp";
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "show_balance.jsp";
	}
	
	@GetMapping("/offers")
	public String offer() {
		return "offers.jsp";
	}
	
	@GetMapping("/loanApprove")
	public String loanApp() {
		return "loan.jsp";
	}
	

	@GetMapping("/access")
	public String access() {
		return "access.jsp";
	}
}
