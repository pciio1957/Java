package Java.c01_coding;

import java.util.Scanner;

// 백준 2753번
public class coding3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if(year%4==0) {
			if(year%100!=0 || year%400==0) {
				System.out.println("윤년");
			} else {
				System.out.println("아님");
			}
		} else {
			System.out.println("아님");
		}
	}
}


