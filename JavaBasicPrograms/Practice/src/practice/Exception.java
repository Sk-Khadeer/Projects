package practice;

class Exception1 extends RuntimeException {
public Exception1(String m){
	super(m);
	System.out.println(m);
}
}
public class Exception{
	public static void main(String[] args) {
		try
		  {
			throw new Exception1("good for doing job");
		}catch(Exception1 e)
		  {
			System.out.println("still u have to prepare well");
		    System.out.println(e.getStackTrace());
		  }
		}
	
}
