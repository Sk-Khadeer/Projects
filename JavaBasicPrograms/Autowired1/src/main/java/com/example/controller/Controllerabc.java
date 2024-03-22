package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.User;

@RestController
public class Controllerabc {
@Autowired
private User u;
@RequestMapping("/abc")
public User a() {
	return u;
}
}
