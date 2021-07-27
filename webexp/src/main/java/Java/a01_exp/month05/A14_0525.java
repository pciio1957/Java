package Java.a01_exp.month05;

import Java.a06_object.access.Z01_Product;

public class A14_0525 {
	
	/*
	
	#마무리문제
	1. static, final, static final 각각의 차이점을 기본예제를 통해서 기술하기
	2. Robot 클래스를 정의할 때 "기계로봇", 로봇의 종류, 로봇의 공유 전력 남은양,
		처리할 기능을 필드로 선언하여, 해당 내용을 활용하는 부분을 위 문제에 선언한 keyword의 
		기능에 맞게 처리하세요 (생성자, 메소드, 필드 선언을 적절하게 하세요)
	3. 접근제어자의 범위를 기술하고 클래스명 앞에 붙는 접근 제어자와 생성자 앞에 붙는
		접근제어자가 main()에서 어떻게 영향을 미치는지 예제를 통해 기술하기 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2번문제 
		Robot.power = 20;
		
		Robot rb1 = new Robot("비행");
		rb1.powerInfo();
		
		rb1.fly();
		rb1.fly();
		rb1.fly();
		rb1.fly();
		rb1.fly();
		rb1.fly();
		rb1.fly();
		rb1.powerInfo();
		
		
		// 3번문제
		// private : 외부클래스에서의 직접적인 접근 방지, 클래스 내부에서만 사용 가능
		// default : 접근제어자가 붙지 않은 상태로, 상단에 선언된 동일한 패키지내에서 사용 가능
		// protected : 상속관계에 있으면 패키지가 다르더라도 사용 가능
		// public : 패키지가 다르더라도 사용 가능 
		
		// 일반 클래스의 객체 선언
		Robot rob1 = new Robot("청소");
		
		// 앞의 Robot rob1는 코드로 기술된 클래스를 가르킴
		// 해당 클래스를 가진 객체가 생성되었지만 null인 상태
		Robot2 rob2 = null;
		
		// 뒤의 new Robot()는 해당 클래스의 생성자를 호출
		// 선언된 형식에 맞는 생성자의 형태로 객체가 생성됨
		rob2 = new Robot2();
		
		// 생성자명앞에 public이 아닌 private을 사용하게 되면
		// 같은 패키지내에서만 사용이 가능하다. 다른 패키지에서 해당 클래스를 사용할 수 없다
		// 다른 패키지에 있는 Z04_Product 클래스의 생성자 앞에 private가 붙어서
		// 뒤의 생성자명 부분에 빨간줄이 나타남.
		//Z01_Product z01 = new Z01_Product();
		
		Robot3 rob3 = new Robot3();
		rob3.name = "봉봉";
		System.out.println(rob3.name);
		
		// 클래스나 메소드에 접근제어자 final이 붙는 경우
		// 클래스는 더이상 상속할 수 없고
		// 메소드는 더이상 오버라이딩할 수 없다는 것을 나타낸다.
		
		

	}

}

// 1번문제
class Exp01 {
	// static final = 클래스 단위로 할당되는 변수로, 클래스와 매핑되는 변수
	// 				변경되지 않으며, 클래스 생성시 초기화해줘야 함
	static final String person = "사람";
	
	// static = 이 클래스로 객체가 생성될 때 객체들이 공유하는 메모리.
	// 			객체 생성 전에도 클래스명.변수명 으로 사용이 가능하며 
	//			다른 객체들이 모두 공유되어 사용할 수 있다.
	static String money;
	final String name;
	
	// 사람의 이름을 입력받다. 
	// final = 바뀌지 않는 값, 객체 생성시 초기화해줘야함
	public Exp01(String name) {
		super();
		this.name = name;
	}
}


// 2번문제
class Robot {
	static final String ROBOT_NAME = "기계로봇";
	final String robKind;
	static int power;
	int powerCnt;
	
	public Robot(String robKind) {
		super();
		this.robKind = robKind;
	}
	
	public void fly() {
		power--;
		powerCnt++;
		System.out.println("로봇이 전력을 소모했습니다");
	}
	
	public void powerInfo() {
		System.out.println("\n#" + ROBOT_NAME + "로봇의 전력 확인 #");
		System.out.println("[" + power + "/" + (powerCnt+power) + "]\n");
	}
}


// 3번문제 
class Robot2 {
	String name;
	
	Robot2() {
		System.out.println("private이 붙은 생성자");
	}
}

final class Robot3 {
	String name;
	
	Robot3() {
		System.out.println("클래스가 final입니다");
	}
}

//class Robo extends Robot3 {
//	
//}