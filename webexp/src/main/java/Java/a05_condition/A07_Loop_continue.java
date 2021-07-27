package Java.a05_condition;

public class A07_Loop_continue {

	/*
	
	#반복문의 제어
	1. 반복문의 제어를 위해서는 break와 continue가 사용된다.
	2. break문은 if()와 함께 해당 반복을 중단처리 해준다.
	3. continue는 if와 함께 해당 단위 반복 내용을 중단하고,
		다음 반복을 수행 처리해준다.
		
		
		
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// break문 실습
		System.out.println("# break를 만났을 때 #");
		for(int cnt=1; cnt<=10; cnt++) {
			if(cnt == 5) {
				System.out.println("곰돌이 단식 투쟁!");
				break; // 더이상 반복을 수행하지 않음
			}
			System.out.println("곰돌이가 먹은 " + cnt + "번째 젤리!");
		}
		
		// continue문 실습
		System.out.println("# continue를 만났을 때 #");
		for(int cnt=1; cnt<=10; cnt++) {
			if(cnt == 5) {
				System.out.println(cnt + "번째 젤리는 안먹어요!");
				continue; // continue가 있으면 해당 순서의 반복문 패스
			}
			System.out.println("곰돌이가 먹은 " + cnt + "번째 젤리!");
		}
		
		
		
		// 응용) 한달에 1일~30일동안 개발자가 근무하되 1일부터 시작하는 월요일이 있는 달이어서
		// 		토/일에 해당하는 날은 근무를 하지 않는다.
		// 		아래와 같이 출력하기 
		// 		1일째 - 개발자 열심히 개발하다, 6일째 - 토요일은 취미생활, 7일째 - 일요일은 가족과 함께
		// 		hint! % 이용하기 

		for(int i = 1; i <= 30; i++) {
	
			
			// ***********************
			if(i%7==6) { // 7로 나눴을때 1로 생각했는데 6일때가 토요일임!!
				System.out.println(i + "일째는 토요일! 취미생활");
				continue;
			}
			
			if (i%7==0) {
				System.out.println(i + "일째는 일요일! 가족과 함께");
				continue;
			}
			
			System.out.println(i + "일째 개발자 열심히 개발을 하다");
		}
		
		
		
	}

}
