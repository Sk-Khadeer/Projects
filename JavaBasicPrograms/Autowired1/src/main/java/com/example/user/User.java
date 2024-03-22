package com.example.user;

import org.springframework.stereotype.Controller;

@Controller
public class User {
private String name="khadeer";

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "User [name=" + name + "]";
}
}
