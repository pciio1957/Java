package Java.a05_condition;

import java.util.Scanner;

public class A06_Do_While {

	
	/*
	 
	#do While 
	1. 초기에 출력/처리 내용을 먼저 진행하고 그 내용을 계속 반복적으로 수행할 때 사용된다.
		어떠한 경우라도 한번은 수행처리
		
	2. 형식
		do {
			// 최소 한번은 수행할 구문
		} while(반복조건);
	 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("반복할 횟수 입력 : ");
		int end = sc.nextInt();
		int cnt = 1;
		int tot = 0;
		
		// 최소한 한번은 실행하므로 0을 입력하더라도 1이 나옴 
		do {
			tot += cnt;
			// cnt는 순서대로 증가, tot는 cnt누적
			System.out.println((cnt++) + "의 합산값 : " + tot );
		}while(cnt<=end);
		
		System.out.println("반복문 종료!");
		
		
		// 응용) 짜장면(4000원) 판매 프로그램, 수량을 입력받아 총 비용 출력하기 
		// 		계속 주문할 것인지 주문의사를 묻고 누적하기. 
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\n # 짜장면 전문점 # ");
		int food = 4000; // 짜장면가격, 없어도됨(바로사용)
		int cnt2 = 1; // 숫자세기
		int fpay = 0; // 총 비용 구하기, 없어도됨(바로사용)
		int tot2 = 0; // 누적 비용 구하기
		String fCheck = ""; // 빈칸없애기ㅎ
		
		do {
			System.out.print("수량 입력 : ");
			int fcount = sc2.nextInt();
			// int fcount = Integer.parseInt(sc2.nextLine()); 도 된댔음
			String nullnum = sc2.nextLine(); // int입력받고 빈칸 없애기
			fpay = food * fcount; // 입력한 수량을 가지고 총 비용 구하기
			tot2 += fpay; // 총 비용을 더해서 누적 비용 구하기
			cnt2++; // 순서를 위한 cnt증가
			System.out.println(cnt2 + "번째 방문이시네요 총 비용은 " + fpay + "입니다" );
			System.out.println("누적 비용은 " + tot2 +"입니다");
			System.out.print("또 방문하시겠습니까? (Y/N) : ");
			fCheck = sc2.nextLine(); // 또 방문하는지 구분하는 문자 받기
		// 입력값이 "Y"일때동안 계속 프로그램은 반복처리를 한다.
		}while(fCheck.equals("Y"));
		
		System.out.println("\n주문 종료!");
		System.out.println("총 비용 : " + tot2);
	}

}
