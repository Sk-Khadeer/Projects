package com.exception.programs;

public class StackOverFlowError {

	public static void main(String[] args) {
		one();
	}
	public static void one() {
		two();
	}
	public static void two() {
		one();
	}

}
