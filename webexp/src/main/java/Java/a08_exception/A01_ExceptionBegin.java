package Java.a08_exception;

public class A01_ExceptionBegin {
	
	/*
	 
	 # 예외 처리
	 1. 자바는 프로그래밍의 안정성 확보를 위해 예외 처리를 지원한다.
	 2. 예외 처리를 통해서 예외가 나더라도 프로그램을 종료될 수 있도록 한다.
	 3. 기본 형식
	 	try {
	    	// 예외가 나타날 가능성이 있는 코드
	 	} catch (Exception e) {
	 		// 예외가 발생했을 때 코드
	 	}
	 4. 예외 처리의 계층 구조화 및 finally 블럭
	 	1) 먼저 최하위의 예외 클래스를 먼저 수행하고 
	 	2) 최종적으로 예외의 상위 클래스인 Exception을 수행한다
	 	3) 예외는 예외가 발생하는 순간 해당시점(라인)에서 바로 예외를 던진다.
	 		예외에 해당하는 block으로 catch로 예외를 잡게 된다.
	  	4) finally 구문은 예외가 발생했던, 발생하지 않았던 수행할 필요성이 있는
	  	코드를 선언하여 처리한다.
	  	
	 	try{
	 	..
	 	// 예외 발생시 예외 throw를 던진다.
	 	// 그 다음에 있는 라인은 수행하지 않는다. 
	 	..
	 	} catch (하위클래스 예외) {
	 	 // 잡은 예외를 수행처리한다.
	 	} catch (상위클래스 예외) {
	 	
	 	}
	 	
	 5. 예외 강제:  throw new 예외클래스()로 처리
	 6. 예외 위임: 메소드() throws 위임할 예외클래스
	 	메소드 내부에서 예외를 위임처리할 수 있다.
	 7. 사용자 정의 예외
	 	class 사용자 정의 예외 extends Exception{} 형식으로 선언할 수 있따.
	 
	 
	*/
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			System.out.println("프로그래밍 시작");
			System.out.println("프로세스1");
			System.out.println("프로세스2");
			System.out.println("프로세스3");
			System.out.println(1/0);
			System.out.println("프로세스4");
			System.out.println("프로세스5");
			System.out.println("프로세스6");
		} catch (Exception e) {	
			System.out.println("**예외가 발생했습니다**");
			// .getMessage() : 예외의 내용에 대한 메시지 출력
			System.out.println(e.getMessage());
		}	
			System.out.println("프로그래밍 종료");
			
			
		// 응용1) A02_ExceptionExp.java 생성후
		// String s = null; 를 선언 후 s.toString(); 
		// 코드가 예외가 발생하더라도 수행될 수 있도록 처리
		
	}

}
