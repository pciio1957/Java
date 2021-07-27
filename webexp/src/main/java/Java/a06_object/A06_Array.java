package Java.a06_object;

public class A06_Array {
	
	
	/*
	
	#다차원 배열
	1. 2차원 이상의 배열을 말한다. 
	2. 자바는 1차원의 배열을 활용하여 2차원 이상의 배열을 처리할 수 있다.
	
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1차원 배열
		String[] train = {"1호차", "2호차", "3호차"};

		System.out.println(train[0]);
		System.out.println(train[1]);
		System.out.println(train[2]);
		
		
		// 2차원 배열
		String[][] trainSeats = {{"1번좌석", "2번좌석"},
								{"1번좌석", "2번좌석"},
								{"1번좌석", "2번좌석"}};
		System.out.println("1호차" + trainSeats[0][0]);
		System.out.println("1호차" + trainSeats[0][1]);
		System.out.println("2호차" + trainSeats[1][0]);
		System.out.println("2호차" + trainSeats[1][1]);
		System.out.println("3호차" + trainSeats[2][0]);
		System.out.println("3호차" + trainSeats[2][1]);
		
		
		// 응용) 1차원배열로 1, 2,3학년 할당 후 출력
		//		2차원배열로 각 학년의 2반까지 할당 후 출력
		
		String[] grade1 = {"1학년","2학년","3학년"};
		
		String[][] grade2 = { {"1학년 1반", "1학년 2반"},
								{"1학년 1반", "1학년 2반"},
								{"1학년 1반", "1학년 2반"}		
							};
		
		System.out.println("\n# 학년 소개 #");
		System.out.println(grade1[0]);
		System.out.println(grade1[1]);
		System.out.println(grade1[2]);
		// 배열의 전체크기
		System.out.println("1차원 배열의 크기 : " + grade1.length);

		System.out.println("\n# 학년반 소개 #");
		System.out.println(grade2[0][0]);
		System.out.println(grade2[0][1]);
		System.out.println(grade2[1][0]);
		System.out.println(grade2[1][1]);
		System.out.println(grade2[2][0]);
		System.out.println(grade2[2][1]);
		// 배열의 1차원 크기 = {}의 개수? 
		System.out.println("2차원 배열의 크기: " + grade2.length);
		// 배열의 2차원? 크기 = 1차원안의 2차원의 크기로 2개! 괄호안의 값
		System.out.println("2차원 배열 특정한 위치의 크기 : " + grade2[1].length);
		
		// 반복문을 이용한 출력
		
	}
	

}
