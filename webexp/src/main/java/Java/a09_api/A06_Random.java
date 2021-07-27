package Java.a09_api;

public class A06_Random {
	
	/*
	 
	 # 랜덤
	 1. 프로그래밍에서 랜덤으로 수를 처리하여, 
	  	여러가지 경우에 나타내는 데이터를 처리할 수 있다. 
	 2. 자바에서 기본 Random수 처리하는 api 
	 	1) 0.0 <= Math.random() < 1.0 
	 3. 특정한 범위의 데이터를 처리하기
	 	0) 공식 (int) (Math.random() * 경우의 수 + 시작수)
	 	1) 주사위(1 ~ 6) 
	 		0.0 <= Math.random() * 6 < 6.0 // 0부터 시작
	 		1.0 <= Math.random() * 6 < 7.0 // 1부터 시작
	 		1 <= (int) (Math.random() * 6 + 1) < 7 // 소수점 삭제~! 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// random()을 그냥 사용한다면
		for(int cnt=1; cnt <= 10; cnt++) {
			System.out.println(Math.random()); 
			// 소수점 달린 엄청난 숫자가 10개나 나옴
		}
		
		// 주사위 경우의 수에 맞춰서 사용한다면
		for(int cnt=1; cnt <= 10; cnt++) {
			System.out.println(Math.random() * 6 + 1); 
			// 주사위의 범위 안에서 랜덤 데이터가 나옴
		}
		
		
		// 두개의 주사위를 던져서 합산한 값을 출력 
		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);
		
		System.out.println("두개의 주사위의 총합은 : " + (dice1 + dice2));
		
		
		// 응용) 임의로 1~10까지 숫자가 출력되도록 하기
		// 계속 바뀌어야하니까,, 안에서 변수설정 
		// 밖에서 하니까 같은값만 반복, 안에서 (int) 하니까 소수점이라 1만 반복함ㅋ
		// 한줄만 하니까 한줄만 출력하는디...ㅅㅂ
		System.out.println((int)(Math.random() * 10+1));
		
	}

}
