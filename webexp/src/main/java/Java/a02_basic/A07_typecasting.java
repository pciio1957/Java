package Java.a02_basic;

import java.util.ArrayList;

public class A07_typecasting {
	
	/*
	
	#데이터 유형의 변환
	1. 기본 데이터 유형
		작은 데이터 유형 -> 큰 데이터 (promote)
		큰 데이터 유형 -> 작은 데이터 (casting)
	2. 상속관계에서의 다형성
		하위 -> 상위객체로 사용될 때 (promote)
		상위 -> 하위객체로 사용될 때 (casting) -> generic
		
		
	#generic
	1. 상위 객체로 할당할 때, 상위객체에서 하위 특정한 유형을 지정하여
		다시 하위에서 사용할 떄 casting 없이 처리하는 것을 말한다
	2. 예시 (<>를 말하는것인지..?)
		// 기본 ArrayList 할당하는 방법
	 	ArrayList list = new ArrayList(); 
		// Object타입으로 객체를 할당하는 방법
		ArrayList<Object> list = new ArrayList() <Object>;
		list.ad(new Product());
		// 위 객체들은 Object의 하위 객체이므로 할당가능
		// 그런데 가져와서 사용할 때는 Object이므로 casting을 해야한다
		Product p = (Product) list.get(0);
		
		선언시 사용하게 될 객체 유형으로 generic형식으로 선언하면 
		해당 객체 type만 들어오기때문에 casting이 필요없다.
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(new Product());
		plist.add(new Product());
		
		Product p2 = plist.get(0);
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// promote
		int num01 = 25;
		double num02 = num01;
		System.out.println("promote : " + num02);
		
		// casting - 명시적으로 선언을 해줘야함
		double num03 = 243.242;
		int num04 = (int) num03;
		System.out.println("casting : " + num04);

		// 상속에서의 promote, 하위 객체가 상위로 할당
		Father f = new Son();
		
		// 최상위 객체에 할당, 하위 객체가 최상위 객체에 할당
		Object ob = f;
		
		
		// 상위 객체에 할당된 객체를 하위로 사용할 때는 명시적 선언(casting)
		// 그래야 속성값을 접근할 수 있다.
		Son s01 = (Son)f;
		System.out.println(s01.name); // 하위 객체인 son의 필드값 사용
		
		// 상위 객체에 할당된 객체가 다시 하위 객체의
		// 속성을 사용할 때는 casting을 해야 속성값에 접근할 수 있다
		Son s02 = (Son) ob;
		System.out.println(s02.name);
		
		
		// 응용1) int형에서 byte형으로 typecasting시 데이터의 유실 확인
		// 응용2) 상속관계 Mother, Daughter를 설정하고 Daughter에 기능메소드
		//		show()를 딸입니다를 출력처리, promote와 typecasting을 통해서
		//		메소드를 확인할 수 있도록 프로그래밍하기 (2조 보내기)
		
		
		// 응용1
		int nb1 = 25;
		byte nb2 = (byte) nb1;
		int nb3 = 128;
		byte nb4 = (byte) nb3; // 128부터 할당 X, 데이터 유실
		
		System.out.println("int -> byte의 데이터 유실 확인 : " + nb2);
		System.out.println("int -> byte의 데이터 유실 확인 : " + nb4);
		
		
		// 응용2
		Mother mt = new Daughter(); // promote
		Daughter dh = (Daughter) mt; // casting
		dh.show();
		
		Object o2 = mt;
		Daughter dh2 = (Daughter) o2;
		dh2.show();
		
		
		// generic 예제
		// ArrayList 타입을 정해서 처리
		Object o = new Product1(); // 상위객체에서 하위객체로 casting이 가능해서 됨
		ArrayList<Product1> list = new ArrayList<Product1>();
		list.add(new Product1());
		list.add(new Product1());
		list.add(new Product1());
		// typecasting 없이 사용되는 것이 가능한 게 generic이다. (명시적으로 하지 않아도 X..)??
		Product1 p1 = list.get(0);
		
		
		
		// 응용3) Student1 클래스 선언으로 generic을 통한 할당 처리와
		//		ArrayList 중에서 2번째 단일 객체를 가져오는 처리를 하세요 (3조 제출)
		ArrayList<Student1> sList = new ArrayList<Student1>();
		sList.add(new Student1());
		sList.add(new Student1());
		sList.add(new Student1());
		Student1 s1 = sList.get(1); // 2번째 단일 객체?..
		
		// generic은 Object 유형으로 설정되어 있기때문에 casting에 의해 속성에 접근가능
		
		 
		
	}

}

// generic 응용
class Student1 {}

// generic 예제
class Product1 {}

// 예제를 위한 간단예쩨
class Father {	}

class Son extends Father { 
	String name = "아들";
}


// 응용2
class Mother { }

class Daughter extends Mother {
	void show() {
		System.out.println("딸입니다");
	}
}

