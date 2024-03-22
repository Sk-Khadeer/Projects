package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
@RequestMapping("/k")
public String m() {
return "index.jsp";
}
}
