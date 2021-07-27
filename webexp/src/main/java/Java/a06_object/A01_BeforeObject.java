package Java.a06_object;

public class A01_BeforeObject {
	
	/* 2. 합산처리 함수: static -> 객체 생성 없이 사용가능
	 * 						new 객체(); 로 선언 없이 사용할 수 있는 멤버
	   리턴할 type  메소드명(들어올 데이터 유형 선언 - 매개변수 parameter type)
				  plus(30,20)
				  num01= 30, num02 = 20
	*/
	static int plus(int num01, int num02) {
		// 함수를 통해서 처리할 프로세스
		int tot = num01 + num02;
		//리턴할 실제 데이터
		// 함수를 호출한 곳에 데이터를 전달 
		// 선언된 데이터 유형과 동일하게 데이터를 return 처리
		return tot;
	}
	
	// 응용1 메소드 선언
	static int minus(int num01, int num02) {
		int tot2 = num01 - num02;
		return tot2;
	}
	
	// 응용2 메소드 선언
	static int calcu(int price, int cnt) {
		int tot3 = price * cnt;
		return tot3;
	}
	
	static String login(String id, String pass) {
		String result = "";
		// 문자를 비교할때에는 equals를 이용해야함 == 이용시 에러
		// &&는 논리연산을 하는 비교연산자
		// id가 himan이고 비번이 7777일때 로그인 성공, 아니면 실패 처리
		if(id.equals("himan") && pass.equals("7777") ) {
			result = "로그인 성공";
		} else {
				result = "로그인 실패";
		}	
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 위의 static으로 선언한 합산처리 함수 출력
		System.out.println("활용1 " + plus(30,20));
		System.out.println("활용2 " + plus(500,300));
		
		
		// 응용1) minus 두개의 값을 뺄셈 처리한 데이터를 리턴
		// 응용2) calcu 물건 가격과 갯수로 총계를 처리한 데이터 리턴
		
		// 응용 출력
		System.out.println("응용1 " + minus(50, 30));
		System.out.println("응용2 " + calcu(3000, 5));
		
		// 로그인 출력
		System.out.println(login("himan", "8888"));
		System.out.println(login("himan", "7777"));
		
		
		/* 
		 # 객체의 메모리 (1)
		 	ex) 도서관 [T01_ㅈ] 자바의 정석
		 		T01_ㅈ: 순서에 의한 도서의 위치를 말함
		 	자바에서 작은 메모리는 바로 할당하여 사용, 
		 	stack 영역의 primitive 데이터 유형
		 	큰 메모리는 즉, heap 영역에 해당 데이터를 할당한 후에
		 	heap 영역의 주소값을 stack 영역에 할당하여 사용
		 	
		 	(그래서 다음에 한다는건지?... )
		 	- null이 무엇인지?
		 	- NullPointerException?
		 	- String에서 equals와 ==의 차이점
		 
		 # 함수 (2)
		 	자바에서는 기능함수를 클래스 소속의 기능 구성요소인 메소드 개념으로 활용
		 	ex) 자판기 기능
		 	기본형식: 리턴할 데이터유형  함수명(입력할 데이터1, 입력할 데이터2) {
		 				처리할 코드
		 			 	return 실제 리턴할 데이터;
		 			 }
		*/
		
		
		// 1. 기본 데이터
		// num01 변수는 할당한 값이 정수라서 바로 확인가능
		int num01 = 30;
		System.out.println(num01);
		// 데이터형이 Object는 참조 데이터형으로 주소값을 나타냄
		// 주소값은 객체@16진수로 heap영역의 주소값을 나타냄
		Object ob01 = new Object();
		System.out.println(ob01);
		 
	}

}
