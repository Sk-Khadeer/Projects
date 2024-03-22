package com.example.CONTROLLER;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AController {
	
	@GetMapping("/user")
public String user() {
	return "Sucess";
}
	
	@GetMapping("/link")
	public String link() {
		return "<a href=https://www.upgrad.com/blog/spring-boot-annotation >Spring boot annotations</a>";
	}
}


