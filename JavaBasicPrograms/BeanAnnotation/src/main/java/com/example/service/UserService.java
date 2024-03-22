package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.User;

public class UserService {
private static List<User> l=new ArrayList<User>();
static {
	User u=new User("khadeer");
	l.add(u);
	u=new User("sreedar");
	l.add(u);
	u=new User("aswanth");
	l.add(u);
}
public  List<User> getList(){
	return l;
}
}
