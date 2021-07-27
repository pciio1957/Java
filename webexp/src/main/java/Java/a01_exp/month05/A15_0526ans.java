package Java.a01_exp.month05;

import java.util.ArrayList;

public class A15_0526ans {
	
	/*
	
	#마무리문제
	1. 클래스 선언에서 toString()의 역할을 기술하고, super.toString()을 선언했을 때
		어떤 기능이 처리되는지 설명하기
		toString() : 모든 객체는 패키지명@주소값으로 참조변수만 선언해도 해당 내용에 
					대한 부분을 출력하게 정의해놓았다. 
				해당 메소드의 내용을 재정의(오버라이딩)하면 해당 내용을 참조변수 출력만으로
					확인할 수 있다. 
				super.toString()을 호출하면 Object에서 선언한 내용인 
					패키지명.클래스명@주소를 가져올 수 있다.
					
	2. 상속관계에서 super 키워드를 사용하는 경우 예제와 함께 기술하기
		1) 상속관계 재정의시 메소드가 있을 때 상위 메소드와 현재 메소드를 구분하기 위해서
			사용한다.
			class Father {
				public void gogo() {
					System.out.println("가다");
				}
			}
			class Son extends Father {
				public void gogo() {
					System.out.println("빠르게!");
					super.gogo(); // 부모클래스의 gogo()를 호출함
				}
			}
			
		2) 상위에 선언한 사용자정의 생성자를 하위 클래스에서 반드시 호출해야 
			하는 경우 super(매개변수값) 형태로 첫번째 생성자 선언, 첫번째 라인에 선언한다.
			class Father {
				private String name;
				Father (String n) {
					this.name = n;
				}
				public void gogo() {
					System.out.println("가다");
				}
			}
			// 상위클래스가 생성자를 호출했으면 상속받은 하위클래스도 선언해줘야함
			class Son extends Father {
				Son(String n) {
					super(name + " 아들");
				}
				public void gogo() {
					System.out.println("빠르게!");
					super.gogo(); // 부모클래스의 gogo()를 호출함
				}
			}
			
	3. Worker 추상 클래스를 상속받은 FireMan, PoliceMan, Programmer를 다형성으로 처리하되,
		생성자에 super("경찰과") 활용, 공통메소드는 출근/퇴근하다, 재정의 메소드는 일하다를 처리하기
		1:1관계, 1:다 관계를 설정하여 처리하기
		아래에서 클래스 생성해서 함 
	
	4. 오라클의 설치과정과 설치에 필요한 내용을 기술하기
		1) 클라이언트(client) <--> 서버(DBserver) : 어제 설치한것
		 	1-1) oracle xe 11g 설치
				- client : sqlplus 지원
				- server 지원
			1-2) eclipse에서 지원하는 plugin : DBeaver(client 툴)
		2) 설치과정
			2-1) oracle 사이트
				server
				xe : 교육용 연습용 버전으로 setup.exe 설치/삭제 가능
			2-2) 비밀번호
			 	관리자(admin) - system : 계정 생성과 여러가지 권한 부여 권한을 가지고 있다.
			 		1111
			 		system/1111
			 		conn system/1111
			2-3) 연습용 계정과 연습용 DB데이터   
			    C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin                                                                                                                                                                                                                                                        
				커맨드창(cmd)에 뜨는 기본폴더 위치에 scott.sql 파일을 복사
				비밀번호는 해당 파일에서 정보의 대문자에서 소문자로 2군데 변경(tiger)
				CONNECT SCOTT/tiger
				cmd 창에서 sqlplus로 기본 client 서버에 접속
				admin계정인 system/1111 접속하여 현재 폴더에 있는 scott.sql 파일을
					@(run:실행) scott.sql을 통해서 계정 생성과 샘플 테이블 생성, 데이터 입력

			2-4) jdbc driver 설정
				jdbc driver : db 서버에 접속할 때 필요한 프로그램 모듈을
							자바로 만들어서 처리한 class의 압축판
							각 DB 서버회사에서는 이러한 프로그램을 지원한다. @@.jar
							ex) oracle, mssql, mysql 
			 		1) 활용
			 			client 툴: DBeaver, sql developer 
			 			프로그래밍에 설정 (반드시해야함!!)
			 		2) 위치
			 			C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\jdbc5.jar
			 		3) client 툴인 DBeaver에서 사용하기위한 설정
			 		
			2-5) client툴 DBeaver 설치
					elipse 상단 메뉴 help -> eclipse marketplace 들어가서
						DBeaver 검색 -> DBeaver 21.0.5 install 
						0) 툴 설치 후 open perspective 설정 (DBeaver 찾아서 선택)
						1) 상단 메뉴에 데이터베이스 -> Driver 관리자 설정
							-> oracle 선택 -> edit 버튼 클릭 -> 2번째 탭 librarise에서 jdbc 드라이버 선택
							위의 ojdbc 경로로 가서 ojdbc6.jar 파일 설정
						2) 프로그램 연결 : 상단 메뉴 데이터베이스 -> 새 데이터베이스 연결 
			 				username/pw 변경, xe 설정
			 				host : ip - localhost (내 컴퓨터가 호스트가됨, 현재 서버가 설치되어있음)
			 						port - 1521
			 						sid - xe 
			 						계정 - scott
			 						비번 - tiger 
			 						test 연결 확인 (셋팅즈 아래 test Connetion) 
			 			3) persoective dbeaver를 선택한 후 왼쪽 목록에 연결된 DB 정보를 확인
			 				
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1번문제
		Object o = new Object();
		System.out.println(o);
		System.out.println(o.toString());
		Person333 p3 = new Person333();
		System.out.println(p3);
		
		
		// 3번문제 - 1:1 관계
		// 상위 = 하위
		System.out.println("# 1:1 관계 처리 #");
		Worker333 w1 = new FireMan333();
		w1.goWork();
		w1.working();
		w1.goHome();
		
		// 3번문제 - 1:다 관계
		System.out.println("# 1:다 관계 처리 #");
		ArrayList<Worker333> wlist = new ArrayList<Worker333>();
		for(Worker333 w:wlist) {
			w.goWork();
			w.working();
			w.goHome();
		}
		
	}

}

// 1번문제
class Person333 {
	public String toString() {
		return super.toString() + "재정의한 내용 리턴";
	}
}


// 3번문제
abstract class Worker333 {
	private String kind;

	public Worker333(String kind) {
		super();
		this.kind = kind;
	}
	
	public abstract void working();
	// 일단 메소드로 선언을 해놓고 body가 없으면 빨간줄 뜨는데 거기서 추상메소드로 만들고
	// 클래스에 이제 빨간줄 뜨면 거기서 또 추상으로 바꿔도 됨 (맨날 쓰느라 고생쓰)
	// 1. 추상메소드가 1개라도 있으면 추상클래스로 선언해야함
	// 2. 추상메소드는 상속받는 하위 클래스에서 반드시 재정의해야한다 (안하면 컴파일에러)
	
	public void goWork() {
		System.out.println(kind + "출근하다");
	}
	
	public void goHome() {
		System.out.println(kind + "퇴근하다");
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
}

class FireMan333 extends Worker333 {

	public FireMan333() {
		super("소방관");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(getKind() + "이 불을 끄다!");
	}
}

class PoliceMan333 extends Worker333 {

	public PoliceMan333() {
		super("경찰관");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(getKind() + "이 치안을 유지하다!");
	}
}

class Programmer333 extends Worker333 {

	public Programmer333() {
		super("개발자");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(getKind() + "가 소프트웨어를 개발하다!");
	}
}
