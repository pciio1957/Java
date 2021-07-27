package Java.a08_exception;

public class A02_ExceptionExp {

	/*
	 
	 # 예외 처리 순서
	 1. 예외 가능성 있는 코드를 실행
	 2. 예외 발생 및 발생 예외 클래스 복사
	 3. try{}catch(복사한예외클래스) {}
	 4. 예외 내용 확인 및 테스트
	 
	*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 응용1
		
		try {
			String su = null;
			su.toString();
		} catch(NullPointerException e) {
			System.out.println("**예외가 발생했습니다**");
			System.out.println(e.getMessage());
		}
	}

}

