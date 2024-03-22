package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Collections {
public static void main(String[] args) {
	ArrayList a=new ArrayList();
	a.add("khadeer");
	a.add("aswanth");
	a.add("sreedar");
	a.add(2);a.add(null);
	a.remove(3);
	
	System.out.println("---------Arraylist-------");
	System.out.println(a);
	a.set(3, "nullish");
	System.out.println(a);
	System.out.println();
	LinkedList l=new LinkedList();
	l.add("salman");
	l.add("guddu");
	l.add("khadeer");
//	l.add(5);
//	l.add(null);
	//l.removeLast();
	//l.addFirst(a);
	System.out.println("------------Linkedlist---------");
	System.out.println(l);
	ListIterator ltr=l.listIterator();
	while(ltr.hasNext()) {
		String s=(String)ltr.next();
		if(s.equals("salman"))
			ltr.remove();
		else if(s.equals("guddu"))
			ltr.add("ashok");
		else if(s.equals("khadeer"))
			ltr.set("abdul khadeer");
		}
	System.out.println(l);
	System.out.println();
	
	
	Stack s=new Stack();
	s.push("a");
	s.push("b");
	s.push(null);
	s.push(1);
	System.out.println("---------stack--------- "); 
	System.out.println(s); 
	System.out.println(s.search("A"));
	System.out.println(s.pop());
	System.out.println(s);
	System.out.println(s.peek());System.out.println(s.empty());
	System.out.println();
	
	System.out.println("-------Hashset-------");
     HashSet h=new HashSet();
     h.add("b");  h.add("abc");  h.add("c");   h.add(null);
	System.out.println( h.add("b"));//duplicate values adding,it will show simpply false
	System.out.println(h);
	System.out.println();
	
	System.out.println("-------Treeset-------");
TreeSet t=new TreeSet();
t.add("b");  t.add("abc");  t.add("c"); 
//System.out.println(t.add(null));
System.out.println(t);
System.out.println();

System.out.println("-------MAP-------");
	HashMap m=new HashMap();
	m.put(1,"sreedar");m.put(2,"khadeer");m.put(3,"aswanth");
	System.out.println(m);
	
	Set s1=m.keySet();
	System.out.println(s1);
	
Collection c=m.values();
System.out.println(c);
Set s2=m.entrySet();
System.out.println(s2);
System.out.println();

System.out.println("-------IDENTITYHASHMAP-------");
HashMap id=new HashMap();
Integer i=new Integer(10);
Integer i1=new Integer(10);
	id.put(i,"khadeer");
	id.put(i1,"aswanth");
	System.out.println(id);
	System.out.println();
	
	System.out.println("-------HashTable-------");
	Hashtable ht=new Hashtable();
	ht.put(5, "a");ht.put(2, "b");ht.put(6, "d");ht.put(9, "j");
	System.out.println(ht);
	
	
	
	
	
	
}
}
