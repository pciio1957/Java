package Java.c01_coding;

// 백준 1330번
public class coding1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "2 2";
		
		String a[] = str.split(" ");
		int anum = Integer.parseInt(a[0]);
		int bnum = Integer.parseInt(a[1]);
		
		if(anum > bnum) {
			System.out.println(">");
		} else if(anum < bnum) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
	}
}


