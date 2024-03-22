package com.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		 Scanner sc=new Scanner(System.in);
//         
//		System.out.println("================================");
//		 for(int i=0;i<3;i++){
//             String s1=sc.next();
//             Integer x=sc.nextInt();
//             while(s1.length()!=15 ) 
//             {
//            	 s1=s1.concat(" "); 
//             }
//             int number_length=x.toString().length();
//             while(number_length!=3 ) 
//             {
//            	 s1=s1.concat("0"); 
//            	 number_length++;
//             }
//             System.out.println(s1+x);
//          }

//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		for (int i = 0; i < t; i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int n = in.nextInt();
//			List<Integer> l=new ArrayList<Integer>();
//			
//			int c = 1,m=2;
//			int first_value=a+b;
//			l.removeAll(l);
//			l.add(first_value);
//		
//			while (c <= n) {
//				first_value=first_value+m*b;
//				l.add(first_value);
//				m=m*2;
//				c++;
//			}
//			l.forEach((k)->System.out.println(k));
//
//		}

		// Scanner sc = new Scanner(System.in);
		// int t = sc.nextInt();
//
//		for (long i = 0; i < t; i++) {
//
//			try {
//				long x = sc.nextLong();
//				
//
//				System.out.println(x + " can be fitted in:");
//				if (x >= -128 && x <= 127)
//					System.out.println("* byte\n* short\n* int");
//				else if ((x >= -128 && x <= 127) || (x >= -32768 && x <= 32767))
//					System.out.println("* short\n* int\n* long");
//				else if ((x >= -128 && x <= 127) || (x >= -32768 && x <= 32767)
//						|| (x >= -2147483648 && x <= 2147483647))
//					System.out.println("* int\n* long");
//				else if ((x >= -128 && x <= 127) || (x >= -32768 && x <= 32767) || (x >= -2147483648 && x <= 2147483647)
//						|| (x >= -9223372036854775808l && x <= 9223372036854775807l))
//					System.out.println("* long");
//				else {
//					System.out.println(x + " can't be fitted anywhere.");
//				}
//
//			} catch (Exception e) {
//				System.out.println(sc.next() + " can't be fitted anywhere.");
//			}
//
//		}

//		Scanner sc = new Scanner(System.in);

//		String[] string = new String[sc.nextInt()];
//		sc.nextLine();
//		for (int i = 0; i < string.length; i++) {
//			string[i] = sc.nextLine();
//		}
//
//		int count = 1;
//		for (String str : string) {
//			System.out.println(count + " " + str);
//			count++;
//		}
//		String s;
//		int count = 1;
//		while(sc.hasNext()) {
//			 s=sc.nextLine();
//			 System.out.println(count + " " + s);
//				count++;
//		}
//		int h = sc.nextInt();
//		int b = sc.nextInt();
//		 if(flag){
//	            int area=B*H;
//	            System.out.print(area);
//	        }
//		 System.out.println(day(2023,07,25));

//		 Scanner scanner = new Scanner(System.in);
//	        double payment = scanner.nextDouble();
//	        scanner.close();
//
//	        Locale usLocale = new Locale("en", "US");
//	        NumberFormat us = NumberFormat.getCurrencyInstance(usLocale);
//
//	        Locale indiaLocale = new Locale("en", "IN");
//	        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
//	        decimalFormatSymbols.setCurrencySymbol("Rs.");
//	        decimalFormatSymbols.setGroupingSeparator(',');
//	        decimalFormatSymbols.setMonetaryDecimalSeparator('.');
////	        ((DecimalFormat) us).setDecimalFormatSymbols(decimalFormatSymbols);
//	        NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
//	        ((DecimalFormat) india).setDecimalFormatSymbols(decimalFormatSymbols);
//
//	        Locale chinaLocale = new Locale("zh", "CN");
//	        NumberFormat china = NumberFormat.getCurrencyInstance(chinaLocale);
//
//	        Locale franceLocale = new Locale("fr", "FR");
//	        NumberFormat france = NumberFormat.getCurrencyInstance(franceLocale);
//
//	        System.out.println("US: " + us.format(payment));
//	        System.out.println("India: " + india.format(payment));
//	        System.out.println("China: " + china.format(payment));
//	        System.out.println("France: " + france.format(payment));

//		Scanner sc = new Scanner(System.in);
//		String A = sc.next();
//		String B = sc.next();
//		System.out.println(A.length() + B.length());
		
		
//		int returnvalue = compare2Strings(A, B);
//		if (returnvalue > 0) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
//	        String s1 = A.substring(0, 1).toUpperCase()+A.substring(1)+" "+ B.substring(0, 1).toUpperCase()+B.substring(1);
//	        System.out.println(s1);       

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		int B = sc.nextInt();
		String smallest = "";
        String largest = "";

        // Get all possible substrings of length 'k'
        for (int i = 0; i <= A.length() - B; i++) {
            String substr = A.substring(i, i + B);
            
            if (substr.compareTo(smallest) < 0 || smallest.isEmpty()) {
                smallest = substr;
            }

            if (substr.compareTo(largest) > 0 || largest.isEmpty()) {
                largest = substr;
            }
          
        }
        System.out.println(smallest+"\n"+largest);
//		int C = sc.nextInt();
//		System.out.println(A.substring(B,C));
		

	}

//	public static int compare2Strings(String s1, String s2) {
//		int len1 = s1.length();
//		int len2 = s2.length();
//
//		// Calculating minimum of the lengths of two strings
//		int minLen = Math.min(len1, len2);
//
//		// loop for traversing strings
//		for (int i = 0; i < minLen; i++) {
//			// Calculating ASCII values
//			int asciiOfs1 = (int) s1.charAt(i);
//			int asciiOfs2 = (int) s2.charAt(i);
//
//			// condition for finding unmatched character
//			if (asciiOfs1 != asciiOfs2) {
//				// difference of ASCII values
//				return asciiOfs1 - asciiOfs2;
//			}
//		}
//
//		// when one string is subset of other
//		if (len1 != len2) {
//			return len1 - len2;
//		}
//		// when both the strings are same
//		return 0;
//	}

//	public static String day(int year,int month,int day) {
//		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar);
//        calendar.set(year, month - 1, day);
//       System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(dayOfWeek);
//        String[] days = new String[]{"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
//
//        return days[dayOfWeek - 1];
//	}

//    static Scanner sc = new Scanner(System.in);
//    static int b;
//    static int h;
//    static boolean flag;
//
//    static {
//        b = sc.nextInt();
//        h = sc.nextInt();
//        if(b > 0 && h > 0) {
//            flag = true;
//        } else {
//            System.out.println("java.lang.Exception: Breadth and height must be positive");
//        }
//    }
}
