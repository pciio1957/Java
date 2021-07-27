package Java.a03_var_type;

public class A01_Variavles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/* 
	# 자바의 변수 선언
	1. 데이터유형 변수명;
		int num01;
		= 정수형으로 num01을 선언한다.
	2. 데이터할당
		num01 = 25;
		25라는 실제 데이터를 할당
	3. 호출과 활용
	 	System.out.println(num01);
	 	int num02 = num01 + 30;
		 */
		
		int num01;
		num01 = 25;
		System.out.println(num01);
		// num01에 있는 데이터 출력
		
		// 응용) num02 숫자 1000 할당 후 출력
		int num02 = 1000;
		System.out.println(num02);
		
		// 호출과 활용 다른 변수의 값을 더한 변수
		int num03 = num01 + num02; // num03에 할당
		
		// # 출력유형 
		// 1. "문자열" + 변수
		// 2. 변수 + "문자열"
		// 3. "문자열" + 변수 + "문자열"
	
		// 자동완성: sysout + ctrl + space -> System.out.println(""); 
		System.out.println("num01 + num02 = " + num03);
		System.out.println(num01 + " + " + num02 + " = " + num03);
		
		// 응용) 사과의 갯수 5, 바나나의 개수 3로
		//총계 8을 변수를 이용해 출력
		int apple = 5;
		int banana = 3;
		int sum = apple + banana;
		
		System.out.println("1) 총계 = " + (apple + banana));
		System.out.println("2) 총계 = " + sum);
		
		System.out.println("사과의 갯수 " + apple + " + 바나나의 갯수 " +
		banana + " = 총계 " + sum);
		
		// # 문자열 데이터 처리
		// 문자열은 객체형이기 때문에 type의 선언을 대문자로 시작한다
		// String 변수;
		// 변수 = "할당데이터";
		
		String name1 = "홍길동";
		String location = "서울 신림동";
		System.out.println("이름은 " + name1);
		System.out.println("사는 곳은 " + location);
		
		// 응용) 좋아하는 영화제목 movie1, movie2, movie3을 선언하고
		// 영화 Rank1 : ** 형식으로 출력하기
		
		String movie1 = "나이브스아웃";
		String movie2 = "찰리의 초콜릿공장";
		String movie3 = "하울의 움직이는 성";
		
		// 줄복사: ctrl + alt + 화살표아래
		System.out.println("영화 Rank 1위 : "+ movie1);
		System.out.println("영화 Rank 2위 : "+ movie2);
		System.out.println("영화 Rank 3위 : "+ movie3);
		
		// 기타 데이터 유형 (다음 파트할때 진행)
		// byte, short, int, long (정수형)
		// float, double (실수형)
		// boolean (논리형)
		// 형변환: 데이터 유형의 변환 처리
	}

}
