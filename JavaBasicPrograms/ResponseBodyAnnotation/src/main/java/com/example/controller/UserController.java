package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modal.User;

@RestController
public class UserController {
@PostMapping("/user")
public String printUser(@RequestBody User u) {
	System.out.println(" printing user object :"+u);
	return "Sucess";
}


}
