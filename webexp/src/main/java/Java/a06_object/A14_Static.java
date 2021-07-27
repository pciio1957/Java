package Java.a06_object;

public class A14_Static {

	
	/*
	 
	#정적멤버 static 활용하기
	1. 클래스에 의해서 만들어진 객체는 각각의 멤버들의 기능적인 처리와 데이터를 가지고 있다.
	2. static을 선언한 멤버는 하나의 클래스에서 만들어진 모든 객체들의 
		데이터나 기능을 공유할 수 있다.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// static 변수는 객체생성없이 사용가능한 것 확인
		Account.money2 = 5200;
		System.out.println("money2 : " + Account.money2);
		
		Account c1 = new Account(1000);
		Account c2 = new Account(2000);
		Account c3 = new Account(3000);
		
		c1.add();
		c1.add(); // c1에만 200원이 추가됨
		
		c1.show();
		c2.show();
		c3.show();
		
		// c1에만 money2를 1000으로 할당
		c1.money2 = 1000; 
		System.out.println("c1의 money2 : " + c1.money2);
		System.out.println("c2의 money2 : " + c2.money2);
		System.out.println("c3의 money2 : " + c3.money2);
		// 그런데 static이라서 c1에서도 c2, c3에서 모두 1000으로 출력됨
		// static 변수나 메소드는 공유하는 영역이기 때문에 굳이 
		// 객체의 참조변수로 쓰지않고 클래스명.static 멤버로 사용한다.
		// 그래서 객체생성 없이 사용가능함
		
		
		
		// 응용1) Bear 클래스 생성
		//		필드: name, 일반변수(먹은 빵의 갯수), static변수(전체 남은 빵의 갯수)
		// 		1) 초기 전체 빵의 갯수를 할당
		//		2) 각각 빵을 먹을때 각자의 먹은 갯수 증가, static변수의 빵의 갯수 감소
		//		3) 최종 각 곰돌이가 먹은 빵의 갯수와 남의 빵 갯수 출력
		
		// 초기 전체 빵의 갯수를 할당, 전체 공유하는 빵의 갯수
		Bear.REST_BREAD = 20;	
		System.out.println("# 곰돌이한테 주어진 빵갯수 : " + Bear.REST_BREAD);
		System.out.println("# 곰돌이가 빵을 먹어요 #");
		
		// 객체 할당해서 직접 선언해주기 
		Bear b1 = new Bear("곰돌이1");
		b1.eatBread = 5;
		b1.REST_BREAD -= 5; // 5개를 먹어서 전체 빵의 갯수 차감
		System.out.println(b1.eatBread + " 냠냠 남은건 " + b1.REST_BREAD);

		Bear b2 = new Bear("곰돌이2");
		b2.eatBread = 3;
		b2.REST_BREAD -= 3;
		System.out.println(b2.eatBread + " 냠냠 남은건 " + b2.REST_BREAD);

		Bear b3 = new Bear("곰돌이3");
		b3.eatBread = 2;
		b3.REST_BREAD -= 2;
		System.out.println(b3.eatBread + " 냠냠 남은건 " + b3.REST_BREAD);

		System.out.println("남은 빵 갯수 : " + b3.REST_BREAD);

		// 기능메소드를 이용해 차감하기
		Bear b4 = new Bear("곰돌이4");
		b4.eat();
		b4.eat();
		b4.eat();
		b4.eat();
		
		
		// 응용2) FruitBuyer 이름, 구매한 과일의 갯수, 남은 과일의 갯수 
		// 	buy()를 통해서 일반변수와 static변수를 1개씩 구매처리 후 갯수
		//	buyInfo() @@가 구매한 과일의 갯수 @@@, 현재 남은 과일 갯수는 @@
		// 		1) 초기에 FruitBuyer.REST_FRUIT_CNT = 50;
		//		2) 구매자 3명이 buy()를 통해 구매처리
		// 		3) 마지막에 buyInfo()를 통해서 남은 구매 정보 출력 (2조)
		
		// static변수는 주로 public으로 객체생성전에 클래스명.변수 형식으로 사용함
		FruitBuyer.REST_FRUIT_CNT = 50;
		
		FruitBuyer f1 = new FruitBuyer("해피");
		f1.buy();
		f1.buy();
		f1.buy();
		f1.buy();
		f1.buy();
		f1.buyInfo();
		
		FruitBuyer f2 = new FruitBuyer("조이");
		f2.buy();
		f2.buy();
		f2.buy();
		f2.buyInfo();
		
		
		
		
	}

}

class Account {
	int money;
	static int money2;
	
	public Account(int m) {
		this.money = m;
	}
	
	public void add() {
		money += 100;
	}
	
	public void show() {
		System.out.println("현 계좌의 금액: " + money);
	}
}

class Bear {
	String name;
	int eatBread;
	static int REST_BREAD;
	
	public Bear(String name) {
		super();
		this.name = name;
	}
	
	public void eat() {
		eatBread++;
		REST_BREAD--;
		System.out.println(name + "빵의 정보");
		System.out.println(eatBread + " : " + REST_BREAD);
	}
	
	
}


class FruitBuyer {
	String name;
	int buyCnt; 
	static int REST_FRUIT_CNT;
	
	public FruitBuyer(String name) {
		super();
		this.name = name;
	}
	
	public void buy() {
		buyCnt++;
		REST_FRUIT_CNT--;	
	}
	
	public void buyInfo() {
		System.out.println(name + "의 구매횟수 : " + buyCnt);
		System.out.println("남은 과일의 갯수 : " + REST_FRUIT_CNT);
	}
	
}