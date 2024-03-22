package practice;

public class Increment {
int b,d;
static int c=20;
Increment(int b,int d){
	this.b=b;
	this.d=d;
}
public String toString() {
	return b+" "+d;
}

	public static void main(String[] args) {
		Increment a=new Increment(10,20);
		System.out.println(a.toString());
		


	}
	

}
