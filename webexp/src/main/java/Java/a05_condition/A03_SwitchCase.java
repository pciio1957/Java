package Java.a05_condition;

import java.util.Scanner;

public class A03_SwitchCase {
	
	/*
	#Switch case문
	1. 특정한 변수를 받아서 해당 변수의 case를 지정하며
	 	조건문을 처리하는 형식을 말한다.
	 	
	2. 기본형식
		switch(변수) {
			case 변수유형1: 
				처리할 내용 
				break;
			case 변수유형2:
				처리할 내용
				break;
			..
			
			default : 
				위에 정의한 변수유형이 아닐때 처리되는 내용
				
	3. switch case문에서 break
		1) 해당 case에 process를 중단처리하며, switch문의 {} 블럭을 벗어나게한다
		2) break : case문에 없으면 바로 밑 case로 처리가 된다.
		3) 누적된 효과가 필요할때는 적절하게 break문을 사용하면 된다
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int buttonNum = 2;
		switch(buttonNum) {
			case 1:
				System.out.println("A구역의 불이 켜졌습니다");
				break;
			case 2:
				System.out.println("B구역의 불이 켜졌습니다");
				break;
			default:
				System.out.println("해당 버튼은 사용하는 버튼이 아닙니다");
		}
		System.out.println("입장!");
		
		
		
		// 응용) 문제의 정답을 입력하세요(1~4) 
		// 3번인 경우만 정답, 그 이외에는 오답을 출력하는 switch case문 작성(2조)
		
		System.out.println("# 정답 맞추기 #");
		Scanner sc2= new Scanner(System.in);
		System.out.print("정답을 입력하세요 -> ");
		int ans = sc2.nextInt();
		
		switch(ans) {
			case 1:
				System.out.println("틀렸습니다");
				break;
			case 2:
				System.out.println("틀렸습니다");
				break;
			case 3:
				System.out.println("정답입니다!!!!");
				break;
			case 4:
				System.out.println("틀렸습니다");
				break;
			default:
				System.out.println("1번~ 4번만 작성하세요");
		}
		
		
		
		// 월별 마지막일 계산 프로그램
		int month = 5;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("마지막날은 31일까지 입니다");
				break;
			case 2:
				System.out.println("마지막날은 28일까지입니다");
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("마지막낳은 30일까지입니다");
			default:
				System.out.println("월의 입력범위는 1~12월까지입니다.");
			
		}
		
		
		// 응용2) 제비뽑기 1~10번호 중에 1,5,8은 입력금액의 200% 처리
		//  	2,4,9번은 입력금액의 300% 처리, 그외는 꽝으로 처리
		// 		기본 입력 범위는 1~10, 투자할 금액을 입력하세요 @@@ 뽑힌 번호는 랜덤
		int ranNum = (int) (Math.random() * 10 + 1);
		Scanner sc3 = new Scanner(System.in);
		
		System.out.print("투자할 금액을 입력하세요 : ");
		int pay = sc3.nextInt();
		
		switch(ranNum) {
			case 1:
			case 5:
			case 8: pay *= 2; System.out.println("**" + ranNum + "번이 나와서 200% 당첨! " + pay + "원 축하드립니다~!! **"); break;
			case 2:
			case 4:
			case 9: pay *= 3; System.out.println("**" + ranNum + "번이 나와서 300% 당첨! " + pay + "원 축하드립니다~!! **"); break;
			case 3:
			case 6:
			case 7: System.out.println(ranNum + "이 나와서 꽝!!!!!!!"); break;
			default: System.out.println("꽝!!!!!!!");
		}
		
		
	}

}
