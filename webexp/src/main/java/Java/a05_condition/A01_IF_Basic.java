package Java.a05_condition;

public class A01_IF_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 다중 주석문 처리: ctrl + shift + /
		
		// # 조건문
		/* 1. if (boolean: true/false) {
		 		조건이 true일 때, 수행하는 구문
		   }
		*/
		// 특정한 조건에 해당할 때, 처리할 구문을 블럭으로 설정하는 문장
		
		/*
		 	1) 형식1: 조건이 1개일때
		 		if(조건1) {
		 			// 해당 조건1이 true일 때 처리할 코드
		 		}
		 		
		 	2) 형식2: 조건1이 true일 때 처리할 코드
		 		if(조건1) {
		 			해당 조건1이 true일 때 처리할 코드
		 		} else {
		 			해당 조건1이 false일 때 처리할 코드
		 		}
		 		
		 	3) 형식3: 조건이 여러개일 때
		 		if(조건1) {
		 			해당 조건1이 true일 때 처리할 코드
		 		} else if(조건2) {
		 			해당 조건2이 true일 때 처리할 코드
		 		} else {
		 			조건1, 조건2를 제외한 그외 코드
		 		}
		*/
		
		// 조건문 활용문: 점수로 합격인지 확인
		int point = 80;
		System.out.println("획득한 점수: " + point);
		
		if(point>=70) {
			System.out.println("=> 합격");
		}else {
			System.out.println("=> 불합격");
		}
		
		// 응용) 선택한 번호를 chNum으로 1~4번으로 임의로 넣고
		// 		번호가 3일때 정답이고, 그 외에는 오답으로 출력
		// hint: chNum == 3
		int chNum = 4;
		System.out.println("\n선택한 번호: " + chNum);
		if(chNum == 3) {
			System.out.println("=> 정답입니다!");
		} else {
			System.out.println("=> 오답입니다.");
		}
		
		// switch(데이터) {
		// 		case 1: break;
		// 		case 2: break;
		// 		defalut:
		// } 
		
		
		
		// # 반복문
		// 1) for(초기값; 반복조건; 증감연산자) {
		// 		반복할 구문 작성 }

		// 반복문 활용문: 1에서 10 반복
		System.out.println("\n");
		for(int cnt = 1; cnt <= 10; cnt++) {
			System.out.println("카운트 세기: " + cnt);
		}
			
		// 응용1) 5 ~ 15까지 반복하는 반복문 만들기
		// 응용2) 100 ~ 90까지 카운트다운하는 반복문 만들기
		//hint: 증감연산자 cnt-- 를 이용해 시작값이 100부터 반복조건이 90이상
		System.out.println("\n숫자반복 시작~!");
		for(int cnt1 = 5; cnt1 <= 15; cnt1++) {
			System.out.println(cnt1);
		}
		
		System.out.println("\n카운트다운 시작~! ");
		for(int cnt2 = 100; cnt2 >= 90; cnt2--) {
			System.out.println(cnt2);
		}
		
		// 2씩 증가 처리
		System.out.println("\n2씩 증가하는 반복문 시작");
		for(int cnt3 = 1; cnt3 <= 20; cnt3 += 2) {
			System.out.println(cnt3);
		}
		
		
		// 2. while(반복조건) {
		//		반복할 코드, 적어도 한번이상 반복 }
			
		
		// # 반복문과 break와 continue
		// 반복문 안에 if()를 활용해 break는 완전 반복을 중단
		// continue는 반복하던 해당 step을 다음 step으로 넘김
		
	}

}
