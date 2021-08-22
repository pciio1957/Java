package Java.c01_coding;

import java.util.Scanner;

public class coding10950 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("더하기연산할 횟수를 입력하세요");
		int plusCnt = sc.nextInt();
		int num01[] = new int[plusCnt], num02[] = new int[plusCnt]; 
		
		// 입력받기
		for(int x = 0; x < plusCnt; x++) {
			System.out.println("숫자1 입력");
			int temp1 = sc.nextInt();

			System.out.println("숫자2 입력");
			int temp2 = sc.nextInt();
			
			if(temp1 > 0 && 10 > temp2) {
				num01[x] = temp1;
				num02[x] = temp2;
			} else {
				System.out.println("입력범위를 벗어났습니당");
			}
		}
		
		// 출력하기
		for(int x = 0; x < plusCnt; x++) {
			System.out.println(x+1 + "번 결과 : " + (num01[x] + num02[x]));
		}
	}
}






