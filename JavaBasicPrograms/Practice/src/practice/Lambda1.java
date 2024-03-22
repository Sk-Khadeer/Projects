package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class Lambda1 {
//	public static void main(String[] args) {
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//	    numbers.add(5);
//	    numbers.add(91);
//	    numbers.add(82);
//	    numbers.add(1);
//	    numbers.add(256);
//	    numbers.add(55);
//	    //using lambda expression to print all elements of arraylist
//	    numbers.forEach( n -> {
//	    	System.out.println(n); 
//	    	});
//	    //using lambda expression to print all even elements of arraylist
//	    System.out.println("--Even numbers--");
//	    numbers.forEach( n -> {
//	    	if(n%2==0)
//	    	System.out.println(n); 
//	    	});
//	    
//	}
//
//}
//Converting arraylist to hashmap
 class ListItems{
	 
    // key will act as an id of the value
    private Integer key;
 
    // value will be the value of the above key
    private String value;
 
    // create constructor for reference
    public ListItems(Integer id, String name)
    {
 
        // assigning the value of key and value
        this.key = id;
        this.value = name;
    }
 
    // return private variable key
    public Integer getkey() { return key; }
 
    // return private variable name
    public String getvalue() { return value; }
}
public class Lambda1 {
    public static void main(String[] args)
    {
        // Write your code here
 
        // Creating a List of type ListItems using ArrayList
        List<ListItems> list = new ArrayList<ListItems>();
 
        // add the member of list
        list.add(new ListItems(1, "java"));
        list.add(new ListItems(2, "c"));
        
        list.add(new ListItems(3, "python"));
        list.add(new ListItems(4, "js"));
        list.add(new ListItems(5, "reactjs"));
 
        // Map which will store the list items
        Map<Integer, String> map = new HashMap<>();
 
        // for (ListItems n : list) { map.put(n.getkey(),
        // n.getvalue()); }
        // the below lambda  performs the same task as the
        // above given for loop will do
        // put the list items in the Map
        list.forEach(
            (n) -> { map.put(n.getkey(), n.getvalue()); });
 
        // Printing the given map
        System.out.println("Map : " + map);
    }
}


