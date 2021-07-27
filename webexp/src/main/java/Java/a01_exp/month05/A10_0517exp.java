package Java.a01_exp.month05;

import java.util.Scanner;

public class A10_0517exp {

	/*
	
	마무리 문제
	1. 중첩조건문의 형식을 정리하고 영어/수학 점수를 입력받아 합격기준이 영어/수학 점수가 모두 80점 이상인 경우와 수학점수만 100점인 경우를 기준으로 하였다고 가정하면, 중첩조건에 의해 합격/불합격여부와 합격기준을 표시하세요

	2. switch case문의 기본형식을 기술하고 
	경마를 해서 8마리의 말 중에 1~3등까지 600%, 400%, 200%의 당첨금을 받기로 했다. 티켓 금액을 입력하고 랜덤에 의해 1~8말을 선택하고 당첨금 총액을 출력처리하세요

	3. [1단계] for문을 활용하여 단가 2200원의 김밥 1~30개의 가격을 출력하세요
	   [2단계] 김밥 주문에 따른 총비용을 누적하세요. 종류 2가지만 입력받아 3000원 3개, 3500 2개 
			1 3000 3000
			2 3000 6000
			3 3000 9000
			4 3500 12500
			5 3500 15000

	4. for문을 활용해 아래의 형식(1~10)으로 출력하세요
	1단계 짝수만 %연산자를 이용해 출력
	2단계 5개 단위로 줄바꿈처리
		2 4 6 8 10
		12 14 16 18 20

	5. for문을 이용해 3,6,9게임으로 출력하세요
	1단계 (1~10까지)
		1 2 짝 4 5 짝 7 8 짝 10...
	2단계 (11~20까지)
	11 12 짝 14 15 짝 17 18 짝 20
	
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1번문제
		/*
		 
		#중첩조건문의 형식
		if(조건1) {
			if(조건2) {
				// 조건1에 해당하고, 조건2에도 해당하는 구문
			} else {
				// 조건1에 해당하지만, 조건2에는 해당되지 않는 구문
			}
		} else {
			if(조건2) {
				// 조건1에 해당하지 않지만, 조건2에는 해당하는 구문
			} else {
				// 조건1과 조건2에 해당하지않는 구문
			}
		}
		*/
		
		int eng = 80;
		int math = 75;
		
		System.out.println("# 1. 시험점수 확인 #");
		if(eng>=80 && math>=80) {
			if(math==100) {
				System.out.println("합격입니다");
				System.out.println("영어/수학기준을 모두 넘겼습니다");
			} else {
				System.out.println("합격입니다");
				System.out.println("영어/수학 점수가 80점이상입니다");
			}
		} else {
			if(math==100) {
				System.out.println("합격입니다");
				System.out.println("수학점수가 100점입니다");
			} else {
				System.out.println("불합격입니다. ");
			}
		}
		
		// 2번문제
		/*
		
		#switch case문의 기본형식
		switch(변수) {
			case 값: 변수의 값에 해당하는 case값의 코드 실행
			case 값:
			..
			default: 값이 해당되지 않을때 수행하는 코드
		}
		*/
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\n# 2. 경마 배팅 #");
		
		System.out.print("배팅금액을 입력하세요 : ");
		int hPay = sc2.nextInt();
		System.out.println("말은 랜덤하게 선택됩니다........ ");
		int horse = (int) (Math.random() * 8 + 1);
		System.out.println("선택된 말은 " + horse);
		
		
		switch(horse) {
			case 3: 
				System.out.println("축하합니다!! 1등입니다!!!");
				System.out.println("당첨금은 총 " + hPay * 6 + "원 입니다!");	
			case 7:
				System.out.println("축하합니다!! 2등입니다!");
				System.out.println("당첨금은 총 " + hPay * 4 + "원 입니다!");
				break;
			case 1: 
				System.out.println("축하합니다!! 3등입니다!");
				System.out.println("당첨금은 총 " + hPay * 2 + "원 입니다!");
				break;
			case 2:
			case 4:
			case 5:
			case 6:
			case 8:
				//System.out.println("당첨되지 않았습니다...");
			default: 
				System.out.println("당첨되지 않았습니다...");
		}
		
		
		// 3번문제
		int tot1 = 0;
		
		// 오잉 2200원인데 왜 3000원으로 했지 ㅎ
		System.out.println("\n # 3. 김밥주문서 #");
		System.out.println("주문명\t갯수\t단가\t총계");
		for(int i=1; i<=30; i++) {
			tot1 += 3000;
			System.out.print("김밥\t" + i + "\t3000\t" + tot1 + "\n");
		}
		
		
		int tot2 = 0;
		
		System.out.print("\n3000원 김밥 주문갯수를 입력하세요 : ");
		int kim1 = sc2.nextInt();
		System.out.print("\n3500원 김밥 주문갯수를 입력하세요 : ");
		int kim2 = sc2.nextInt();
		
		System.out.println("\n갯수\t단가\t총계");
		for(int i=1; i<=kim1; i++) {
			tot2 += 3000;
			System.out.print(i + "\t3000\t" + tot2 + "\n");
		}
		
		for(int i=1; i<=kim2; i++) {
			tot2 += 3500;
			System.out.print((++kim1) + "\t3500\t" + tot2 + "\n");
		}
		
		
		
		// 4번문제
		System.out.println("\n # 4. 2단 구구단 #");
		for(int i=1; i<=20; i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
			}
		}
		
		System.out.println("\n\n # 5단위로 끊기 #");
		for(int i=2; i<=20; i+=2) {
			if(i%10==0) {
				System.out.print(i + "\n");
			} else {
				System.out.print(i + "\t");
			}
		}
		
		
		// 5번문제
		System.out.println("\n # 5. 369게임1 #");
		for(int i=1; i<=10; i++) {
			if(i%3==0) {
				System.out.print("짝\t");
			} else {
				System.out.print(i + "\t");
			}
		}
		
		System.out.println("\n # 5. 369게임2 #");
		for(int i=11; i<=20; i++) {
			if((i-10)%3==0) {
				System.out.print("짝\t");
			} else {
				System.out.print(i + "\t");
			}
		}
		
		
		// 5번문제 3단계 - 1000까지 돌리기~!
		String str = "";
		for(int c=1; c <= 1000; c++ ) {
			str = "";
			String numS = "" + c;
			for(char ch:numS.toCharArray()) {
				if(c=='3' || c=='6' || c=='9') {
					str+="짝";
				}
			}
			
			if(str.equals("")) {
				System.out.println(c+"\t");
			} else {
				System.out.println(str+"\t");
			}
			
		}
		
		
		
		
	}

}
