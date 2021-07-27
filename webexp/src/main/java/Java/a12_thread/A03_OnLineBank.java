package Java.a12_thread;

public class A03_OnLineBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankUser u1 = new BankUser("홍길동");
		BankUser u2 = new BankUser("김길동");
		BankUser u3 = new BankUser("신길동");
		BankUser u4 = new BankUser("오길동");
		BankUser u5 = new BankUser("마길동");
		
		
		// 쓰레드의 우선 순위 설정
		u5.setPriority(Thread.MAX_PRIORITY);
		u1.setPriority(Thread.MIN_PRIORITY);
		// u5에 할당된 마길동의 프로세스가 제일 먼저 실행됨
		
		u1.start();
		u2.start();
		u3.start();
		u4.start();
		u5.start();
		
		
		// 응용) GameUser로 쓰레드로 생성(사용자이름)하고 기본예제와 같이 만든다
		// 게임사이트접속, 대화하기, 게임실행하기, 게임로그아웃 배열로 쓰레드를 5개를 만들어 처리
		// (1조 보내기)
		GameUser user1 = new GameUser("한조");
		GameUser user2 = new GameUser("송하나");
		GameUser user3 = new GameUser("파라");
		GameUser user4 = new GameUser("메이");
		user1.start();
		user2.start();
		user3.start();
		user4.start();

	}

}

// 4단계로 프로그램이 돌아감
class BankUser extends Thread {
		private String name;
		
		public BankUser(String name) {
			super();
			this.name = name;
		}

		public void run() {
			String[] proc = {"로그인하다","계좌를 확인하다", 
					"입금을 하다", "로그아웃하다"};
			
			for(int i=0; i < proc.length; i ++) {
				System.out.println(i + 1 + "]" + name + "  " + proc[i]);
			}
		}
}


// 응용
class GameUser extends Thread {
	private String user;
	
	public GameUser(String user) {
		super();
		this.user = user;
	}

	// 그냥 만드는 메소드가 아니라 쓰레드를 시작하면 실행되는 메소드
	public void run() {
		String[] pr = {"게임사이트에 접속했습니다", "채팅을 칩니다", "게임을 실행하셨습니다",
				"게임을 로그아웃하셨습니다"};
		
		for(int i=0; i<pr.length; i++) {
			System.out.println(i + " - " + user + "님이 " + pr[i]);
		}
		
	}
}