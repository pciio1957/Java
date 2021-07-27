package Java.a05_condition;

import java.util.Scanner;

public class A02_DoubleIF {
	
	/*
	#계층적 조건문의 처리
	1. 조건문은 해당 조건을 기준으로 다시 조건문을 사용할 수 있다.  
		-> 중첩 if문이라고 한다
		
	2. 기본형식 
		if(조건1) {
			if(조건2) {
				// 조건1이고 조건2일 때, 처리할 구문
			} else {
				// 조건1이고 조건2가 아닐 때, 처리할 구문
			} 
			
		} else {
		
		}
		
	#중첩 조건문/반복문의 혼합 처리
	
	1. 유형
		1) 반복문안에 조건문 중첩
		for() {
			if() {} 
		} 
	
		2) 조건문안에 반복문 중첩
		if() {
			while() {}
		}
	
		3) 반복문안에 조건문 중첩
		while() {
			if() {}
		}
	
		4) 반복문 안에 반복문
		for() {
			for() {} 
		}
	
		5) true/false를 이용한 while문 처리
		while(true) {} 
		
	2. 이중 반복문/중첩반복문을 통해
		1) 최대값
		2) 최소값
		3) 정렬처리
		----> 알고리즘 연습
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ckMale = "Y";
		boolean isMale = ckMale.equals("Y"); // 남자인지 여부
		int age = 25;
		
		if(isMale) {
			if(age>=20) {
				System.out.println("신사입니다.");
			}else {
				System.out.println("소년입니다.");
			}
		} else {
			if(age>=20) {
				System.out.println("숙녀입니다.");
			}else {
				System.out.println("소녀입니다.");
			}
		}

		
		
		// 응용1) id, pass를 Scanner로 입력받되, id check를 먼저한 뒤 pass check 
		//		4가지인 경우에 대해 출력하기 (himan/7777)
		// 		1. 인증 완료 - 2. 패스워드 확인 - 3.아이디 확인 - 4. 아이디 패스워드 둘다 틀렸습니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" # ID/PASSWORD CHECK # ");
		System.out.print(" # ID 입력하세요 : ");
		String ckId = sc.nextLine();
		System.out.print(" # PASSWORD 입력하세요 : ");
		String ckPass = sc.nextLine();
		
		if (ckId.equals("himan")) {
			
			if(ckPass.equals("7777")) {
				System.out.println(" ---> 인증 완료");
			} else {
				System.out.println(" ---> 패스워드를 확인하세요");
			}
			
		} else {
			
			if(ckPass.equals("7777")) {
				System.out.println(" ---> 아이디를 확인하세요");
			} else {
				System.out.println(" ---> 아이디, 패스워드 모두 틀렸습니다");
			}
			
		}
		
		
	}

}
