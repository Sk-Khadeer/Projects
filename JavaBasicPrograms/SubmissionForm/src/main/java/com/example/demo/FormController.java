package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FormController {
@GetMapping("details1")
public String details() {
	return "details";
}
@PostMapping("/details")
public String viewDetails(@RequestParam("name") String name,
		@RequestParam("mail") String mail,
        @RequestParam("mn") String mn,
        @RequestParam("id") String id,
        @RequestParam("add") String add,ModelMap m) {
	m.put("name",name);
	m.put("mail",mail);
	m.put("mn",mn);
	m.put("id",id);
	m.put("add",add);
	return "ViewDetails";
	
}
}