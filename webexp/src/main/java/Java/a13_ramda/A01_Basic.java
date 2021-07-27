package Java.a13_ramda;

public class A01_Basic {

	/*
	 
	# 람다식 표현
	1. 메소드(함수)에 대한 표현방식을 보다 간편하게 화살표형식으로 표현하는 것을 말한다.
	2. 주로 메소드의 익명함수로 바로 사용할 때 활용된다.
	
	// 상위인터페이스 = 하위 인터페이스명으로 하위객체를 익명으로 선언
	// 선언한 내용을 호출하는 것이 아니라 프로그래밍 메모리를 로딩하는
	// main()에서 익명으로 선언하여 바로 사용하게 처리하는 형태를 말한다
	
	
	*/
	
	static void call(String print) {
		System.out.println("출력내용 : " + print);
	}
	
	// 인터페이스 FunctionInterface1를 매개변수로 가져와서 추상메소드를 호출
	// 기능 메소드가 매개변수로 인터페이스를 가져온다
	public static void useFImethod(FunctionInterface1 fi) {
		fi.methodA();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 일반적인 클래스를 객체로 만들어 사용하는 방법
		Show s1 = new RealObj();
		s1.call01();
		
		// 2. 람다식으로 객체를 선언해 함수를 사용하는 방법
		// Func~ 클래스는 인터페이스라서 재정의해줘야하는 메소드가 있어서
		// new Func~ 하면 오류가 남 ()안에서 {}를 열고 
		// 왼쪽 아이콘을 보면 재정의해야하는 메소드를 자동완성해줌
		useFImethod(new FunctionInterface1() {

			@Override
			public void methodA() {
				// TODO Auto-generated method stub
				System.out.println("안녕하세요, 익명의 재정의 메소드입니다.");
			}
			
		});
		
		// 람다식으로 표현 1 : {} 블럭을 통해서 여러 라인 처리
		useFImethod(() -> {
			System.out.println("람다식1으로 익명인터페이스 호출");
		});
		
		// 람다식으로 표현 2 : 바로 한라인의 내용을 처리 
		useFImethod (() -> {
			System.out.println("람다식2으로 익명인터페이스 호출");
		});
		
		Show s2 = new Show() {

			@Override
			public void call01() {
				// TODO Auto-generated method stub
				System.out.println("인터페이스의 익명 실체 객체 메소드");
			}
			
		};
	}

}

// 인터페이스 생성
interface Show {
	void call01 (); // 추상메소드 선언
}

class RealObj implements Show {

	@Override
	public void call01() {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요!");
	}
	
}

interface FunctionInterface1 {
	void methodA();
}