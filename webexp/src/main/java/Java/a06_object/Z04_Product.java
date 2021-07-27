package Java.a06_object;

class Z04_Product {
	
	
	// 생성자에 접근제어자가 붙지 않을 때 default 임
	// default는 같은 패키지내에서만 접근이 가능하다.
	// 다른 패키지에 만들고서 다른 패키지에서 사용하려고 하면 
	// public 을 붙여줘야하나봄,,
	Z04_Product() {
		System.out.println("생성자");
	}
	
	// Z04_Product p2 = null; -> 접근제어자 class 클래스명 {} 뜻함
	// p2 = new Z04_Product(); -> class 클래스명 { 생성자() {} } 뜻함
	// 접근제어자 class 클래스명 {}	

	// 접근제어자가 붙지 않는것을 default 접근제어자 : 같은 패키지 내에서만 접근가능
	// protected : 상속하는 외부클래스에서 사용가능
}
