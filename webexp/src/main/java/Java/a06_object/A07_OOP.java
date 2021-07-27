package Java.a06_object;

public class A07_OOP {
	
	/*
	
	#객체지향 프로그래밍
	1. OOP :  Object Oriented Programming
		1) 부품 객체를 먼저 만들고 이것들을 하나씩 조립해서 
			완성하는 프로그램을 만드는 기법을 말한다.
			
	2. 객체(Object)란?
		1) 물리적으로 존재하는 것 : 자동차, 책, 사람
		2) 추상적인 것 : 회사, 날짜 중 자신의 속성과 동작을 가지고 
			프로그램적으로 의미가 있는 것
		3) 객체는 필드(속성값)과 메소드(동적)으로 구성된 자바 객체로
			모델링이 가능한 것을 말한다.
			
			
	#클래스의 구성요소
	1. 필드
		필드의 종류
		1) 객체가 사용할 고유 데이터
		2) 객체가 가져야 할 상태데이터
		3) 그외 객체 안에 또 호출되는 부품 데이터 
		
	2. 생성자
		1) 객체를 생성할때 사용하는 클래스명과 같은 함수
		2) default 생성자 : 생성자는 아무것도 선언하지 않으면 클래스명과 동일한 
						매개변수없는 생성자가 내부적으로 호출되어 사용할 수 있다.
		3) 사용자가 생성자를 선언하는 순간, default 생성자는 사라지게 된다.
		4) 생성자는 this(매개변수 데이터)로 생성자를 호출할 수 있다.
		
		*생성자 오버로딩(over loading) 
			생성자가 이름이 동일하지만 여러가지 선언할 수 있는 규칙을 말한다.
			메소드도 오버로딩이 적용된다. 
				1) 매개변수의 개수가 다른 경우
				2) 갯수가 같더라도 타입이 다르게 선언된 경우
				3) 갯수가 같고 타입이 같더라도 순서가 다른 경우에 선언이 가능한 것을 말한다.
				
					
	3. 메소드
		1) 객체 생성 후 기능적인 처리를 하는 함수를 말한다.
		2) 구성요소로 리턴할 타입, 메소드명, 매개변수, 실행 처리할 내용 등이 있다.
		3) 리턴 타입은 해당 기능 메소드를 호출했을 때 호출한 곳에 전달할 데이터
			유형을 선언하고 실제 데이터를 전달하는 것을 말한다
			= 리턴값이 없을때는 void로 선언하고 리턴처리를 하지않는다.
		4) 메소드는 여러 타입의 매개변수를 통해서 데이터를 입력받는다.
			기본유형, 객체
			cf) 객체를 매개변수로 선언하여 처리하면 여러 개의 기본 유형을 선언하는 것보다
			 	효율적이고 간편하게 선언하고 전달될 수 있는 특징을 가진다.
			 	- void call(String name, int age, String loc) {} // 데이터형 선언
			 	- void call(Person p) {}  // 객체 선언
		5) 메소드는 입력값과 리턴사이에 특정한 프로세스를 처리한다.
			반복적이고 재활용해야하는 내용을 기능 메소드를 통해서 처리할 수 있다.


	
	#this
	1. 현재 클래스 안에 있는 구성요소(필드/생성자/메소드)에 사용됨
	2. 생성자나 메소드안에서
		this.필드 : 동일한 이름의 지역변수와 구분되도록 함 => javaScript에서는 반드시 사용해야함
		this() : 현재 클래스에 다른 매개변수로 있는 생성자를 호출할 때
			cf) 상속관계에서의 super() : 상위클래스의 구성요소(생성자)를 호출할 때
		this.메소드명() : 상속관계에서 오버라이딩시에 현재 클래스의 메소드와
					상위 클래스의 메소드(super.메소드명) 를 구분할 때 사용
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Z02_Bus b1 = new Z02_Bus();
		b1.no = 7900;
		b1.from = "서울";
		b1.to = "수원";
		System.out.println("속성값 확인:" + b1.no);
		System.out.println("속성값 확인:" + b1.from);
		System.out.println("속성값 확인:" + b1.to);
		
		
		// 응용) Z03_Computer 클래스를 선언하고 속성으로 제조사, cpu, ram의 속성
		//		선언하고 해당 main()안에서 객체(2개)를 생성하고 필드를 할당하고 출력하기(2조)
		// 해당 클래스의 default 생성자에 의해 호출
		// 가지고 있는 필드의 값 할당 및 호출 처리
		z03_Computer com = new z03_Computer();
		com.made = "삼성";
		com.cpu = "i7";
		com.ram = 8;
		
		System.out.println("Computer의 made 할당값" + com.made);
		System.out.println("Computer의 cpu 할당값" + com.cpu );
		System.out.println("Computer의 ram 할당값" + com.ram);

		
		// 생성자 실습
		// 생성자를 선언하는 순간 default생성자는 사라진다.
		Person p1 = new Person();
		Person p2 = new Person("홍길동");
		
		
		// 응용) Note 클래스를 선언하고 default 생성자 호출, 매개변수가 1개 있는 생성자 선언 후 가격할당
		//		매개변수 없는 생성자 선언, 매개변수가 2개 있는 생성자 선언 후 가격, 갯수 할당
		// 		처리결과를 출력하세요
		
		// default 생성자, 생성자 아무것도 생성하지 않고 선언
		Note n1 = new Note();
		
		// 매개변수가 없는 생성자
		Note n2 = new Note();
		
		// 매개변수가 있는 생성자
		Note n3 = new Note(1200);
		System.out.println("n3의 가격 : " + n3.price);

		Note n4 = new Note(1800, 5);
		System.out.println("n4의 가격 : " + n4.price);
		System.out.println("n4의 가격 : " + n4.cnt);
		
		
		
	}

}

// 생성자 오버로딩 규칙 확인
class Member {
	String id;
	String pass;
	String name;
	String auth;
	
	public Member() {
		super();
	}

	
	public Member(String id) {
		super();
		this.id = id;
	}
	
	// 1) 위의 생성자랑 갯수가 다른 경우로 선언가능(오버로딩 규칙1)
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	// 2) 갯수가 같더라도 타입이 다른 경우 (오버로딩 규칙2)
	public Member(String id, int pass) {
		super();
		this.id = id;
	}
	
	// 3) 갯수가 같고 타입이 같더라도 순서가 다른 경우 (오버로딩 규칙3)
	public Member(int pass, String id) {
		this(id); // 이렇게 되면 매개변수가 1개 있는 생성자를 불러옴
		this.id = id;
	}
	
	public Member(String id, String pass, String name) {
		// 선언된 생성자를 활용하여 데이터 처리를 효과적으로 할 수 있다
		this(id,pass); 
		
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	
	
}

class Person {
	String name;
	
	Person() {
		System.out.println("매개변수가 없는 생성자 호출");
	}
	Person(String s) {
		this();
		name = s;
		System.out.println("문자열 매개변수가 있는 생성자 '" + name + "' 호출");
		
	}
}


class Note {
	int price;
	int cnt;
	
	Note() {
		System.out.println("매개변수가 없는 생성자 호출");
	}
	
	Note(int p){
		price = p;
		System.out.println("매개변수가 1개 있는 생성자 [" + price + "] 호출");
	}
	
	Note(int p, int c) {
		price = p;
		cnt = c;
		System.out.println("매개변수가 2개 있는 생성자 [" + price + ", " + cnt + "] 호출");
	}
}
