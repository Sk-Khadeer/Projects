package com.exception.programs;

class C{
String s;
	C(String s){
		this.s=s;
	}
	
}
class B extends C{
	B(String s){
		super(s);
	}
}
public class CCE {

	public static void main(String[] args) {
	B b=new B("Hi");
	C c=new C("Hello");
	c=b;
	
	C c1=new C("Bye");
	B b1=(B)c1;
	
	
	}

}
