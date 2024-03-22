package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi {
public static void main(String[] args) {
	 List<Integer> number = Arrays.asList(2,3,4,5);
	  
	    // demonstration of map method
	    List<Integer> square = number.stream().map(x -> x*x).
	                           collect(Collectors.toList());
	    System.out.println(square);
	  
	    // create a list of String
	    List<String> names =
	                Arrays.asList("sridhar","aswanth","khadeer");
	  
	    // demonstration of filter method
	    List<String> result = names.stream().filter(s->s.startsWith("s")).
	                          collect(Collectors.toList());
	    System.out.println(result);
	  
	    // demonstration of sorted method
	    List<String> show =
	            names.stream().sorted().collect(Collectors.toList());
	    System.out.println(show);
	  
	    // create a list of integers
	    List<Integer> numbers = Arrays.asList(2,3,4,5,2);
	  
	    // collect method returns a set
	    Set<Integer> squareSet =
	         numbers.stream().map(x->x*x).collect(Collectors.toSet());
	    System.out.println(squareSet);
//	    System.out.println( numbers.stream().map(x -> x*x).
//	                           collect(Collectors.toList()));
//	  
	    // demonstration of forEach method
	  //  number.stream().map(x->x*x).forEach(y->System.out.println(y));
	  
	    // demonstration of reduce method
	    int even =
	       number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	  
	    System.out.println(even);
	    
	    
	    int product = IntStream.range(1, 7)
                .reduce((num1, num2) -> num1 * num2)
                .orElse(-1);

   // Displaying the product
   System.out.println("The product is : " + product);
	    
}
}
