package Java.c01_coding;

import java.util.Scanner;

public class coding2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		for(int x=1; x<=cnt; x++) {
			for(int y=cnt; y>=1; y--) {
				if(x>=y) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}


