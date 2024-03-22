package com.sampletest;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
public static void main(String[] args) {
	System.out.print("enter the text:");
	Scanner s=new Scanner(System.in);
	System.out.println(Pattern.matches("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|(250))",s.nextLine()));
	//System.out.println(Pattern.matches("^[5-9][0-9]$|^(100)$",s.nextLine()));
}
}
