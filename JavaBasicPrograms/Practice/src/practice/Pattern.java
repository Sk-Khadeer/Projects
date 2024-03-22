package practice;

public class Pattern {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			
			for(int k=5;k>i;k--) {
				System.out.print(" ");
			}
			int no=i;
			for(int j=1;j<=i;j++) {
				System.out.print(" "+no);
				no=no+5-j;
			}
			System.out.println();
		}
	}

	
}
