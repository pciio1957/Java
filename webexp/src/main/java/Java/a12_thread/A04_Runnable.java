package Java.a12_thread;

public class A04_Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2) Runnable을 implements 하는 방법
		FoodEater fe1 = new FoodEater("딸기"); // 3가지 경우
		Thread t1 = new Thread(fe1);
		t1.start();
		FoodEater fe2 = new FoodEater("오렌지");
		Thread t2 = new Thread(fe2);
		t2.start();
		FoodEater fe3 = new FoodEater("수박");
		Thread t3 = new Thread(fe3);
		t3.start();
		
		// 이해도 60%..
		// 응용) LunchMenu를 통해서 점심 메뉴로 먹은 횟수를 1~20회까지 출력하고
		//		Runnable인터페이스를 통해 처리된 것을 수행하기. 메뉴 종류는 3가지임 
		// (2조 보내기, 수업/과제 속도 및 이해도 표시)
		
		LunchMenu lmenu1 = new LunchMenu("볶음밥");
		Thread th1 = new Thread(lmenu1);
		th1.start();
		LunchMenu lmenu2 = new LunchMenu("비빔밥");
		Thread th2 = new Thread(lmenu2);
		th2.start();
		LunchMenu lmenu3 = new LunchMenu("햄버거");
		Thread th3 = new Thread(lmenu3);
		th3.start();
		
	}

}

class FoodEater implements Runnable {
	private String kind; // 필드를 작성하고 생성자 자동완성
	

	public FoodEater(String kind) {
		super();
		this.kind = kind;
	}

	// 인터페이스를 상속받고서 클래스이름에 빨간줄이 뜨면 왼쪽 아이콘을 눌러 메소드 추가
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i <= 10; i++) {
			System.out.println(kind + "를 " + i + "개 먹다");
		}
	}
}

class LunchMenu implements Runnable {
	private String menu;

	public LunchMenu(String menu) {
		super();
		this.menu = menu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i <20; i++) {
			System.out.println(i + "일차 오늘의 메뉴는 " + menu);
		}
	}
}