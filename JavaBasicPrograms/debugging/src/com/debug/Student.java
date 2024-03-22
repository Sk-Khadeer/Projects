package com.debug;

public class Student {
	int marks;
	String name;

	Student(){
		marks=0;
		name="defaultName";
	}
	public void update(int marks, String name) {
		this.marks=marks;
		this.name=name;
		
	}
	public String m_marks(Student s) {
		this.marks=s.marks;
		this.name=s.name;
		return marks+" "+name;
	}

}
