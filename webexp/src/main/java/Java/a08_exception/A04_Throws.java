package Java.a08_exception;

public class A04_Throws {
	
	/*
	#예외 위임
	1. 자바의 예외는 메소드 단위로 예외를 위임할 수 있다.
	2. 동일한 예외를 다른 메소드와 함께 동시에 처리할 때 사용된다.
	3. 위임된 예외는 공통적인 예외 처리하는 곳에서
	 	try{ } catch (위임된 예외) {}로 처리할 수 있다.
	4. 기본 형식
		public void 메소드명() throws 예외클래스1, 예외클래스2 .. {
			발생할 가능성이 있는 block 
		}
		
		public void 메소드명2() throws 예외클래스1, 예외클래스2.. {
			발생할 가능성이 있는 block
		}
		
		try {
			메소드명1();
			메소드명2();
		} catch(예외클래스1 e) {
		
		} catch(예외클래스2 e) {
		
		}
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// 위에 있는 예외만 처리되므로 하나씩 주석달면서 확인해봐야함
			call1();
			call2();
			call3();
			
		} catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
		} catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

		
		// 응용) 아래와 같은 메소드명으로 예외 위임과 위임된 예외 처리하기 
		// Class cls = Class.forName("java.lang.String1"); 
		
		try {
			findClass1();
			findClass2();
			findClass3();
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	static void call1() throws ArithmeticException {
		System.out.println(1/0);
	}
	
	static void call2() throws NullPointerException {
		String s = null;
		System.out.println(s.toLowerCase());
	}
	
	static void call3() throws ArrayIndexOutOfBoundsException {
		String str[] = {"사과"};
		System.out.println(str[2]);
	}
	
	static void findClass1() throws ClassNotFoundException {
		// 컴파일 예외(필수예외)
		Class cls = Class.forName("java.lang.String1");
	}
	static void findClass2() throws ClassNotFoundException {
		// 컴파일 예외(필수예외)
		Class cls = Class.forName("java.lang.String2");
	}
	static void findClass3() throws ClassNotFoundException {
		// 컴파일 예외(필수예외)
		Class cls = Class.forName("java.lang.String3");
	}

}
