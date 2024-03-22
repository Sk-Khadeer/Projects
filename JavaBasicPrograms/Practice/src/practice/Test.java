package practice;

public class Test {
	int a;
	static int b;
int e=20;
	public Test() {
		a=10;
		b=10;
//	try {
//		System.out.println(a/0);
//	}catch(ArithmeticException e){
//		//e.printStackTrace();
//		//System.out.println(e);
//		System.out.println(e.toString());
//		System.out.println(e.getMessage());
//	}
//		System.out.println();
	}

	public void m() {
		e=30;
	}
	public static void main(String[] args) {
	Test t=new Test();
	Test f=t;
	t.m();
	System.out.println(t.e);
	System.out.println(f.e);
	}

}
