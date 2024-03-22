package com.exception.programs;

class A extends Thread{
	public void run() {
		System.out.println("hello");
	}
}

public class IllegalStateException {

	public static void main(String[] args) {
		A a=new A();
		a.start();
		a.start();
	}

}
