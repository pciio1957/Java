package Java.a11_io;

import Java.z01_vo.Book;
import Java.z01_vo.Food;

public class A01_ArrayFor {
	
	/*
	
	# 배열과 forEach 구문
	1. 배열은 단위 데이터를 묶어서 모아 놓은 데이터이다.
		int nums[] = {10, 15, 20};
	2. 객체가 모여서 배열을 이룰 수 있다.
		Person[] parry = {new Person(), 
						  new Person(), 
						  new Person()};
	3. 상위 객체를 배열하고, 상속받은 하위 객체를 
		폴리모피즘에 의해서 할당할 수 있다.
		Flyway[] fl = {new CountyFly{}, 
			new WorldFly(), new SpaceFly()};
	4. 배열은 for문을 이용해서 for(단위객체 : 배열객체)로 
		반복문을 이용해서 효과적으로 처리할 수 있다.
	5. index와 .length()를 이용해서 다양한 배열의 데이터를 가져와서
		활용할 수 있다.
		
		
	# 다형성에 의한 배열 설정
	1. 상위 = 하위
		상위배열 = {하위1, 하위2, 하위};
		상위배열[0].재정의메소드() : 효과적인 처리를 할 수 있다.
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1. 배열을 한데 모아서 사용 -> 1단계 활용방법
		int prices[] = {3000, 4000, 5000};
		String menus[] = {"사과", "바나나", "딸기"};
		// index는 0부터 시작하기 때문에 0을 초기값으로 설정
		// index는 배열의 길이(.length)보다 작기떄문에 idx<prices.length로
		// 반복 구문에서 활용하여 데이터를 처리할 수 있다.
		
		for(int idx = 0; idx < prices.length; idx++) {
			System.out.println(menus[idx] + "\t");
			System.out.println(prices[idx] + "\n");
		}
		
		
		// 응용) 좋아하는 음식(foods)와 가격, 음식점위치를 설정해서
		// 		for문을 통해서 출력하기 
		
		String[] foods = {"짜장면", "탕수육", "짬뽕"};
		int fprice[] = {5000, 15000, 7000};
		String fmap[] = {"서울", "경기", "인천"};
		
		for(int i=0; i<3; i++) {
			System.out.println(foods[i] + "\t");
			System.out.println(fprice[i] + "\t");
			System.out.println(fmap[i] + "\n");
		}
		
		
		//2. 객체가 모여서 배열이 된다.
		//Import 단축키 = ctrl + shift + o (자동 import)
		Food[] foObjArry = {new Food("짜장면", 6000, "동대문"),
							new Food("간짜장", 12000, "노량진"),
							new Food("짬뽕", 8000, "강릉")
		};
 		
		// forEach 구문 - 이런식으로 데이터를 뽑아내는 것
		// (단위객체: 객체형배열)  단위객체.속성메소드()
		for(Food f:foObjArry) {
			System.out.println(f.getfname());
			System.out.println(f.getfprice());
			System.out.println(f.getfLoc()+"\n");
		}
		
		
		
		// 응용) Book : 도서명, 가격, 저자의 VO 객체를 만들고
		//		배열로 선언한 후, forEach 구문을 이용해서 출력하기
		Book[] bObjecArry = {new Book("자바의 정석1", 18000, "남궁성"),
							new Book("혼자 공부하는 자바", 20000, "신용권"),
							new Book("경선식 영단어", 12000, "경선식") 				
		};
		
		for(Book b: bObjecArry) {
			System.out.println(b.getbName());
			System.out.println(b.getbPrice());
			System.out.println(b.getbWritter()+"\n");
		}
		
		
		
		// 3. 인터페이스 다형성을 이용한 객체배열 사용
		// 상위 클래스 배열 선언 = {하위 객체()1... }
		FlyWay[] flyways = {new WorldFly(),
							new CountryFly(),
							new SpaceFly()};
		
		// 인터페이스 참조명과 메소드명은 같지만 하위 실제 클래스가 다르고 
		// 재정의된 내용을 다루기때문에 다른 출력을 가지고 있다.
		for(FlyWay fl:flyways) {
			fl.fly();
		}
		
		int ranIdx = (int) (Math.random() * flyways.length);
		System.out.println("\n# 임의의 객체 메소드 호출 #\n");
		flyways[ranIdx].fly(); 
		
		
		
		// 응용) 인터페이스 Weapon 선언, attack()은 추상메소드 선언
		// 		LaserBeam, Rocket, DoubleAttack는 상속하여 다형성배열 처리
		Weapon[] wep = {new LaserBeam(),
						new Rocket(),
						new DoubleAttack()};
		
		System.out.println("\n# 나의 공격을 받아랏 #");
		for(Weapon w:wep) {
			w.attack();
		}
		
	}

}

interface FlyWay {
	void fly();
}

class WorldFly implements FlyWay {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("우리 동네를 나르다");
	}
	
}
class CountryFly implements FlyWay {
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("세계의 창공을 누비다");
	}
	
}
class SpaceFly implements FlyWay {
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("우주 여행을 하다");
	}
	
}

interface Weapon {
	void attack();
}

class LaserBeam implements Weapon {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("레이저빔~!! ");
	}
}
class Rocket implements Weapon {
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("로켓펀치~!! ");
	}
}
class DoubleAttack implements Weapon {
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("더블어택~!! ");
	}
}