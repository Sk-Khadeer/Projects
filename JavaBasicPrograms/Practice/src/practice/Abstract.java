package practice;
abstract class a1{
	public abstract void m();
	public abstract void n();
	public abstract void o();
}
abstract class b1 extends a1{
	public void m() {
		System.out.println("m");
	}
	public void n() {
		System.out.println("n");
	}
}
public abstract class Abstract extends b1 {

	public static void main(String[] args) {

	}


}
