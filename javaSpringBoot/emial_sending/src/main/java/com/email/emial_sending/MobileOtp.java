package com.email.emial_sending;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

public class MobileOtp {

	
	
	//SID----   AC2b5a01983ef3b36f8e568c8fe309f1a2	
	//TOKEN-----  00ab91bfc14225c133e64f895ff573c5
	//PHONE NUMBER ----   +15188568694
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String otp=generateOTP().toString();
		
		String msg=sendSMS(otp);
		System.out.println(msg);

	}
	public static Integer generateOTP() {
		Random random = new Random();
		Integer otp = 100000 + random.nextInt(900000);		
		return otp;
	}
	public static String sendSMS (String otpStr) {
		  try {
		   
		   String apiKey = "apiKey=" + "";
		   
		   String message = "&message=" + URLEncoder.encode("Your OTP is " + otpStr,
		     "UTF-8");
		   
		   String numbers = "&numbers=" + "";
		   
		   String apiURL = "https://api.textlocal.in/send/?" + apiKey + message + numbers;
		   
		   URL url = new URL(apiURL);
		   URLConnection connection = url.openConnection();
		   connection.setDoOutput(true);
		   
		   BufferedReader reader = new BufferedReader(new 
		     InputStreamReader(connection.getInputStream()));
		   	
		   String line = "";
		   StringBuilder sb = new StringBuilder();
		   
		   while ( (line = reader.readLine()) != null) {
		    sb.append(line).append("\n");
		   }
		   
		   System.out.println(sb.toString());
		   
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		return "success";
		 }
}
