package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Technologies {
private String Tname;

public String getTname() {
	return Tname;
}

public void setTname(String tname) {
	Tname = tname;
}
public void tech() {
	System.out.println("Completed");
}
}
