package Java.c01_coding;

import java.util.Scanner;

public class coding2475 {
	
	
	/* 
	 
	  	컴퓨터를 제조하는 회사인 KOI 전자에서는 제조하는 컴퓨터마다 6자리의 고유번호를 매긴다. 
	  	고유번호의 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며 6번째 자리에는 검증수가 들어간다. 
	  	검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
	
		예를 들어 고유번호의 처음 5자리의 숫자들이 04256이면, 
		각 숫자를 제곱한 수들의 합 0+16+4+25+36 = 81 을 10으로 나눈 나머지인 1이 검증수이다.
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] intVal= new int[6];
		int sum = 0;
		int result = 0;
		
		for(int idx=0; idx<5; idx++) {
			System.out.println("번호 연속 입력");
			intVal[idx] = sc.nextInt();
			sum += Math.pow(intVal[idx], 2);
		}
		
		result = sum % 10;
		System.out.println("입력 수 : " + intVal[0] + " " + intVal[1] + " " + intVal[2] + " " +  intVal[3] + " " +  intVal[4]);
		System.out.println("검증수 : " + result);
	}
}



