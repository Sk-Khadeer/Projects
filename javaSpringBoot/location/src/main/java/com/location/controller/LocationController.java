package com.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.entity.User;
import com.location.service.UserService;

@Controller
public class LocationController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String index() {
		return "demo";
	}

//	@PostMapping("/register1")
//	public String submitForm(@ModelAttribute("user") User ur, Model model) {
//		service.saveUser(ur);
//		return "register_success";
//	}
}
