package Java.a07_inherit;

import java.util.ArrayList;

public class A05_Polymorphism {
	
	/*
	
	#다형성
	1. 같은 부모로 여러가지 다양한 형태의 하위 클래스를 선언하는 것을 말한다.
	2. 부모 타입에는 모든 자식 객체가 대입이 가능하다.
	3. 자동 타입 변환(promote) 
		부모클래스 변수 = 자식 객체 생성자
		Animal01 an1 = new Cat();
		
	#추상클래스
	1. 상위에 다양하게 처리될 기능메소드가 하위에서 재정의를 강제로 해야하고
	2. 상위에는 따로 객체를 생성할 필요가 없을 때 
	3. 추상메소드를 포함한 추상클래스를 선언한다.
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal01 an1 = new Cat();
		Animal01 an2 = new Lion();
		
		an1.eat();
		an1.move();
		
		ArrayList<Animal01> list = new ArrayList<Animal01>();
		list.add(new Cat());
		list.add(new Lion());
		list.add(new Lion());
		
		for(Animal01 a:list) {
			a.eat();
		}
		
		
		
		// 응용1) 상위클래스 Robot에 하위 Mz, Tv, Dagan
		// 		attack() 메소드를 재정의해서 
		//		1) 단일 다형성 처리
		//		2) ArrayList형 다형성 처리후 for문을 통한 기능 처리(3조)
		
		// 하나씩 객체 생성해서 메소드 호출하기
		Robot01 robo1 = new Mzing();
		Robot01 robo2 = new Tv();
		Robot01 robo3 = new Dagan();
		
		robo1.attack();
		robo2.attack();
		robo3.attack();
		
		// ArrayList로 for문 이용해서 메소드 호출하기
		ArrayList<Robot01> rlist = new ArrayList<Robot01>();
		rlist.add(new Mzing());
		rlist.add(new Tv());
		rlist.add(new Dagan());
		
		for(Robot01 r:rlist) {
			r.attack();
		}
		
		
		
		// 응용2) Robot 추상메소드 defend(), attack(), 실제메소드 fly() 추가해서
		//		처리결과를 확인하기 (2조)
		
		Robot01 robo4 = new Mzing();
		Robot01 robo5 = new Tv();
		Robot01 robo6 = new Dagan();
		
		robo4.defend();
		robo4.attack();
		robo4.fly();
		
		robo5.defend();
		robo5.attack();
		robo5.fly();
		
		robo6.defend();
		robo6.attack();
		robo6.fly();
		
		ArrayList<Robot01> rolist = new ArrayList<Robot01>();
		rolist.add(new Mzing());
		rolist.add(new Tv());
		rolist.add(new Dagan());
		
		for(Robot01 r:rolist) {
			r.defend();
			r.attack();
			r.fly();
		}
		
		
		
	}

}

abstract class Animal01 {
	// body({})가 없는 기능 메소드는 추상메소드
	// 하위에서 다양하게 처리할 기능메소드
	abstract void eat();
	
	
	void move() { // 공통되는 기능메소드 
		System.out.println("이동중입니다..... ");
	}
}

class Cat extends Animal01 {
	void eat() { System.out.println("고양이가 우유를 먹다"); }
}

class Lion extends Animal01 {
	void eat() { System.out.println("사자가 사냥감을 먹다"); }
}

abstract class Robot01 {
	// 하위 클래스 재정의 : 추상클래스는 추상메소드를
	//		상속받는 하위 클래스에서 반드시 재정의해야한다.
	abstract void defend();
	abstract void attack();
	
	void fly() {
		System.out.println("날고 있습니다......");
	}
}

class Mzing extends Robot01 {
	public void defend() {
		System.out.println("마징가제트가 방어합니다!");
	}
	
	public void attack() {
		System.out.println("마징가제트가 공격합니다!");
	}
}

class Tv extends Robot01 {
	
	public void defend() {
		System.out.println("Tv가 방어합니다!");
	}

	public void attack() {
		System.out.println("TV가 공격합니다!");
	}
}

class Dagan extends Robot01 {
	
	public void defend() {
		System.out.println("다간이 공격합니다!");
	}

	public void attack() {
		System.out.println("다간이 공격합니다!");
	}
}