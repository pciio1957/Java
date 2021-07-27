package Java.a09_api;

import java.util.Random;

public class A15_Math {

	/*
	
	#Math 클래스 하위 여러가지 기능 api
	1. Math.abs() : 절대값 처리 |-5| = 5
	2. Math.ceil() : 올림 처리
	3. Math.floor() : 내림 처리 
	4. Math.min(데이터1, 데이터2) : 두 수 중 최소값 리턴
	5. Math.max(데이터1, 데이터2) : 두 수 중 최대값 리턴
	6. Math.round() : 반올림 처리
	7. Math.random() : 랜덤 데이터 처리 (0.0 <= R < 1.0)
		cf) Random r = new Random();
			r.nextInt(정수형 범위)
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Math.abs 실습
		int v1 = Math.abs(-5); 
		double v2 = Math.abs(-3.14);
		System.out.println("절대값1 : " + v1);
		System.out.println("절대값2 : " + v2);
		
		// Math.ceil 실습
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("올림1 : " + v3);
		System.out.println("올림2 : " + v4);
		
		// Math.floor 실습
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("내림1 : " + v5);
		System.out.println("내림2 : " + v6);
		
		// Math.max 실습
		int v7 = Math.max(5,  9);
		double v8 = Math.max(5.3,  2.5);
		System.out.println("최대값1 : " + v7);
		System.out.println("최대값2 : " + v8);
		
		// Math.min 실습
		int v9 = Math.min(5,  9);
		double v10 = Math.min(5.3,  2.5);
		System.out.println("최소값1 : " + v9);
		System.out.println("최소값2 : " + v10);
		
		// Math.round 실습
		long v11 = Math.round(5.3);
		long v12 = Math.round(-5.3);
		System.out.println("반올림1 : " + v11);
		System.out.println("반올림2 : " + v12);
		
		
		// 응용1) 최대값/최소값 가져오기 
		// 	주사위 2개를 던져서 나온 수 중에 이긴숫자/진 숫자 
		int dice1 = (int) (Math.random()*6 +1);
		int dice2 = (int) (Math.random()*6 +1);
		
		System.out.println("\n# 주사위 게임 #");
		System.out.println("이긴 숫자 : " + Math.max(dice1, dice2) + " (승)");
		System.out.println("진 숫자 : " + Math.min(dice1, dice2) + " (패)");
		
		
		// 응용2) 임의의 범위를 10자리와 소숫점 1자리로 나오게 하며
		//		반올림, 올림, 내림 처리 결과를 출력하기
		// 		0 ~ 999 -> 0.0 ~ 99.9 
		// 		범위를 나오게 하고 거기에 실수를 곱해준다.
		int ranNum = (int) (Math.random() * 1000);
		double rnum = ranNum/10.0;
		
		System.out.println("\n# 숫자  #");		
		System.out.println(ranNum);
		System.out.println(rnum);
		
		System.out.println("\n# 숫자 함수 사용 #");
		System.out.println("반올림 : " + Math.round(rnum));
		System.out.println("올림 : " + Math.ceil(rnum));
		System.out.println("내림 : " + Math.floor(rnum));

		
		// Random()
		Random ran02 = new Random();
		System.out.println(ran02.nextBoolean());
		System.out.println(ran02.nextDouble());
		System.out.println(ran02.nextInt());
		
	}

}
