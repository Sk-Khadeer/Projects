package public static void main(String[] args) throws ParseException {
//	Calendar c=Calendar.getInstance();
//	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//	String s="12-07-2022";String s1="10-09-2022";
//	Date d=sdf.parse(s);
//	Date d1=sdf.parse(s1);
//   // c.setTime(d);
//	//c.add(Calendar.MONTH, 3);
//	//String e=sdf.format(c.getTime());
//	//System.out.println(e);
////	long l=d1.getTime()-d.getTime();
////	System.out.println(l);
////	 long days_difference =TimeUnit.MILLISECONDS.toDays(l) % 365; 
////	// long days_difference = (l / (1000*60*60*24)) % 365;   
////	 System.out.println(days_difference);
//System.out.println(d.getDate()+" "+d.getMonth());
//	 long l=d1.getTime()-d.getTime();
//		
//		 long days_difference =TimeUnit.MILLISECONDS.toDays(l) % 365; 
//
//		 System.out.println(days_difference);public static void main(String[] args) throws ParseException {
//	Calendar c=Calendar.getInstance();
//	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//	String s="12-07-2022";String s1="10-09-2022";
//	Date d=sdf.parse(s);
//	Date d1=sdf.parse(s1);
//   // c.setTime(d);
//	//c.add(Calendar.MONTH, 3);
//	//String e=sdf.format(c.getTime());
//	//System.out.println(e);
////	long l=d1.getTime()-d.getTime();
////	System.out.println(l);
////	 long days_difference =TimeUnit.MILLISECONDS.toDays(l) % 365; 
////	// long days_difference = (l / (1000*60*60*24)) % 365;   
////	 System.out.println(days_difference);
//System.out.println(d.getDate()+" "+d.getMonth());
//	 long l=d1.getTime()-d.getTime();
//		
//		 long days_difference =TimeUnit.MILLISECONDS.toDays(l) % 365; 
//
//		 System.out.println(days_difference);;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Date1 {
public static void main(String[] args) throws ParseException {
//	Calendar c=Calendar.getInstance();
//	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//	String s="12-07-2022";String s1="10-09-2022";
//	Date d=sdf.parse(s);
//	Date d1=sdf.parse(s1);
//   // c.setTime(d);
//	//c.add(Calendar.MONTH, 3);
//	//String e=sdf.format(c.getTime());
//	//System.out.println(e);
////	long l=d1.getTime()-d.getTime();
////	System.out.println(l);
////	 long days_difference =TimeUnit.MILLISECONDS.toDays(l) % 365; 
////	// long days_difference = (l / (1000*60*60*24)) % 365;   
////	 System.out.println(days_difference);
//System.out.println(d.getDate()+" "+d.getMonth());
//	 long l=d1.getTime()-d.getTime();
//		
//		 long days_difference =TimeUnit.MILLISECONDS.toDays(l) % 365; 
//
//		 System.out.println(days_difference);
//		 
//		 
//		 String startDate = "2022-07-01";
//		 String promotionDate = "2022-09-01";
//
//		 LocalDate sdate = LocalDate.parse(startDate);
//		 LocalDate pdate = LocalDate.parse(promotionDate);
//
//		 LocalDate ssdate = LocalDate.of(sdate.getYear(), sdate.getMonth(), sdate.getDayOfMonth());
//		 LocalDate ppdate = LocalDate.of(pdate.getYear(), pdate.getMonth(), pdate.getDayOfMonth());
//
//		 Period period = Period.between(ssdate, ppdate);
//		 System.out.println("Difference: " + period.getYears() + " years " 
//		                                   + period.getMonths() + " months "
//		                                   + period.getDays() + " days ");
//	
	
	String s1 = "04082022";
	if (s1.contains("/")) {
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = (Date)formatter.parse(s1);
	System.out.println(date);  
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	String formatedDate = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +         cal.get(Calendar.YEAR);
	System.out.println("formatedDate1 : " + formatedDate); 
	Date f=new SimpleDateFormat("dd-MM-yyyy").parse(formatedDate);
	System.out.println(f);
	}

	else if (s1.contains("-")) {
	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date date = (Date)formatter.parse(s1);
	System.out.println(date);  
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	String formatedDate = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +         cal.get(Calendar.YEAR);
	System.out.println("formatedDate2 : " + formatedDate);  
	Date f=new SimpleDateFormat("dd-MM-yyyy").parse(formatedDate);
	System.out.println(f);
	}

	else if (!s1.contains("-") && !s1.contains("/")) {

	DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	Date date = (Date)formatter.parse(s1);
	System.out.println(date);  
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	String formatedDate = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +cal.get(Calendar.YEAR);
	System.out.println("formatedDate3 : " + formatedDate);  
yy	Date f=new SimpleDateFormat("dd-MM-yyyy").parse(formatedDate);
	System.out.println(f);
	TimeZone t=new yyyyy	}
	

//	Date d5 = new SimpleDateFormat("dd/MM/yyyy").parse(s1);
//	Format formatter1 = new SimpleDateFormat("yyyyMMdd");
//	String g = formatter1.format(d5);
//	System.out.println("1-----" + g);

//	Date d5 = new SimpleDateFormat("dd-MM-yyyy").parse(s1);
//	Format formatter1 = new SimpleDateFormat("yyyyMMdd");
//	String g = formatter1.format(d5);
//	System.out.println("2-----" + g);
	
//	Date d5 = new SimpleDateFormat("ddMMyyyy").parse(s1);
//	Format formatter1 = new SimpleDateFormat("yyyyMMdd");
//	System.out.println(d5);
//  String g = formatter1.format(d5);
//	System.out.println("3-----" + g);
	   

}
}
