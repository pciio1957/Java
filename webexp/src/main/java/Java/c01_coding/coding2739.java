package Java.c01_coding;

import java.util.Scanner;

public class coding2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 구구단 n단을 입력하면 1~9 결과 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단 입력");
		int guguVal = sc.nextInt();
		
		if(9 >= guguVal && guguVal >= 1) {
			for(int idx = 1; idx <= 9; idx++) {
				System.out.println(guguVal + " * " + idx + " = " + guguVal*idx);
			}
		}
	}
}


