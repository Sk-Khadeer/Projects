package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Students {
private int sid;
private String sname;
private String scourse;
@Autowired
private Technologies techdetail;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public Technologies getTechdetail() {
	return techdetail;
}
public void setTechdetail(Technologies techdetail) {
	this.techdetail = techdetail;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getScourse() {
	return scourse;
}
public void setScourse(String scourse) {
	this.scourse = scourse;
}
public void display() {
	System.out.println("object returned sucessfully");
	techdetail.tech();
}
}
