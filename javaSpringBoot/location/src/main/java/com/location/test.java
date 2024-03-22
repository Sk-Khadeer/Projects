package com.location;

public class test {
	public static void main(String[] args) {
		String sentence = "AB";
		String reversed = reverse(sentence);
		System.out.println("The reversed sentence is: " + reversed);
	}

	public static String reverse(String sentence) {
		if (sentence.isEmpty())
			return sentence;
		System.out.println(sentence.charAt(0));
		return reverse(sentence.substring(1)) + sentence.charAt(0);
	}
}
