package Java.a02_basic;

public class A04_DeclareVar {
	
	/*
	
	#변수 이름 명명 규칙
	1. 변수는 데이터유형과 이름으로 선언한다
		int num01;
		유형 이름; (세미콜론)
	2. 변수명으로 선언할 수 있는 이름은 다음과 같다.
		필수 및 관례(가독성을 위한 것)
		1) 변수명의 첫번째 글자는 문자여야 한다
			특수문자는 $, _만 허용된다.
			int price; int $price; String _CompanyName; (O)
		2) 변수명의 첫번째 글자를 숫자로 사용하지 못 한다.
			int 1price; int 25price; (X)
			int price01; int price25; (O)
		3) 변수명은 대/소문자가 구별된다. 
			int numPrice;
			int numprice; -> 다름
		4) 변수명은 일반적으로 영어 소문자로 시작하되 다른 단어와 합성어로
			사용될 때는 구분하여 첫자를 대문자로 사용한다 (관례, 가독성)
				ex) 참조변수명, 메소드명은 소문자로 시작
				cf) 클래스명, 생성자명은 대문자로 시작하는 것이 관례이다
		5) 문자 수 길이 제한이 없다.
			너무 간단하게 하면 이해하지 못할 수도 있기 때문에 적당하게 적어야한다.
		6) 자바의 예약성(명령어로 내장된 것)은 변수로 사용할 수 없다.
			
		tip_ 변수명에 숫자를 붙여서 예약어에서 벗어날 수 있다.
		
			
	#변수의 사용
		1) 선언
			int score;
		2) 저장 ( =대입연산자 오른쪽에 있는 데이터로부터 왼쪽에 있는 변수로 할당
			score = 25;
		3) 호출
			System.out.println(score);
		4) 선언과 저장
			String name = "홍길동"; // 지역변수로 선언됨 -> 초기화함
			System.out.println(name);
			int nu01;  (X)
			System.out.pirntln(num01);
			// 지역변수(메소드안에 선언된 변수)는 반드시 초기화를 해야한다.
			// 초기화한 후에 호출해야 컴파일이 가능하다.
			// 클래스안에 쓰이는 전역변수는 초기화하지 않더라도 
			// 하단에서 사용이 가능하다 
		
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수 이름 명명 규칙 예제 확인
		int price; int $price; String _CompanyName; // (O)
		//int 1price; int 25price; // (X) 변수이름에 빨간줄이 뜸
		int price01; int price25; // (O)
		
		int numPrice; // 대소문자를 구별하기때문에 같은 변수가 아님
		int numprice; 
		
		// String break; // 예약어라 사용 X

	}

}
