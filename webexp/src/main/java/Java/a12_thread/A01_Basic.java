package Java.a12_thread;

public class A01_Basic {
	
	/*
	
	# Thread 프로그래밍
	1. 하나의 프로세스(프로그래밍단위) 안에서 여러 개의 쓰레드를 통해서
		한번에 여러 작업을 할 수 있게 해주는 프로그래밍 방식이다.
	2. 기본 형식
		1) Thread를 직접 상속 받아서 처리해주는 방식
			class 클래스명 extends Thread {
				void run() {
					쓰레드로 처리할 프로그래밍
				}
			}
			
			클래스명 참조변수 = new 생성자();
			참조변수.start(); -> 정의된 run()를 life cycle에 의해 호출
		2) Runnable 인터페이스를 Implements 받아서 처리해주는 방식
			class 클래스명 implements Runnable {
				void run() {
				}
			}
			
			클래스명 참조변수 = new 생성자();
			Thread t1 = new Thread(참조변수);
			t1.start();
	3. 쓰레드 설정 기본 메소드
		1) getName() : 쓰레드의 고유명을 가져온다.
			setName("저장할 이름");
		2) getPriority() : 쓰레드의 우선 순위가 설정된 내용을 가져온다.
		
		- 쓰레드 우선 순위 설정 상수
			setPriority(Thread.MAX_PRIORITY); : 쓰레드 우선 순위 설정
			Thread.MAX_PRIORITY : 최우선 쓰레드 처리
			Thread.NORM_PRIORIRY : 중간 우선 쓰레드 처리
			Thread.MIN_PRIORIRY : 최하위 우선 쓰레드 처리
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 쓰레드가 없는 프로그램 실습
		// 각각의 프로그램이 수행되어 하나의 프로그램이 다 끝난 후에 다른 프로그램이 수행된다.
		Go g1 = new Go();
		Come c1 = new Come();
		g1.run();
		c1.run();
	
		
	}

}

class Go {
	public void run() {
		for(int cnt =1; cnt <= 1000; cnt++) {
			System.out.println("gogo!! [쓰레드가 없는 프로그램]");
		}
		
	}
}

class Come {
	public void run() {
		for(int cnt =1; cnt <= 1000; cnt++) {
			System.out.println("gogo!! [쓰레드가 없는 프로그램]");
		}
	}
}
