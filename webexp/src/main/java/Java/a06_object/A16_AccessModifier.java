package Java.a06_object;

public class A16_AccessModifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 먼저 객체 생성하는 선언문 작성
		// 2. 이 선언문을 앞뒤로 나눔. 
		Z04_Product p1 = null;
		
		// 3. 나뉜 선언문을 두고 Z04 클래스로 가서 생성자를
		//	private 설정하니까 외부 패키지에서 접근이 불가능해짐
		// 	뒤의 생성자 쓰는 곳에서 빨간줄로 에러남 
		// p1 = new 
		// Z04_Product();
	}

}
