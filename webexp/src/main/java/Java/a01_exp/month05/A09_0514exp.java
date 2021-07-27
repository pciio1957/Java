package Java.a01_exp.month05;

import java.util.Scanner;

public class A09_0514exp {
	
 	/*
	
	# 정리문제
	1. java 프로그램을 작성한 후 컴파일 과정과 실행 과정을 main()와의 관계 속에서 기술하세요
		1) 실행명령어 위치기술, 컴파일 파일 위치 기술
		2) A01_Start.java 기준, main()가 있을 때와 없을 때의 차이점
		3) 컴파일 실행 파일이 만들어지는 과정
	2. 변수의 계층적(중괄호 블럭)으로 처리된다는 의미를 지역변수/전역변수와 함께 간단한 예제로 기술하기
	3. 변수명의 선언 규칙을 클래스의 구성요소와 변수명을 나누어서 기술하기
		(클래스명, 생성자명, 참조변수명, 메소드명)
	4. 자바의 기본데이터 유형과 크기(byte)를 변수 선언과 할당과 함께 주석문으로 설명하기
	5. 자바에서 형변환 유형을 기본 유형과 상속에 의한 유형으로 나눠서 예제를 통해 기술하기
	6. 연산자의 종류 중에서 비교연산자와 논리 연산자의 차이점에 대해 기술하기
	7. 아래와 같은 데이터를 처리하려고 한다. 비교/논리연산자를 활용하라.
		놀이공원의 기본 요금 50000원에 나이에 따른 할인율 처리
		5세 미만 65세 이상 할인율 : 100% 무료
		5세 이상 8세 미만 할인율 : 50%
		9세 이상 18세 미만 할인율 : 30%
		19세 이상 64세 미만 할인율 : 0%
		1단계) 할인율만 표시
		2단계 할인율을 계산해서 총 비용을 typecasting해서 출력하기
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 문제1
		 1-1) 실행명령어의 위치는 C:\java\jdk-11\bin 안의 java.exe 파일이다.
		 	  컴파일 파일의 위치는 C:\javaexp\workspace\javaexp\build\classes\javaexp 안에 존재한다.		
		 1-2) main() 메소드가 있을 경우에는 java를 실행(java.exe)시켜서 프로그램을 돌려 결과를 확인할 수 있다
		 	  main() 메소드가 없는 경우에는 java를 실행시키지못하고, 참조할 수 있는 외부클래스를 생성할 수 있다... 
		 1-3) 코드 -> .java -> .class 순서로 컴파일 실행 파일이 만들어진다.
		*/
		
		// 문제2
		Check ch = new Check();
		ch.call(15);
		
		// 문제3
		Chiken duck = new Chiken("닭");
		duck.getName();
		
		// 문제4 
		// 정수형
		byte num01 = 127;
		// byte : 정수형, 1byte, -128~127 값을 가짐
		char num02 = '네';
		// char : 정수형, 2byte, 0~65535 값을 가짐, 유니코드 문자를 나타낸다. 
		short num03 = 32767;
		// short : 정수형, 2byte, -32768~32767
		int num04 = 1234567;
		// int : 정수형, 4byte, 정수형의 기본 데이터 유형
		long num05 = 1234564654654L;
		// long : 정수형, 8byte, long 유형인것을 알리는 대소문자 상관없이 L을 적어줘야 적용됨
		
		// 실수형
		float num06 = 120.13f;
		// float : 실수형, 4byte, 기본 데이터 유형이 아니라서 대소문자 상관없이 f를 적어줘야 적용
		double num07 = 12345.1234;
		// double : 실수형, 8byte, 실수형의 기본 데이터 유형
		
		// 논리형
		boolean num08 = false;
		// boolean : 논리형, 1byte, true/false값만 가질 수 있다.
		
		
		// 문제5
		System.out.println("\n# 5. 형변환 유형 - 기본 유형 #");
		int num11 = 10;
		double num22 = num11;
		System.out.println("promote 결과 : " + num22);
		
