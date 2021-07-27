package Java.a07_inherit;

public class A02_AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 추상클래스는 단독으로 객체를 생성해서 사용하지 못한다.
		// Vehicle v1 = new Vehicle();
		// 2. 하위클래스만 생성한다.
		//Vehicle v1 = new Vehicle();
		
		Car c1 = new Car();
		c1.driving();
		c1.speedup();
		// 3. 다형성 : 상위클래스를 참조로 하위 클래스 생성이 가능하다.
		Vehicle v2 = new Trucker();
		v2.driving();
		v2.speedup();
		
		
		// 응용) Worker라는 추상클래스에 
		// 실제메소드 goHome() goWork() 퇴근/출근하다
		// 추상메소드 working()
		// PoliceMan 상속받은 실제 클래스 working() 치안을 유지하다
		// FireMan 상속받은 실제 클래스 working() 불을 끄다.
		
		
		// 응용, 다형성/폴리모피즘
		Worker w1 = new PoliceMan();
		w1.goWork();
		w1.working();
		w1.goHome();
		
		Worker w2 = new FireMan();
		w2.goWork();
		w2.working();
		w2.goHome();
		
		// 추상클래스가 단독으로 클래스를 생성하는 것은 안된다.
		// 추상클래스의 다형성 특징으로 상위 클래스를 참조해서 하위클래스를 생성해야한다.
		// 참조하는상위클래스 생성할클래스명 = new 상속받은하위클래스();
		// Worker w3 = new Worker();
		
	}

}

abstract class Vehicle {
	
	void driving() {
		System.out.println("운행합니다~");
	}
	
	// 1. 추상메소드가 1개라도 있으면 추상클래스가 된다.
	// 2. 추상클래스는 단독으로 객체 생성을 하지 못 한다.
	abstract void speedup();
}

// 3. 추상클래스를 상속받은 하위 클래스는 추상메소드를 반드시 ☆재정의☆해서 사용해야한다.
class Car extends Vehicle {
	
	// 클래스이름에 빨간줄이 있다가 추상메소드를 재정의하기 위해 선언하니까 사라짐
	void speedup() { 
	System.out.println("자동차는 속도가 20km/h씩 증가한다");	
	}
}

class Trucker extends Vehicle {
	
	void speedup() {
		System.out.println("자동차는 속도가 10km/h씩 증가한다");
	}
}



abstract class Worker {
	
	// 1. 공통적인 메소드
	void goHome() {
		System.out.println("퇴근이다!! ");
	}
	
	void goWork() {
		System.out.println("출근이라니 ");
	}
	
	// 2. 추상메소드
	abstract void working();
}

class PoliceMan extends Worker {
	// 하위에 있는 클래스는 상위에 있는 추상메소드를 반드시 재정의해야한다.
	void working() {
		System.out.println("치안을 유지하는 일을 합니다");
	}
}

class FireMan extends Worker {
	
	void working() {
		System.out.println("불을 끄는 일을 합니다");
	}
}
