package Java.a13_ramda;

public class A02_LambdaExp {
	
	// 4. 익명의 함수 생성
	static void flyFunciont(FlyWay fl) {
		fl.fly();
	}
	
	// 응용) 익명 함수 생성
	static void swimFunction(SwimmingWay sw) {
		sw.swim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2. 인터페이스를 상위로 실제 객체 만들기
		FlyWay fl = new FlyWay() {

			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("우리 동네를 나르다");
			}
			
		};
		
		// 3. 실제 객체 실행
		fl.fly();
		
		
		// 5. 익명 함수 생성
		// 선언된 메소드에 인터페이스를 상속받은 익명 실체 객체를 
		// 바로 넘겨주면서 재정의된 내용을 수행하게 해주는 처리 형태 
		flyFunciont(new FlyWay() {

			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("세계의 창공을 누비다(함수)");
			}
			
		});
		
		// 6-1. 람다식 표현 1단계
		// 오버라이딩된 메소드를 바로 재정의 () -> { 처리내용 }
		// {} 이 있어서 ; 있음
		flyFunciont(() -> {
			System.out.println("우주를 "
					+ "누비다(람다식1)"); 
		});
		
		// 6-2. 람다식 표현 2단계
		// {}가 없어서 ;를 쓰지않음
		flyFunciont(() -> System.out.println("넓은 바다 위 창공을 나르다(람다식2)"));
		
		
		// 응용1) SwimmingWay 인터페이스를 만들고 main() 함수에서
		// 		익명의 실제클래스를 구현해서 "호수에서 수영을 하다"라고 출력하기
		SwimmingWay sw = new SwimmingWay() {

			@Override
			public void swim() {
				// TODO Auto-generated method stub
				System.out.println("호수에서 수영을 하다");
			}
			
		}; 
		
		sw.swim();
	
		
		
		// 응용2) static void swimFunction()을 선언하고
		//		매개변수로 SwimmingWay를 받아서 처리한다.
		// 		1) 객체 생성 -> 2) 람다식1 -> 3) 람다식2
		// (3조 보내기)
		
		swimFunction(new SwimmingWay() {

			@Override
			public void swim() {
				// TODO Auto-generated method stub
				System.out.println("수영장에서 수영을 하고 있어요");
			}
			
		});
		
		swimFunction(() -> {
			System.out.println("호수에서 수영을 하고 있어요");
		});
		
		swimFunction(() -> System.out.println("바다에서 수영을 하고 있어요"));
		
	}

}

// 1. 인터페이스 선언
interface FlyWay {
	void fly();
}


// 응용) 인터페이스 선언
interface SwimmingWay{
	void swim();
}
