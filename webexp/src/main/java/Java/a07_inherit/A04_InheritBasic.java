package Java.a07_inherit;

public class A04_InheritBasic {
	
	/*
	
	#명시적인 부모생성자 호출
	1. 부모 객체를 생성할 때 부모 생성자 하위에 선택하여 호출
		1) super(매개값) 
			- 매개값과 동일한 타입, 갯수, 순서가 맞는 부모 클래스의 생성자 호출
		2) 부모 생성자가 없다면 컴파일 오류 발생
		3) 반드시 자식 생성자의 첫 줄에 위치
			생성자() {
				super(); // 첫줄에 위치해야 함
			}
			
			
	#메소드 재정의(overriding, 오버라이딩)
	1. 부모 클래스의 상속 메소드를 수정해서 자식 클래스에서 재정의하는 것을 말한다.
	2. 메소드 재정의 조건
		1) 부모 클래스의 메소드와 동일한 이름으로 사용해야 한다
		2) 접근 제한을 더 강하게 재정의는 불가하다.
			- 상위 메소드가 public을 default나 private로 재정의 불가
			- 상위 메소드가 default이면 public으로 재정의 가능
		3) 새로운 예외 throws는 불가능하다
	3. 부모 메소드와 구분하여 사용
		1) 자식 클래스에서 재정의되기 전 부모 메소드를 호출할 때
			super.부모메소드() 형식으로 선언한다.
		

	#final
	1. 필드 : 상수로 사용
	2. final 클래스명 : 하위 상속클래스 선언 불가
	3. final 메소드명 : 자식클래스에서 재정의 불가 
	
			
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpiderMan m1 = new SpiderMan("홍길동");
		// 이름은 변수로 바로 입력해버림
		//m1.name = "홍길동(스파이더맨)"; 
		m1.eat();
		m1.jump();
		m1.isSpider = true;
		m1.fireweb();
		
		
		// 응용) Animal 종류선언, 달리다(), 먹다() 
		//		상속받은 Tiger 클래스는 사냥하다() 추가하여 처리(5조)
		Tiger t1 = new Tiger("호랑");
		//t1.kind = "호랑이";
		t1.run();
		t1.eat();
		
		t1.meal = "토끼";
		t1.attack();
		
		
		// 응용) 생성자를 통해서 kind 설정, eat() 재정의해서 고기를 먹다 추가 (4조)
		
	}

}

class Person {
	String name;
	
	// 상위 클래스 생성자를 통해서 할당 
	Person (String n) {
		this.name = n;
	}
	
	public void eat() {
		System.out.println(name + " 먹다!!");
	}
	
	public void jump() {
		System.out.println(name + " 뛰다!!");
	}
}

// 위의 Person 클래스를 상속받음
class SpiderMan extends Person {
	boolean isSpider;
	
	SpiderMan (String n) {
		super("스파이더맨(" + n + ")"); // 상위에 선언된 생성자를 반드시 호출해야한다. 
	}
	
	// 상위에 있는 메소드를 재정의함 
	public void jump() {
		super.jump();
		// 현재 재정의한 클래스와 구분하여 super.메소드로 처리
		System.out.println("건물 사이를 뛰면서 날고 있다!");
	}
	
	public void fireweb() {
		System.out.println(name + " 거미줄을 발사하다!");
	}
}

class Animal {
	String kind;
	
	Animal(String k) {
		kind = k;
	}
	
	public void run() {
		System.out.println(kind + "가 달리고 있습니다");
	}
	
	public void eat() {
		System.out.println(kind + "가 먹고있습니다");
	}
	
}

class Tiger extends Animal {
	String meal;
	
	Tiger (String k) {
		super(k);
	}
	
	public void attack() {
		System.out.println(kind + "가 " + meal + "를 사냥하고 있습니다!");
	}
	
	public void eat() {
		System.out.println(kind + "가 고기를 먹고있어요! " );
	}
}