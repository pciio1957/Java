package Java.a06_object;

import java.util.ArrayList;

public class A13_ObjVsObj {
	
	/*
	
	 #1:1 관계 클래스 구성하기
	 1. 클래스 안에서 외부에 있는 객체 메모리를 설정, 할당하여 활용하는 것을 말한다.
	 2. 구성 형태
	 	class Car {
	 		private String kind;
	 		private int maxSpeed;
	 		public void speedUp() {
	 			System.out.println(kind + "차의 속도를 높이다");
	 		}
	 	
	 	}
	 	
	 	class Person {
	 		private Car ownerCar; // 사람이 차를 소유하고 있다.
	 		private String name;
	 		
	 		public void buyCar(Car c) {
	 			this.ownerCar = c;
	 		}
	 		
	 		public void drivingCar() {
	 			System.out.println(name + "차를 운전하려고 하다");
	 			
	 			if(ownerCar != null) {
	 				ownerCar.speedUP();
	 			} else {
	 				System.out.println("차가 없습니다");
	 			}
	 		}
	 	}
	 	
	 	
	 #1:다 관계 클래스 구성하기
	 1. 한 클래스 안에서 여러 개의 구성요소들을 처리하는 경우를 말한다.
	 2. 내용
	 	1) 종류가 동일한 내용
	 	2) 다른 종류의 내용
	 	
	 응용2) 마트에서 여러 개의 물건 구매 
	 
	 
	 1:다
	 사이트
	 회원(여러명) Member
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 실습) 
		Person2 p1 = new Person2("홍길돔");
		p1.drivingCar();
		p1.buyCar(new Car("소렌토", 200));
		p1.drivingCar();
		
		
		
		// 응용1)
		/* woman 클래스 
		필드 : 이름, 나이 
		메소드 : info() - 여자의 이름과 나이를 출력하는 메소드

		man 클래스
		필드 : woman클래스, 이름
		메소드 : matchingCouple(woman w)
			dating() - 만나는 사람이 없습니다/데이트중입니다 (2조) */
			
		Man mn = new Man("홍길동");
		mn.dating();
		mn.matchingCouple(new Woman("김영희", 30));
		mn.dating();
		
		
		
		
		// 실습2 - 마트에서 물건 여러개 구매하기
		Mart m01 = new Mart("행복");
		m01.buy(new Product04("사과", 1200, 2));
		m01.buy(new Product04("바나나", 1200, 1));
		m01.buy(new Product04("참외", 1200, 6));
		m01.buy(new Product04("음료수", 1200, 4));
		
		int tot = m01.calcu();
		System.out.println("총액 : " + tot);
		
		
		
	}

}

class Car {
		private String kind;
		private int maxSpeed;
		
		public Car(String kind, int maxSpeed) {
			super();
			this.kind = kind;
			this.maxSpeed = maxSpeed;
		}

		public void speedUp() {
			System.out.println(kind + "차의 속도를 높이다");
		}
	}

class Person2 {
	 	// 사람이 차를 소유하고 있다.
		private Car ownerCar; // 한번에 여러가지 속성을 포함한 객체
		private String name;  // 한번에 하나의 속성만 가짐
		
		public Person2(String name) {
			super();
			this.name = name;
		}

		public void buyCar(Car c) {
			this.ownerCar = c;
		}
		
		public void drivingCar() {
			
			// name은 하나의 데이터만 사용함
			System.out.println(name + "차를 운전하려고 하다");
			
			
			// 객체는 가지고 있는 여러가지의 속성과 기능메소드를 사용함
			if(ownerCar != null) {
				ownerCar.speedUp();
			} else {
				System.out.println("차가 없습니다");
			}
		}
	}


class Woman {
	private String wName;
	private int wAge;
	
	public Woman(String wName, int wAge) {
		super();
		this.wName = wName;
		this.wAge = wAge;
	}
	
	public void info() {
		System.out.print(wName + "(" + wAge + ")");
	}
}


class Man {
	private Woman wm;
	private String mName;
	
	public Man(String mName) {
		super();
		this.mName = mName;
	}
	
	
	public void matchingCouple(Woman w) {
		this.wm = w;
		System.out.println("\n# 매칭이 이루어져 커플이 되었습니다! #");
	}
	
	public void dating() {
		
		System.out.println("\n# " + mName + "이 데이트하려고 합니다.");
		if(wm != null) {
			wm.info();
			System.out.print("와 데이트를 합니다");
		} else {
			System.out.println(mName + "이 만나는 사람이 없어요");
		}
	}
}

// 실습2 마트에서 물건 여러개 구매하기
class Product04 {
	private String name;
	private int price;
	private int cnt;
	
	public Product04(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	public int info() {
		System.out.print(name + "\t");
		System.out.print(price + "\t");
		System.out.print(cnt + "\t");
		System.out.println(price * cnt);
		
		return price * cnt; // 총계리턴
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

class Mart {
	// 마트에서 여러개의 물건 구매 
	private String name;
	private ArrayList<Product04> list;
	
	public Mart(String name) {
		super();
		// 마트명과 물건 구매리스트를 처리할 수 있게 초기화
		this.name = name;
		list = new ArrayList<Product04>();
		System.out.println("\n\n# 어서오세요 " + name + "마트에 오신걸 환영합니다~!! #");
	}
	
	public void buy(Product04 pd) {
		list.add(pd);
		System.out.println(pd.getName() + " " + 
				pd.getCnt() + "개를 장바구니에 담았습니다");
	}
	
	public int calcu() {
		System.out.println("\n" + name + "마트에서 구매한 물건들");
		
		int tot = 0;
		for(Product04 pro:list) {
			tot += pro.info();
		}
		
		return tot;
	}
	
	
}