package Java.a06_object;

public class A10_ParameterObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Member m1 = new Member("himan", "7777", "홍길동");
		ShoppingSite sh1 = new ShoppingSite();
		// 객체를 넘기는 방법과 데이터를 바로 넘기는 것 
		sh1.regMember(m1);
		sh1.regMember("아이디", "패스워드", "이름", "주소"); ;
		
		
		// 응용) 객체 OnLineScreen 객체의 기능 메소드 seeMovie(Person의 이름/비용) 할당
		//		@@이(가) 영화관에 가서 @@원을 지불하고 영화를 보다  
		Person1 p1 = new Person1("지수", 12000);
		OnLineScreen ons = new OnLineScreen();
		ons.seeMovie(p1);
	}
}

class ShoppingSite {
	
	// 로그인시 받는 데이터
	void login(String id, String pass) {
		System.out.println("로그인 처리 : " + id);
	}
	
	// 로그인이나 회원가입시 받는 데이터를 받는 객체를 만들어놓고
	// 그 객체를 가져와서 사용하는 것이 훨씬 효율적임
	void login(Member m) {
		
	}
	
	// 회원가입시 받는 데이터
	void regMember(String id, String pass, String name, String auth) {
		System.out.println("회원가입 처리 :" + id);
	}
	
	void regMember(Member m) {
		System.out.println("회원가입 내용 : " + m.id);
		System.out.println("회원가입 내용 : " + m.pass);
		System.out.println("회원가입 내용 : " + m.name);
	}
}

class OnLineScreen {
	
	void seeMovie(Person1 p){
		System.out.println(p.name +"가 영화관에 가서 " + p.price + "를 지불하고 영화를 보다");
	}
}

// 이미있는 클래스명이었는지 잘 안되서 1붙임 
class Person1{
	String name;
	int price;
	
	public Person1(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	void show() {
		System.out.println("출력");
	}
}