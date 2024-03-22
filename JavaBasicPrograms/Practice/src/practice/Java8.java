package practice;

import java.util.ArrayList;
import java.util.function.Consumer;
//Lambda expression
//public class Java8 {
//	public static void main(String[] args) {
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//	    numbers.add(5);
//	    numbers.add(9);
//	    numbers.add(8);
//	    numbers.add(1);
//	    numbers.forEach( n -> {
//	    	System.out.println(n); 
//	    	});
//	}
//}
//Lambda expression storing in a variable
public class Java8 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    Consumer<Integer> method= (n) -> {
	    	System.out.println(n); 
	    	};
	    	numbers.forEach(method);
	    	
	}
}