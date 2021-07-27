package Java.a06_object;

public class A15_StaticFinal {
	
	/*
	
	#final 
	1. 클래스의 일반 필드명 앞에 붙으면, 초기데이터를 할당한 이후에 변경이 불가능하게 한다.
	2. final만 붙으면 객체마다 변경할 수 없는 필드를 가지고 있게 한다.
	
	#static final 
	1. 객체의 공유 메모리이지만 값이 지정된 클래스의 상수를 말한다.
	
	
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person04 p1 = new Person04("홍길동");
		Person04 p2 = new Person04("김길동");
		p1.getAge();
		p1.getAge();
		p1.getAge();
		p1.getAge();
		p1.getAge();
		p1.getAge();

		p2.getAge();
		p2.getAge();
		p2.getAge();
		p2.getAge(); // 다 증가함
		
		//p1.name = "마길동"; // name이 final이라서 할당안됨
		// 갹체 단위로 한번 할당이 된것은 변경이 불가능하다. (객체 생성시 준 "홍길동")
		
		//Person04.KIND = "동물"; // KIND에 할당 안됨..
		// 클래스 단위로 한번 할당된 것은 변경이 불가능하다.
		
		
		// 응용) Animal 클래스, final 상수로 동물의 종류, static final로 동물 설정
		//		일반변수로 먹이의 종류
		// 		eatFood() : 동물인 [사자]가 먹이 @@@을 먹다
		// 		setFood() : 먹이의 종류

		Animal ani1 = new Animal("돼지");
		ani1.eatFood();
		
		ani1.setFood("사과");
		ani1.eatFood();
		ani1.setFood("바나나");
		ani1.eatFood();
		
		
	}

}

class Person04 {
	// static final은 생성하면서 초기화해야함
	static final String KIND = "사람"; // 클래스로 한번 할당 -> 변경불가
	final String name; // 객체 생성시 할당 -> 변경 불가
	private int age;
	static int EARCH_RESOURCE; // 객체 공유 메모리 
	
	public Person04(String name) {
		this.name = name;
	}
	
	//	name이 final이라서 set메소드생성이 안됨
	public void getAge() {
		age++;
		System.out.println(name + "의 나이를 먹다! 현재 나이 : " + age);
	}
}



class Animal {
	// 이 클래스에 매핑되는 특정 변수는 static final로 선언해서 사용
	// 클래스의 변경되지 않는 변수를 말함, 동물 클래스라 설정한 "동물"은 변하지 않음
	static final String ANIMAL = "동물"; 
	// 객체 단위 변경되지 않는 상수
	final String kind; // 처음에 작성하고 빨간줄 뜨는게 초기화를 안해줘서 난것임
	String eat = ""; // 이름 feed
	
	public Animal(String kind) {
		super();
		this.kind = kind;
	}
	
	public void setFood(String e) {
		eat = e;
		System.out.println(kind + "의 먹이로 [" + e + "]를 줍니다");
	}
	
	public void eatFood() {
		if(eat.equals("")) {
			System.out.println("먹이가 없습니다... ");
		} else {
			System.out.println(ANIMAL + "인 " + kind + "가 먹이 " + eat + "를 먹다" );
		}
	}
}