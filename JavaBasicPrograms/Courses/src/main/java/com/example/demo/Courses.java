package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Courses {
	@RequestMapping("courses")
public String courses() {
	
	return "course";
}
}
