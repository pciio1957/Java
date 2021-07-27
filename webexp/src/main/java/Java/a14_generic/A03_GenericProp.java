package Java.a14_generic;

import Java.a06_object.vo.Product;
import Java.z01_vo.Bus;
import Java.z01_vo.Car;

public class A03_GenericProp {
	
	/*
	#generic type의 사용
	1. 클래스를 선언할 때 타입 피라미터를 사용한다.
		class 클래스명<T>
		어떤 type을 속성으로 사용할 것인지 선언
		해당 T(타입)으로 클래스의 속성으로 지정처리
		class Box<T> {
			private T t; // 해당 Type으로 된 객체를 속성으로 선언
			public T get() { // 해당 type으로 된 객체를 리턴
				return t;
			}
			public void set(T t) { // 해당 type으로 된 객체를 할당
				this.t = t;
			}
	
	2. 컴파일시 타입 파라미터가 구체적인 클래스로 변경처리된다.
		Box<String> box = new Box<String>();
		box.set("반가워요"); 
		String str1 = box.get();
		// 타입캐스팅 없이 사용이 가능하다. 
		위에 선언된 클래스가 해당 타입에 맞게 변환되어 사용할 수 있다. 
		class Box<String> {
			private String t; // 해당 Type으로 된 객체를 속성으로 선언
			public String get() { // 해당 type으로 된 객체를 리턴
				return t;
			}
			public void set(String t) { // 해당 type으로 된 객체를 할당
				this.t = t;
			}
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Box3<String> box3 = new Box3<String>();
		box3.set("사과(문자열)");
		System.out.println("리턴된 값 : " + box3.get());
		
		
		// 타입캐스팅없이 사용가능
		Box3<Product> box4 = new Box3<Product>();
		box4.set(new Product("바나나", 3000, 2));
		Product prod = box4.get();
		System.out.println("리턴한 객체");
		System.out.println(prod.getName());
		System.out.println(prod.getPrice());
		System.out.println(prod.getCnt());
		
		// 응용) Vehicle<T>로 선언하고 Car, Bus 등 가변적으로 속성을
		//		설정하여 해당 속성의 값을 출력하기 (4조)
		Vehicle<Car> car = new Vehicle<Car>();
		car.set(new Car());
		Car c1 = car.get();
		Vehicle<Bus> bus = new Vehicle<Bus>();
		bus.set(new Bus());
		Bus b1 = bus.get();
	}

}

class Box3<T> {
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t = t;
	}
}

class Vehicle<T> {
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t = t;
	}
}
