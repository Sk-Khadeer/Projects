package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller1 {
	  @RequestMapping("/login")  
	    public String display(@RequestParam("name") String name,@RequestParam("pass") String pass,Model m)  
	    {  
	        if(pass.equals("khadeer"))  
	        {  
	            String a="Hi "+ name +", what is Going on"; 
	            m.addAttribute("b", a);  
	            return "a.jsp";  
	        }  
	        else  
	        {  
	            String a="Sorry "+ name+". You entered an incorrect password";  
	            m.addAttribute("b", a);  
	            return "b.jsp";  
	        }     
	    }  
}
