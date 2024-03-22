package com.exception.programs;

public class Throws {

	public Throws() throws InterruptedException{
		System.out.println("THIS IS CONSTRUCTOR");
	}

	public static void main(String[] args) throws InterruptedException{
         three();

	}
	public static void one() throws InterruptedException {
		System.out.println("Hello");
		two();
	}
	public static void two() throws InterruptedException {
		System.out.println("hi");
		
	}
	public static void three() throws InterruptedException {
		System.out.println("Sleeping for 5 sec after u will get output");
		Thread.sleep(5000);
		one();
	}


}
