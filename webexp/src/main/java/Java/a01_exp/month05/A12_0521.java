package Java.a01_exp.month05;

import java.util.Scanner;

public class A12_0521 {
	
	/*
	
	마무리문제
	1. 클래스와 객체의 차이점을 예제 코드와 함께 기술하기
	2. default 생성자가 무엇인지 기술하고 Calcu 클래스를 선언 후 생성자로 두개의 값을 받은 뒤
	 	객체를 4개 생성하고 사칙연산 처리하는 내용 기술
	3. 생성자/메소드의 overloading이 무엇인지 기본 예제와 함께 설명하기
	4. 생성자안에서 this()를 사용하는 목적을 기술하고, Product 클래스 안에서
		물건명, 가격, 갯수를 생성자의 매개변수가 없을때, 1개/2개/3개가 있도록 선언하고
		this()를 활용하여 선언된 생성자를 사용하기
	5. 메소드의 기본형식을 선언하고 primitive 데이터유형, 배열, 객체를 리턴하도록 선언하고
		main()메소드에서 해당 내용을 출력 처리하는 예제 만들기
	6. 메소드의 매개변수를 통해 기본유형의 변수할당과 객체형의 할당의 차이점을 기술하기
	7. OnLineLibrary 클래스를 선언하고 기능 메소드를 login(Member m), lent(Book b)를 처리하기
		login() : 입력된 id와 pass가 goodman/7777일때 로그인 성공, 그 외는 로그인실패로 문자열리턴 처리
		lent() : 반납기한 @@인 도서 @@@ 대출 처리로 출력하기
	8. MathExp 클래스에 기능메소드 gugu(구구단의 출력할 단수), totAll(1부터 합산할 마지막수 입력),
		withComMavel(내가 입력한 주사위수) : 내가 입력한 주사위 수와 컴퓨터가 랜덤처리한 주사위수로 승/패/무 출력
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1번문제
		/*
		클래스 : 프로그래머가 실행할 프로세스를 적은 코드를 말하며 도안에 해당한다.
			연관이 있는 변수와 메소드의 집합이다. 
		객체 : 작성한 코드, 클래스를 기반으로 구현되는 것으로 도안을 바탕으로 만들어지는 대상이다.
		*/
		
		// 작성한 클래스로 객체를 만듬
		System.out.println("\n# 1. 클래스 확인 #");
		TestObj tj = new TestObj();
		tj.testOut();
		
		
		// 2번문제
		// default 생성자 : 클래스를 생성한 뒤 동일한 클래스명을 가진 생성자를 선언하지 않았을때
		//				클래스 내부에서 자동으로 생성해주는 생성자이다. 매개변수가 없다.
		System.out.println("\n# 2. 계산기 #");
		Calcu cal = new Calcu(10, 5);
		cal.plus();
		cal.minus();
		cal.multi();
		cal.division();
		
		
		// 3번문제
		// OverLoading : 같은 이름을 가진 생성자나 메소드를 효율적으로 사용하기 위해
		//				상황에 맞게 매개변수의 타입이나 순서를 다르게 사용하는 것을 말한다.
		System.out.println("\n# 3. 메소드에서의 오버로딩 확인 #");
		TestOver tr = new TestOver();
		tr.show(); // 1) 매개변수의 갯수가 다른 경우
		tr.show(1000);  // 2) 갯수가 같더라도 타입이 다른 경우
		tr.show("김길동"); 
		tr.show("홍길동", 1000); // 3) 갯수와 타입이 같지만 순서가 다른 경우
		tr.show(50000, "신길동"); 
		// 오버로딩은 메소드뿐만 아니라 생성자에서도 사용된다. 
		
		
		// 4번문제
		/* 생성자 안에서 this()를 사용하는 이유
		  	- this() : 현재 클래스에 다른 매개변수로 있는 생성자를 호출할 때 사용한다.
		  	
		   그외의 사용하는 이유
		  	- this는 클래스의 구성요소(필드/생성자/메소드)에서 사용할 수 있다.
		 	- this.필드(속성)명 : 메소드나 생성자안에서 동일한 이름의 지역변수가 있을 경우 
						클래스변수와 구분하기 위해 사용된다. 
			- this.메소드명 : 상속관계에서 현재 클래스의 메소드와 상위 클래스의 메소드를 구분하기 위해 사용한다.
		*/
		System.out.println("\n# 4. 생성자에서의 this() 확인 #");
		Product0521 pd1 = new Product0521("홍길동");
		Product0521 pd2 = new Product0521("신길동", 12000, 5);
		
		
		// 5번문제
		// 메소드의 기본형식
		// 리턴타입 메소드명(매개변수 매개변수명..) { return 리턴할 데이터; } 
		// 리턴타입이 void일 경우 리턴하는 데이터가 없으므로 return 사용X
		System.out.println("\n # 5. 메소드의 리턴 #");
		TestOver tv = new TestOver();
		System.out.println("int형 리턴 : " + tv.intNum(5));
		System.out.println("double형 리턴 : " + tv.douNum(13.9));
		
		int[] c = tv.arrNum(2);
		System.out.println("배열형 리턴 [0]값 : " +  c[0]);
		System.out.println("배열형 리턴 [1]값 : " + c[1]);
		System.out.println("배열형 리턴 [2]값 : " + c[2]);
		