		double num33 = 30.28;
		int num44 = (int) num33;
		System.out.println("casting 결과 : " + num44);
		
		// promote, Father 객체로 만들어진것이라서 아들의 메소드 사용 불가능
		Father ft = new Son("홍길동"); 
		// ft.printName(); 하위에 있는 메소드는 상위객체로 사용할 수 없다.
		// Father 객체로 만들어진 것을 Son으로 만듬. 큰 -> 작은 casting이라 명시화
		Son son = (Son) ft;
		son.printName();
		
		
		// 문제6
		/*
		
		비교연산자와 논리연산자의 비교
		비교연산자의 경우는 값과 값의 비교지만, 
		논리연산자는 비교연산자를 포함한 식과 식의 비교를 할 수 있다.
		그래서 프로세스를 축약해서 사용할 수 있으며 앞의 비교가 해당하지 않는 값이
		나오면 뒤의 비교연산자의 수행을 하지않는다.
		
		*/
		
		
		// 문제7
		System.out.println("\n# 7. 놀이공원 요금할인율 계산 #");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이를 입력하세요 -> ");
		int age = sc.nextInt();
		int discount = 0;
		
		if (age<5 || age>= 65) {
			discount = 100;
		} else if (age>=5 && age<8) {
			discount = 50;
		} else if (age>=9 && age<18) {
			discount = 30;
		} else {
			discount = 0;
		}
		
		// 1단계
		System.out.println("할인율 : " + discount + "% 입니다");
		
		// 2단계
		float cal = (float) discount/100f;
		int tot = (int) (50000 - (50000 * cal));
		
		System.out.println("내실 놀이공원 요금 : " + tot);
	}
	
	
	
	

}

// 문제2 
class Check {
	private String chk1 = "안녕하세요";
	
		public void call(int cnt) {
			System.out.println("\n# 2. 전역/지역변수 구분 ");
			// Check 클래스의 call 함수에서만 사용되는 지역변수, 매개변수로 받아온 지역변수이다
			// 클래스 안에 존재하는 함수에 선언되어있으므로 해당 함수내에서만 사용 가능하다.
			System.out.println("지역변수의 값 출력 : " + cnt);
			// Check 클래스의 클래스변수, 전역변수로 선언된 변수이다. 제일 크게 감싸고 있는 중괄호 블럭의 변수로
			// 클래스 내에서 어느 함수에서도 사용가능하다. 
			System.out.println("전역변수의 값 출력 : " + chk1);
		}
}

// 문제3 
class Chiken {	
	// 클래스명의 경우 class유형 클래스명 으로 사용
	// 관례에 따라 클래스명은 대문자로 시작하며, 예약어는 사용불가능하다. 숫자로 시작할 수 없다.
	
	private String name; 
	// 필드값, 참조변수명의 경우 접근제어자 데이터유형 참조변수명 = 데이터; 으로 사용
	// 대소문자를 구분하며, 관례를 따라 소문자로 시작하며, 숫자로는 시작하지 못한다. 또한 특수문자는 $, _만 가능하다

	public Chiken (String name) {
		super();
		this.name = name;
	}
	// 생성자의 경우 접근제어자 클래스명() 으로 사용
	// 클래스를 생성시 사용될 변수의 초기값을 위한것으로 클래스명을 그대로 사용

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// 메소드의 경우 접근제어자 데이터유형 메소드명() 으로 사용
	// 클래스명과 다르게 메소드명은 소문자로 시작하는 것이 관례이다. 
	// 예약어를 사용할 수 없으며 숫자로 시작되는 것도 안된다. 
	
}

class Father {}

class Son extends Father {
	private String name;
	
	public Son(String name) {
		super();
		this.name = name;
	}

	void printName() {
		System.out.println("아들의 이름 : " + name);
	}
	
}
