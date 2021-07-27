package Java.a01_exp.month05;

import java.util.ArrayList;

public class A15_0526 {
	
	/*
	
	#마무리문제
	1. 클래스 선언에서 toString()의 역할을 기술하고, super.toString()을 선언했을 때
		어떤 기능이 처리되는지 설명하기
	2. 상속관계에서 super 키워드를 사용하는 경우 예제와 함께 기술하기
	3. Worker 추상 클래스를 상속받은 FireMan, PoliceMan, Programmer를 다형성으로 처리하되,
		생성자에 super("경찰과") 활용, 공통메소드는 출근/퇴근하다, 재정의 메소드는 일하다를 처리하기
		1:1관계, 1:다 관계를 설정하여 처리하기
	4. 오라클의 설치과정과 설치에 필요한 내용을 기술하기
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1번문제
		// toString() : 클래스에서 toString() 메소드를 선언하면 해당 클래스의 
		//				필드값을 포함한 문자열을 리턴한다
		// super.toString(); : 부모 클래스의 toString()메소드를 실행하는 것. 
		//				현재 클래스는 상속받은 부모 클래스가 없기떄문에 아무일도 안 일어난다.
		System.out.println("# 1. toString의 기능 #");
		Per01 p1 = new Per01("둘리");
		System.out.println(p1.toString());
		
		
		// 2번문제
		// 생성자에서의 super() : 상위 클래스의 생성자에 하위클래스의 매개값 할당
		// 하위 클래스의 생성자에서 super() 사용, 상위클래스의 필드값으로 지정됨
		System.out.println("\n# 2. super의 기능 #");
		Per01 p2 = new Battman("배트");
		p2.eat();
		
		// 메소드에서의 super() : 상위 클래스를 상속받아서 상위 클래스의 메소드 호출
		// 하위클래스의 객체를 생성 후 하위클래스의 메소드인 fly() 호출
		// fly()안에는 super.eat() 이 있는데 상위 클래스의 eat() 메소드 호출임
		Battman b1 = new Battman("매트");
		b1.fly();
		
		
		// 3번문제 - 1:1 관계 설정
		System.out.println("\n# 3. 다형성 설정 #");
		FireMan8 fm = new FireMan8("소방관");
		fm.goWork();
		fm.work();
		fm.goHome();
		
		PoliceMan8 pm = new PoliceMan8("경찰관");
		pm.goWork();
		pm.work();
		pm.goHome();
		
		Programmer8 pg = new Programmer8("개발자");
		pg.goWork();
		pg.work();
		pg.goHome();
		
		
		// 3번문제 - 1:다 관계 설정
		ArrayList<Worker8> wlist = new ArrayList<Worker8>();
		wlist.add(new FireMan8("소방순찰"));
		wlist.add(new PoliceMan8("순경"));
		wlist.add(new Programmer8("보안기술자"));
		wlist.add(new Programmer8("디자이너"));
		
		for(Worker8 w:wlist) {
			w.work();
		}
		
		
		// 4번문제
		/*
		1. 인터넷에서 "oracle xe 11g" 검색해서 11버전으로 다운로드
			다운로드하고 설치하는데 이때 관리자 비밀번호는 1111 로 해야 관리가 쉽다
		2. 이클립스에서 오라클을 사용할 수 있도록 플러그인 프로그램 설치
			help -> marketPlace -> DBeaver 21.0.5 -> debug만 체크해서 인스톨
			제대로 설치하면 이클립스를 다시 시작하게 된다.
			다시 시작된 이클립스에서 DBeaver를 사용하기 위해서는 오른쪽 중앙쪽 
			Open Perspective 버튼 클릭 -> DBeaver를 추가하면 -> 오른쪽에 DBeaver 버튼 생성
		3. DB를 열기위해서 scott.sql 파일을 가져온다.
		 	- 경로 : C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin
		 	위의 경로를 따라가면 scott.sql 파일이 있는데 복사해서 
		 	- 경로 : C:\Users\pciio 
		 	내 사용자 폴더로 가서 해당 파일을 붙여넣기 해준다.
		4. scott.sql 파일의 수정을 해야한다
			내 사용자 폴더에 넣었던 파일을 오른쪽마우스를 눌러 메모장에 연결한다
			파일의 내용 중 TIGER -> tiger 로 바꿔주어야 사용이 편리하다.
		5. cmd에서 sql 연결이 되는지 확인한다
			cmd창을 열어서 경로가 내 사용자 폴더인지 확인하고
			dir /w 을 입력해서 내 사용자 폴더 안에 scott.sql 파일이 있는지 확인
			있는지 확인했다면 sqlplus를 입력한 뒤 username : system / password : 1111 입력
			@scott.sql을 눌러 sql을 열고 conn scott/tiger; 를 입력해서 DB서버와 연결한다.
		6. JDBC 드라이버를 설치한다.
			- 경로 : C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 
			위 경로를 따라가서 ojdbc6.jar 파일을 찾는다.
			그리고 이클립스의 web-inf\lib 안에 드래그해서 해당 파일을 넣어준다.
		7. 이클립스에 DB연결을 한다
			아까 설치했던 DBeaver를 켜고 새 데이터베이스 연결을 누른다 (콘센트에 +모양)
			오라클 -> 셋팅화면에서 database는 xe -> username : scott / pw : tiger 입력
			-> Edit Driver Settings에 들어가서 라이브러리로 들어간다 
			-> 목록을 지우고 아까 찾았던 ojdbc6.jar 의 경로로 가 해당 파일을 추가한다
			-> find class로 jdbcDriver를 선택하고 확인
			-> 연결한다... 
		
		*/
	}

}

// 1번문제
class Per01 {
	private String name;

	public Per01(String name) {
		super();
		this.name = name;
	}
	
	public void eat() {
		System.out.println(name + "는 밥을 맛있게 먹는다");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		//super.toString();
		return "Per01 [name=" + name + "]";
	}	
}

// 2번문제
class Battman extends Per01 {
	
	public Battman(String n) {
		// 상위클래스인 Per01을 상속받은 하위클래스 Battman 클래스에서
		// 입력받은 n값을 부모클래스인 Per01의 생성자에 대신 값을 입력한다. 
		super(n);
	}
	
	public void fly() {
		// 부모클래스 Per01의 메소드인 eat()을 실행시킨다.
		// super의 경우 첫줄에 적어줘야한다. 
		super.eat();
		System.out.println("하늘을 날고 있습니다");
	}
}


// 3번문제 - 상위(부모) 클래스
abstract class Worker8 {
	String name; 
	
	public Worker8(String n) {
		name = n;
	}
	
	abstract void work();
	
	public void goWork() {
		System.out.println(name + "이 출근합니다!");
	}
	
	public void goHome() {
		System.out.println(name + "이 퇴근합니다!");
	}
}

// 하위클래스 
class FireMan8 extends Worker8 {
	
	public FireMan8(String n) {
		super("경찰과 " + n);
	}

	@Override
	void work() { // 재정의 메소드
		// TODO Auto-generated method stub
		System.out.println(name + "이 불을 끕니다");
	}
}

// 하위클래스 
class PoliceMan8 extends Worker8 {
	
	public PoliceMan8(String n) {
		super("경찰과 " + n);
	}

	@Override
	void work() {
		// TODO Auto-generated method stub
		System.out.println(name + "이 도둑을 잡습니다");
	}
}

// 하위클래스
class Programmer8 extends Worker8 {
	
	public Programmer8(String n) {
		super("경찰과 " + n);
	}

	@Override
	void work() {
		// TODO Auto-generated method stub
		System.out.println(name + "이 개발을 합니다");
	}	
}