		Calcu cu = tv.objNum(3, 3);
		System.out.println("Calcu형 리턴 더하기 메소드 결과 : " + cu.plus());
		
		
		// 6번문제
		/*
			메소드의 매개변수를 통해서 데이터를 전달받아서 사용할 수 있다.
			하지만 전달받아서 사용할 데이터의 수가 늘어나면 보기에도 안좋고 재사용성이 떨어지기때문에
			사용할 데이터를 모은 객체를 만들어서 그 객체를 매개변수로 받아, 객체의 구성요소를 활용하는 것이 훨씬 효율적이다.
		*/
		
		
		// 7번문제
		System.out.println("\n # 7. 도서관홈페이지 #");
		Member mb1 = new Member("himan", "8888");
		OnLineLibrary ol1 = new OnLineLibrary();
		ol1.login(mb1);
		
		Member mb2 = new Member("goodman", "7777");
		OnLineLibrary ol2 = new OnLineLibrary();
		ol2.login(mb2);
		
		Book bk = new Book("자바의 정석", 7);
		OnLineLibrary ol3 = new OnLineLibrary();
		ol3.lent(bk);
		
		
		// 8번문제
		MathExp me = new MathExp();
		me.gugu(2);
		me.totAll(10);
		me.withComMavel(5);
	}

}

// 1번문제 - 클래스 
class TestObj {
	void testOut() {
		System.out.println("1번용 클래스");
	}
}


// 2번문제
class Calcu {
	int num1; 
	int num2;
	
	// 생성자를 선언하지 않은 상태라면 default 생성자가 생겨 일을 하지만
	// 사용자가 생성자를 선언하면 default 생성자는 사라진다.
	public Calcu(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	int plus() {
		return num1+num2;
	}
	
	int minus() {
		return num1-num2;
	}
	
	int multi() {
		return num1*num2;
	}
	
	int division() {
		return num1/num2;
	}
}


// 3번문제
class TestOver {
	
	// 메소드의 오버로딩
	// 1) 매개변수의 갯수가 다른 경우
	void show() {
		System.out.println("매개변수 없는 show");
	}
	
	// 2) 갯수가 같더라도 타입이 다른 경우
	void show(int num1) {
		System.out.println("매개변수 있는 show : " + num1);
	}
	
	void show(String str1) {
		System.out.println("매개변수 있는 show : " + str1);
	}
	
	// 3) 갯수가 같고 타입도 같지만 순서가 다른 경우
	void show(int num1, String str1) {
		System.out.println("매개변수 있는 show : " + num1 + str1);
	}
	
	void show(String str1, int num2) {
		System.out.println("매개변수 있는 show : " + str1 + num2);
	}
	
	// 5번문제 
	int intNum(int n) { // int타입
		return n+n;
	}
	
	double douNum(double n) { // double타입
		return n-0.8;
	}
	
	int[] arrNum(int n) { // 배열타입
		return new int[] {n, n+1, n+2};
	}
	
	
	Calcu objNum(int n1, int n2) { // 객체타입
		return new Calcu(n1, n2);
	}
}


// 4번문제
class Product0521 {
	String name;
	int price;
	int cnt;
	
	Product0521() {
		System.out.println("생성자에 매개변수가 없습니다!");
	}

	// 매개변수가 1개 있는 생성자에 this()를 사용해서 매개변수가 없는 생성자 호출
	public Product0521(String name) {
		this();
		this.name = name;
		System.out.println("생성자에 매개변수가 1개입니다!");
	}

	public Product0521(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		System.out.println("생성자에 매개변수가 2개입니다!");
	}

	// 매개변수가 3개 있는 생성자에서 매개변수가 2개있는 생성자를 호출
	public Product0521(String name, int price, int cnt) {
		this("홍길동", 12000);
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		System.out.println("생성자에 매개변수가 3개입니다!");
	}
}

// 7번문제
class OnLineLibrary {
	
	void login(Member m) {
		
		System.out.println("[로그인 중....]");
		if(m.id.equals("goodman") && m.pass.equals("7777")) {
			System.out.println(" ID : " + m.id);
			System.out.println(" PASSWORD : " + m.pass);	
			System.out.println(" 로그인되었습니다\n");
		} else {
			System.out.println(" 로그인에 실패했습니다\n");
		}
	}
	
	void lent(Book b) {
		System.out.println("[책 대출 중....]");
		System.out.println(" 반납기한 " + b.period + "일인 도서 " + b.bName + " 대출 완료");		
	}
}

class Member {
	String id;
	String pass;
	
	
	
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}

class Book {
	String bName;
	int period;
	
	
	public Book(String bName, int period) {
		super();
		this.bName = bName;
		this.period = period;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
}


// 8번문제
class MathExp {
	
	void gugu(int n) {
		System.out.println("\n[구구단을 외자!구구단을 외자!]");
		for(int i = 1; i <= n; i++) {
			System.out.println("구구단 " + i + "단 시작!");
			for(int j = 1; j <= 9; j++) {
				System.out.println(" " + i + " * " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}
	
	void totAll(int n) {
		int sum = 0;
		
		System.out.println("\n[총합구하기]");
		System.out.println(" 마지막수 : " + n );
		System.out.print(" 더하는 값 : ");
		for(int i = 1; i <= n; i++) {
			sum += i;
			System.out.print(i + " ");
		}
		System.out.println("\n 총합 : " + sum );
	}
	
	void withComMavel(int n) {
		int ranMavel = (int) (Math.random() * 6 + 1);
		
		System.out.println("\n[주사위 굴리기~!] ");
		System.out.println(" 사용자 주사위값 : " + n);
		System.out.println(" 컴퓨터 주사위값 : " + ranMavel);
		
		
		// 주사위의 값이 1~6이 아닌경우도 if문으로 판별쓰하면 좋음 
		// -> 내가 입력을 받아서 그럼 
		
		if(ranMavel > n) {
			System.out.println(" 컴퓨터가 이겼습니다!");
		} else if(ranMavel < n) {
			System.out.println(" 사용자가 이겼습니다!");
		} else {
			System.out.println(" 비겼습니다!");
		}
	}
}