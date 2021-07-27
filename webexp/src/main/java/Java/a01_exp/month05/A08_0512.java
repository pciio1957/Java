package Java.a01_exp.month05;

public class A08_0512 {
	
	/*
	 0512 마무리문제
	 1. Thread 프로그램 실행 형식 2가지를 코드로 기술하기 
	 2. 아래 내용을 thread를 상속한 프로그램으로 만들어보기
	 	1단계) ShoppingBuyer : 구매자를 통해 물건 10개를 구매 처리
	 	2단계) ShoppingBuyer : 생성자로 구매자/물건/가격/갯수를 받아서
	 		해당 갯수만큼 반복문을 처리하는 프로그램 구현하기
	 3. Thread의 이름과 우선순위 기능 메소드 기술하기
	 4. 아래 내용을 Runnable 인터페이스를 처리한 프로그램으로 만들어보기
	 	1단계) SeeingMovie : 배열로된 영화 목록(5개)을 보고 처리하는 프로그램
	 5. Weapon 인터페이스 하위의 익명객체를 선언하고 처리하는 방식을
	 	수업 중 진행했던 4단계에 의해 선언해 각종 무기에 공격 방법을 선언 처리하기
	 	1단계) 익명객체 생성
	 	2단계) 함수선언 할당
	 	3단계) 람다식1 선언 호출
	 	4단계) 람다식2 선언 호출
	 
	 
	*/
	
	// 5-3. 함수 선언
	public static void attackWay(Weapon w) {
		w.attack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1번문제 - extends Thread
		System.out.println("# 1. Thread의 프로그램 실행 형식 #");
		FlyWay1 fl1 = new FlyWay1();
		fl1.start();
		
		// 1번문제 - implements Runnable 
		FlyWay2 fl2 = new FlyWay2();
		Thread t1 = new Thread(fl2);
		t1.start();
		
		// 2번문제
		ShoppingBuyer sb = new ShoppingBuyer("책");
		sb.setPriority(Thread.MAX_PRIORITY);
		sb.start();
		
		ShoppingBuyer sbu = new ShoppingBuyer("홍길동", "공책", 1000, 5);
		sbu.start();
		
		// 3번문제
		/*
		 Thread의 우선순위 기능 메소드
		 	1) Thread.MAX_PRIORITY : 최우선 순서 쓰레드
		 	2) Thread.NORM_PRIORITY : 중간 순서 쓰레드
		 	3) Thread.MIN_PRIORITY : 최하위 순서 쓰레드 
		*/
		
		// 4번문제 
		SeeingMovie sm = new SeeingMovie("지은");
		Thread t2 = new Thread(sm);
		t2.start();
		
		// 더 간결하게
		Thread tr1 = new Thread(new SeeingMovie("지수"));
		tr1.start();
		
		// 5번문제
		// 5-2. 익명객체 생성
		Weapon wp = new Weapon() {

			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("\n# 5. 적을 공격하는 방법 #");
				System.out.println("레이저빔을 날리다");
			}
			
		};
		
		wp.attack();
		
		// 5-4. 함수 할당
		attackWay(new Weapon () {

			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("로켓펀치를 날리다");
			}
			
		});
		
		// 5-5. 람다식1 
		attackWay(() -> {
			System.out.println("더블로켓펀치를 날리다");
		});
		
		// 5-6. 람다식2
		attackWay(() -> System.out.println("로켓미사일을 날리다"));
		
		
	}

}

//1번문제
class FlyWay1 extends Thread {
	public void run() {
		System.out.println("Thread 상속");
	}
}

class FlyWay2 implements Runnable {
	public void run() {
		System.out.println("Runnable 클래스 상속");
	}
}

// 2번문제
class ShoppingBuyer extends Thread {
	private String name;
	private String buyer;
	private int price;
	private int cnt;

	public ShoppingBuyer(String name, String buyer, int price, int cnt) {
		super();
		this.name = name;
		this.buyer = buyer;
		this.price = price;
		this.cnt = cnt;
	}

	public ShoppingBuyer(String name) {
		super();
		this.name = name;
	}

	public void run() {
		System.out.println("\n# 2. 물건 구매 프로그램 #");
		
		if(buyer==null) {
			for(int i = 1; i <= 10;i++) {
				System.out.println(name + "을 " + i + "개 구매했습니다");
			}
		} else {
			System.out.println("구매자\t물건명\t가격\t갯수");
			for(int x=1; x <= cnt; x++) {
				System.out.print(buyer + "\t");
				System.out.print(name + "\t");
				System.out.print(price + "\t");
				System.out.println(cnt);
			}
		}
		
	}	
}

class SeeingMovie implements Runnable {
	private String name;
	
	// 생성자로 돌리는 객체의 이름?을 받아와서 명시화해줌 -> 어떻게 돌아가는지 확인
	public SeeingMovie(String name) {
		super();
		this.name = name;
	}

	String[] movie = {"스파이더맨","앤트맨", "아이언맨", "배트맨", "데드풀"};
	
	public void run() {
		System.out.println("\n# 4. 영화 시청 목록 #");
		for(int i = 0; i <movie.length;i++) {
			System.out.println(name + "이(가) " +  movie[i] + "을 감상했습니다");
		}
		
	}
}

// 5-1. 인터페이스 객체 선언
interface Weapon {
	void attack();
}