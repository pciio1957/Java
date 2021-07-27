package Java.a07_inherit;

public class A01_Basic {
	
	/*
	 
	 # 상속
	 java 프로그래밍의 핵심이라고 할 수 있다.
	 1. 객체를 재활용하고, 유지보수할 때, 다른 소스에 영향이 없으면서
	 	확장성있는 프로그래밍(응집성있는 프로그래밍)을 할 때 반드시 알아야 할 지식이라고 할 수 있다.
	 	- 다른 소스에 영향이 없으면서 확장성있는 프로그래밍을 하는 것은 어려움 
	 	  > 그렇기 때문에 상속에 대해 잘 알아야한다.
	 2. 상속의 기본 프로그래밍
	 	1) 상위 클래스
	 	 class Father { // 클래스라서 클래스명뒤에 () 안 넣음,, 급 헷갈림
	 	 	String shape = "통통하다";
	 	 	void running() { // 상위클래스가 가지고 있는 메소드
	 	 	  System.out.println("빠른 속도로 뛴다"); 
	 	 	}
	 	 }
	 	 class Son extends Father {
	 	 	Son클래스는 접근범위 안에서 상위 클래스의 구성요소 사용 가능
	 	 	1. 외부에서 사용하는 경우 
	 	 		Son s1 = new Son();
	 	 		s1.running();
	 	 	2. 내부구성요소로 호출
	 	 		void gogo() {
	 	 		 System.out.ptintln("모습은" + shape);
	 	 		 running();
	 	 		}
	 	 }
	 3. 상속의 종류
	 	1) 상위실제클래스 vs 하위실제클래스 상속
	 	2) 상위추상클래스 vs 하위실제클래스 상속
	 	3) 상위인터페이스 vs 하위실제클래스 상속
	 
	 4. 추상클래스
	 	1) 오버라이딩 (overriding, 재편성하다)
	 	 	하위에서 상위 메소드 재정의하는 것
	 	 	- overriding(재정의), polymorphism(다형성)
	 	2) 상속관계에서 상위에 body({}, 중괄호)가 없는 메소드를 정의하면
	 	 이 메소드는 abstract가 붙은 추상메소드가 된다.
	 	 추상메소드가 하나라도 있는 클래스는 추상클래스로 선언된다.
	 	3) 추상클래스는 단독으로 객체생성을 하지 못 한다.
	 
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Son 클래스의 경우 Father를 상속받아서 두 클래스의 메소드를 모두 사용가능
		Son s1 = new Son();
		s1.running();
		System.out.println(s1.shape);
		s1.gogo();
		
		
		// 응용1) Mother, 현명하다, Cooking() 메소드 생성
		// 응용2) Daugher : Mother을 상속받아서 필드를 재활용,
		//				   추가필드와 메소드를 처리하여 호출
		
		// 응용2
		Daughter da = new Daughter();
		// 확인을 위한 아래의 메소드들을 daughter안에서도 사용이 가능하다.
		da.cooking();
		System.out.println(da.shape); // 
		da.sing();
		
	}

}

class Father {
	String shape = "통통하다";
	
	void running() {
		System.out.println("빠른 속도로 뛴다");
	}
	
}

class Son extends Father {
	String height = "키가 크다";
	
	void gogo() {
		System.out.println("모습은" + shape);
		// running() 메소드는 위에 Father에 있는데 상속해서 사용가능
		running();
	}
	
}

// 응용1 
class Mother {
	String shape = "현명하다";
	
	void cooking() {
		System.out.println("맛있는 요리를 하신다");
	}
	
}


class Daughter extends Mother {
	String height = "키가 작다";
	
	void sing() {
		System.out.println("노래를 잘 부른다");
		// 추가한것으로 mother의 속성을 가져와서 daughter안에서도 사용가능
		System.out.println(shape);
		cooking();
		System.out.println(height);
	}
}



