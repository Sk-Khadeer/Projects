package practice;
interface A{
	void m();
	
}
interface B{
	void m();
	
}
public class Interfaces implements A,B{

	@Override
	public void m() {
		System.out.println("hello");
	}
	public static void main(String[] args) {
		Interfaces i=new Interfaces();
		i.m();
	}

}
