package Java.a02_basic;

public class A06_DataType {

	
	/*
	
	#기본 데이터 타입
	1. 정수, 실수, 문자, 논리 리터럴을 직접 저장하는 타입을 말한다.
		25 (리터럴상수)
	2. 메모리의 최소 기억단위인 bit가 8개 모여 byte가 형성되어 범위를 설정한다.
	3. 유형
		1) 정수형
			byte (1byte) : -128~127
			char (2byte) : 0~65535, 유니코드 문자
				char c1 = 'A';
				char c2 = (char) 25; 정수형 25번째 코드값이 c2변수에 할당
			short(2byte) : -32768~32767
			(default*) int(4byte) : -2147483648~2147483647
			long (8byte)
				ex) long num02 = 25L; 25억데이터.. L이 함축된건가봄,,
		2) 실수
			float (4byte)
			(default*) double (8byte)
		3) 논리
			boolean (1byte) true/false
			
	 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 응용) 기본 데이터 유형의 이름과 타입에 맞게 데이터를 선언하고 출력하기
		// 		확인 : 연산자를 이용해 데이터 할당은 어떤 타입부터 가능한지 확인하기
		// (새로운 조기준 1조 전달하기)
		
		// byte 타입의 min/max 데이터 확인
		byte num00 = -128;
		byte num01 = 127; 
		// byte num000 = num00 + num01; 더하기 X, 1byte를 넘어가서?
		System.out.println("byte 데이터 타입 : " + num01);
		
		// char 타입의 데이터 할당 확인
		char num02 = 6;
		char num03 = '6'; 
		char num04 = (char) 6;
		System.out.println("char 데이터 타입 :" + num02 ); // 특수문자 출력 => 이상한?
		System.out.println("char 데이터 타입 :" + num03 ); // 그대로 출력, 1byte만 할당
		System.out.println("char 데이터 타입 :" + num04 ); // (char) 없는거랑 같음
		
		// short 타입의 데이터 할당 확인
		short num05 = 1;
		short num06 = 1000;
		short num07 = 32767;
		//short num08 = 32768; // 에러 Unresolved compilation problem:
		System.out.println("short 데이터 타입 : " + num05);
		System.out.println("short 데이터 타입 : " + num06);
		System.out.println("short 데이터 타입 : " + num07);
		
		// 실수 타입의 데이터 할당 확인
		float num08 = 30; // 정수형으로 데이터 입력 가능, 소수점이 붙음
		//float num09 = -20.6564984916565; 데이터가 너무 커서 double로 해야함
		double num09 = -20.6564984916565; // 더블로 선언하니 가능
		System.out.println("실수 데이터 타입 : " + num08);
		System.out.println("실수 데이터 타입 : " + num09);	
		
		// 정수 타입의 데이터 할당 확인
		int num10 = 10;
		//int num11 = 30.0; 정수형이라서 소수점이 붙은 실수 할당 불가능
		//int num11 = 3216549879849546546;  너무 커서 long으로도 불가능...
		int num11 = 22222222; 
		//int num12 = 2222222222; // 10억단위로 올라가니 할당 안됨
		// int에서 안되던거 long으로 L붙이니까 가능, Long 형인걸 표시해야함
		long num12 = 2222222222L; 
		
		
		
		
	}

}
