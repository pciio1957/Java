package Java.a06_object.vo;

import Java.a06_object.Z01_Person;

public class A05_AcessModifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Z01_Person p01 = new Z01_Person();
		
		// Z01_Person내에서 사용가능하던 출력문들 중 name만 사용 불가능
		// 접근제어자인 private은 외부 클래스에서 호출해서 사용할 수 없다.
		//System.out.println(p01.name); (name에 빨간줄)
		// adress는 상단에 선언한 패키지명이 같기 때문에 접근 가능
		//System.out.println(p01.address);
		// ingerit는 상속관계가 없지만 같은 패키지이기에 접근 가능
		//System.out.println(p01.ingerit);
		// announce는 public으로 모든 곳에서 접근 가능
		System.out.println(p01.announce);
		
		// ann~ 까지 A04_AccessModifier에서 그대로 복붙해옴
		// 이번에는 address/ ingerit 사용 불가능
		// 상속관계가 없고, 같은 패키지 내가 아니므로 사용이 불가능
		// -> public만 사용이 가능

	}

}
