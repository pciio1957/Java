package Java.a06_object.vo;

public class Person {  // -> public 의 경우 모두가 접근가능
		// 클래스에서 사용되는 필드(구성요소1) 
		// 클래스의 특정 속성을 나타낸다.
	 	// 전역변수 : 클래스 내부에 모두가 사용할 수 있는 변수 => 필드라고도 함
		public String name; // 클래스 바로 아래 생성한 것은 인스턴스변수(전역변수)ㅎ
		public int age;
		public String loc;
		// 생성자 : (구성요소2), 클래스에서는 클래스와 동일한 명칭을 가진 기능의 함수 
		public Person() { // ()가 생성자임, 여기에 클래스 생성시 나오는 변수 지정
			//생성자는 일반적으로 속성(필드)를 초기화한다. 
			//그래서 리턴값이 없다. 
			System.out.println("생성자 호출");
		}
		//Person p02 = new Person(); //Person() 부분을 지칭한다.
		
		// # 매개변수가 3개 있는 생성자 선언
		// main() 메소드에서 객체 생성시, 선언된 type과 순서를 동일하게 생성해야함
		// = new Person("홍길동", 25, "서울 신림동") (O)
		// = new Person(25, "홍길동", "서울 신림동") (x)
		
		public Person(String name, int age, String loc) {
			// 입력 매개변수와 this.필드의 속성으로 구분하여 데이터를 초기화(초기값 할당)한다.
			
			// 매개변수로 들어오는 데이터는 생성자에서만 사용될 수 있는 지역변수이므로
			// 클래스의 전역변수에 값을 지정해줘야 다른 메소드에서도 사용가능
			// 이것을 this.필드명(전역변수) = 매개변수 식으로 값 지정
			
			// 해당 클래스변수(전역변수)인 name에 매개변수로 가져온 name 값 지정
			this.name = name; 
			this.age = age;
			this.loc = loc;
			
			// Person p01 = new Person("홍길동", 25, "서울 신림동")
			// p01.name에는 "홍길동", age에는 25, loc에는 "서울 신림동"이 있다.
		}
		
		// 클래스 내에서 기능을 처리하는 메소드(구성요소3)
		public String call() {
			System.out.println("기능 메소드 호출");
			return "문자열리턴";
		}
		
	
		
		/*
		
		 # 메소드 기본 형식
		 접근제어자 리턴타입 메소드명(매개변수1, 매개변수2 ...) {
		 	프로세스 처리 
		 	return 리턴할 데이터;
		 }
		 
		 - 리턴타입 : 리턴할 데이터의 type에 맞게 처리한다
		 			만일 리턴할 데이터가 없으면 void로 선언 = 비어있다는 뜻
		 
		 # main()에서의 호출
		 Person p01 = new Person(@@, @@); 생성자는 한번만 호출
		 객체명.메소드명(); 메소드는 여러번 호출 가능
		 
		*/
			
		public void show() {
			// 현재 객체의 필드(전역속성)을 호출하는 메소드
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("사는곳 : " + loc);
		}
		
		
		
}
