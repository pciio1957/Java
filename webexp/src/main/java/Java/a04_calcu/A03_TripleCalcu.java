package Java.a04_calcu;

import java.util.Scanner;

public class A03_TripleCalcu {
	
	/*
	
	#삼항연산자
	1. 세 개의 피연산자를 필요로 하는 연산자를 말한다.
	2. 앞의 조건식 결과에 따라 콜론 앞 뒤에 피연산자를 선택 -> 조건 연산식
		조건식 ? 결과값1 : 결과값2
		조건식이 true이면 결과값1로 할당, false이면 결과값2 할당
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 예제
		int point = 70;
		String result = point>=70?"합격":"불합격";
		System.out.println("결과내용 : " + result);
		
		
		// 응용) 삼항연산자를 이용해 나이를 받아서 65세 이상과 5세 미만은 무료
		//		그 외는 유료로 처리하세요
		Scanner sc1 = new Scanner(System.in);
		System.out.println("나이를 입력하세요 -> ");
		int age = sc1.nextInt();
		
		
		String result2 = age>=65||age<5?"무료":"유료";
		System.out.println("결과 내용 : " + result2);

	}

}
