package Java.a02_basic;

public class A05_LocalVariables {
	
	/*
	
	#모든 변수는 중괄호 블럭의 계층 구조에 맞게 사용 가능
	1. 상위 중괄호 블럭에 선언한 변수는 하위에서 사용이 가능하지만  / 상위 -> 하위 (O)
	2. 하위에 선언한 변수는 상위에서 사용을 할 수 없다.         / 하위 -> 상위 (X)
	3. 지역변수이지만, 전역변수에 할당해서 활용할 수 있다.
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Person {
	String name; // 이 클래스 내에서 다른 메소드 어디든 사용가능
	
	Person() {
		System.out.println(name);
		String name01 = "안녕";
		System.out.println(name01);
	}
	
	void call(String kind) {
		// 매개변수도 해당 {}의 지역변수로 포함되어 계층구조에서만 사용가능함ㄴ
		System.out.println(name);
		
		// 지역변수를 전역변수화해서 사용하기
		name = kind; // 전역변수에 할당해서 사용하는 방법
		
		
		int age = 25;
		
		if(true) {
			
			// 여기에서 선언한 경우 이 블럭 안에서만 사용 가능
		} 
		
		for(;;) {
			age = 30; // 같은 구조안에서 선언되서 사용 가능
		}
	}
}
