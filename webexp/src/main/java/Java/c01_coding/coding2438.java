package Java.c01_coding;

import java.util.Scanner;

public class coding2438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		if(cnt >= 1 && 100 >= cnt) {
			for(int x=1; x<=cnt; x++) {
				for(int y=1; y<=x; y++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		}
	}
}





