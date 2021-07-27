package Java.a06_object.access;

public class Z01_Product {
	
	// 사용하려는 A16_AccessModifier랑 다른 패키지이므로
	// 사용하려면 적어도 public을 해줘야 사용가능.. 
	// 앞에 접근제어자가 없으면 default임
	private Z01_Product() {
		System.out.println("접근제어자 ");
	}
}
