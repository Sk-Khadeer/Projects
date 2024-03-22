package practice;
//@FunctionalInterface
interface ab{
	 int m(int a,int b);
	// int n(int a);
	default void m1() {
		System.out.println("default");
	}
	static void m2() {
		System.out.println("static");
	}
}

public class FunctionalInter {

	public static void main(String[] args) {
		//FunctionalInter f=new FunctionalInter();	
	ab a1=(a,b)->{return a+b;};
	//a a2=a->a;
	//System.out.println(a1.n(100));
	System.out.println(a1.m(1,2));
	a1.m1();
 	ab.m2();
//	FunctionalInter f=new FunctionalInter();
//	f.m1();
	}
}
