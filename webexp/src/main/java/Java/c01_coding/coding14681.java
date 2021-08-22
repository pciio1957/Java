package Java.c01_coding;

import java.util.Scanner;

public class coding14681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수 입력");
		int num01 = sc.nextInt();
		
		System.out.println("\n두번째 수 입력");
		int num02 = sc.nextInt();
		
		if(1000 >= num01 && num01 >= -1000 && 1000 >= num02 && num02 >= -1000) {
			if(num01 > 0 || num02 > 0) {
				if(num01 > 0 && num02 > 0) {
					System.out.println(1);
				} else if (num01 > 0) {
					System.out.println(4);
				} else if (num02 > 0) {
					System.out.println(2);
				} 
			} else {
				System.out.println(3);
			}
		}
	}
}
