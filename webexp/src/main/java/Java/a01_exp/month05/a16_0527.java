package Java.a01_exp.month05;

import java.io.IOException;
import java.io.InputStream;

public class a16_0527 {
	
	/*
	
	#정리문제
	
	<DB>
	1. select 문의 기본형식 기술하기
	2. 사원정보(emp)에서 부서번호, 사원번호, 사원명, 급여를 출력하세요
	3. 별칭선언의 기본 형식을 기술하기
		사원정보에서 사원번호를 번호, 사원명을 이름, 급여를 연 봉으로
		alias로 선언하여 출력하기
	4. 사원정보를 아래의 형식으로 출력하기
		부서번호를 %로 해서 보너스를 지정했다고 가정할 때
		부서는 @@이고, 사원번호는 @@@, 급여는 @@@, 보너스는 @@입니다 
		한 라인으로 출력하기
	5. database에 있어서 jdbc는 어떤 역할을 하는가
	6. xe를 활용하여 db 서버에 접속하려고 한다. 필요로 하는 서버 등록 정보는 무엇인가?
	
	<JAVA>
	1. 예외의 종류 2가지를 기본 예제를 통해서 기술하기
	2. 예외 위임이란 무엇인가를 기술하고
		int[] iarr = null; iarr[0]; 코드가 포함되어 있는
		arrexp1(), arrexp2(), arrexp3() 예외 위임 처리하기 
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1번문제
		// 1) 일반 예외 처리 : 예외처리 코드가 없으면 컴파일 오류 발생
		// 			Stream, 메모리관련 로딩, DB 등은 반드시 예외처리를 해야한다.
		
		System.out.println("# 1. 예외 처리 #");
		InputStream is = System.in;
		
		try {
			is.read();
		} catch (IOException e) {
			System.out.println("# 1-1. 예외 처리 : " + e.getMessage());
		}
		
		// 2) 실행 예외 : 예외 처리를 하지않아도 컴파일이 되는 예외
		//		예외의 가망성이 있는 경우 예외 처리를 해주어야 함
		try {
			// 정수를 0으로 나누려고 하면 오류 발생 
			System.out.println(1/0);
		} catch(ArithmeticException ae) {
			System.out.println("# 1-2. 예외 발생 : " + ae.getMessage());
		}
		
		
		// 2번문제
		// 예외 위임 : 메소드 단위로 예외를 위임할 수 있는데 
		//		동일한 예외를 다른 메소드와 함께 동시에 처리할 때 사용된다.
		//		위임된 예외는 공통적인 예외처리하는 곳 try-catch문에서 처리된다.
		System.out.println("\n# 2. 예외 위임 #");
		
		
		
		try {
			arrexp1();
			arrexp2();
			arrexp3();
		} catch (NullPointerException ne) {
			System.out.println("예외 발생 : " + ne.getMessage());
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		} 
		
		
	}
	
	static void arrexp1() throws NullPointerException {
		int[] iarr = null;
		System.out.println(iarr[0]);
	}
	static void arrexp2() throws NullPointerException {
		int[] iarr = null;
		System.out.println(iarr[0]);
	}
	static void arrexp3() throws NullPointerException {
		int[] iarr = null;
		System.out.println(iarr[0]);
	}

}
