package Java.a05_condition;

import java.util.Scanner;

public class A04_for {

	/*
	
	#for문
	1. 반복 횟수를 알고 있을 때, 주로 사용되는 구문
	2. 기본형식
		for(;;) {}
		 -> 안의 조건이 없으면 while()이랑 비슷
		 -> 무한 loop의 가능성... 
		
		for (1초기값; 2조건식; 4증감식) {
			3반복수행구문
		}
		1-2-3-4 한번 돌고 2-3-4 반복
		
		1. 초기값: 한번만 수행된다.
		2. 조건식: boolean 형태로 반복수행할 구문을 처리할 조건을 나타낸다.
		3. 반복수행 구문: 조건식이 true일 때 처리되는 구문
		4. 증감식: 증가(++,+=), 감소(--, -=) 연산을 통해서 증감 처리
		증감식 이후에 조건식에 해당하는 여부를 check해서 반복수행을 처리한다. 
		
		
		#프로그래밍 능력의 상승 -> 문제해결능력
		1. 반복문, 배열, 조건문
		2. 다양한 데이터의 처리 -> 알고리즘
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int sum = 0;
		for(int cnt = 1; cnt <= 100; cnt++) {
			sum = sum + cnt;
			System.out.println(cnt + "까지 합 : " + sum
					);
		}
		
		
		
		// 응용1) 단가 2000, 구매수향 20까지 총계 출력하기
		// 		2000 1 2000
		// 		2000 2 4000
		// 응용2) 물건명과 단가, 구매 갯수를 입력받아 출력하기(4조)
		
		// 응용1
		int pay = 2000; 
		
		System.out.println("\n단가\t구매수량\t총계");
		for(int i=1;i<=20;i++) {
			System.out.print(pay + "\t");
			System.out.print(i + "\t");
			System.out.println(pay*i);
		}
		
		// 응용2
		Scanner sc = new Scanner(System.in);
		System.out.print("\n물건명을 입력하세요 -> ");
		String tname = sc.nextLine();
		System.out.print("단가를 입력하세요 -> ");
		int tpay = sc.nextInt();
		System.out.print("구매갯수를 입력하세요 -> ");
		int tcnt = sc.nextInt();
		
		System.out.println("\n물건명\t단가\t구매수량\t총계");
		for(int i=1; i<=tcnt; i++) {
			System.out.print(tname + "\t");
			System.out.print(tpay + "\t");
			System.out.print(i + "\t");
			System.out.println(tpay*i);
		}
		
		
		// 실습) 1~10까지 아래와 같은 형식으로 출력하기
		int tot = 0;
		for(int cnt = 1; cnt <= 10; cnt++ ) {
			System.out.print(cnt);
			tot += cnt;
			if(cnt==10) {
				System.out.println(" = " + tot);
			} else {
				System.out.println(" = ");
			}
		}
		
		// 실습) 1~100까지 출력시 5단위로 출력하기
		for(int cnt=1; cnt<=100; cnt++) {
			System.out.print(cnt);
			if(cnt%5==0) {
				System.out.println();
			} else {
				System.out.print("\t");
			}
		}
		
		
		
	}
	
	

}
