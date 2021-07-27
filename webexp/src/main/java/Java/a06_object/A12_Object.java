package Java.a06_object;

import java.util.ArrayList;

public class A12_Object {
	
	
	/*
	
	#클래스의 구성요소 통합 연습
	1. 각각의 구성요소의 기능에 따른 통합 연습 
		1) 필드 : 객체의 공통 데이터 저장 처리
		2) 생성자 : 필드의 초기화 처리
		3) 메소드 : 기능적인 처리
		
		 
	2. 연습예제
		1) 물건 클래스를 선언하되 사용되는 필드는 물건명, 가격, 갯수
			생성자를 통해서 초기화(물건명, 가격) 처리
			기능메소드 : 매개변수로 갯수를 처리하며 물건명, 가격, 갯수를 출력하고 총계를 리턴
		2) 응용) Schedule 일정계획 클래스
				필드 : 계획내용, 계획된 시간
				생성자 : 필드값 초기화
				메소드 : execute(시간, 실제실행시간 확인) 리턴값으로 계획실행, 리턴값으로 계획 실행의 차 리턴
				일정계획 3개와 실행된 내용에 대해 전체 계획대비 실행 차이를 출력하세요(1조)	
		3) 쇼핑몰 클래스를 선언하고
			기능메소드 : 로그인(id, pass)
					  물건구매(물건명, 갯수) 
					  상품리스트보기() : 쇼핑몰에 상품리스트 보기 ArrayList<Product>
					  물건상세보기() : 상품 중에 특정한 상품 보기 Product (2조 했다가 어려워서 풀이해주심)
		  -> 너무 어려워서 선생님이랑 같이 풀이함
			
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tot = 0;
		
		Product101 p101 = new Product101("사과", 9000);
		tot += p101.buy(5);
		
		Product101 p102 = new Product101("바나나", 3900);
		tot += p102.buy(2);
		
		Product101 p103 = new Product101("딸기", 12000);
		tot += p103.buy(3);
		
		System.out.println("총계 : " + tot);
		
		
		
		// 응용) Schedule 일정계획 클래스
		//		필드 : 계획내용, 계획된 시간
		//		생성자 : 필드값 초기화
		//		메소드 : execute(시간, 실제실행시간 확인) 리턴값으로 계획실행, 리턴값으로 계획 실행의 차 리턴
		//		일정계획 3개와 실행된 내용에 대해 전체 계획대비 실행 차이를 출력하세요(1조)
		
		// 푸는데 시간이 어떤 기준인지 모르겠어서 걍 내가 계획한게 더 큰데 실제는 적게 했다고 생각함
		int totTm = 0;
		Schedule sc1 = new Schedule("책읽기", 5);
		int difTm1 = sc1.execute(2);
		totTm += difTm1;
		
		Schedule sc2 = new Schedule("운동하기", 2);
		int difTm2 = sc2.execute(1);
		totTm += difTm2;
		
		Schedule sc3 = new Schedule("공부하기", 8);
		int difTm3 = sc3.execute(5);
		totTm += difTm3;
		
		System.out.println("\n # 총 실행차이 : " + totTm + " 시간 #");
		
		
		
		
		shoppingMall shm = new shoppingMall();
		shm.buy("바나나", 3800);
		shm.buy("사과", 6000);
		shm.buy("과자", 1000);
		shm.buy("음료수", 2900);
		
		shm.shpContent("음료수");
	}

}

// 이 클래스는 필드, 생성자, 메소드 모두 통합적으로 사용하는 클래스
class Product101 {
	private String name;
	private int price;
	private int cnt;
	
	// 이름이랑 가격만 생성자를 통한 초기화 처리
	public Product101(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	// 각 물건에 대한 구매처리
	public int buy(int c) {
		this.cnt = c;
		
		System.out.println("\n# 구매한 물건 정보 #");
		System.out.println("물건명 : " + name);
		System.out.println("가격 : " + price);
		System.out.println("갯수 : " + cnt);
		
		return price * cnt;
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


class Schedule {
	private String planName;
	private int planTime;
	
	public Schedule(String planName, int planTime) {
		super();
		this.planName = planName;
		this.planTime = planTime;
	}
	

	public int execute(int ex) {
		int exNum = planTime - ex;
		System.out.println("\n # 실행계획 출력 #");
		System.out.println("실행계획명 : " + planName);
		System.out.println("실행계획의 차 : " + exNum);
		return exNum;
	}
}

// 응용2 
class shoppingMall {
	private ArrayList<Product101> pd = new ArrayList<Product101>();
	
	
	
	public void login(String id, String pass) {
		String sId = id;
		String sPass = pass;
		
		if (sId.equals("himan") && sPass.equals("7777")) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	public void buy(String n, int p) {
		System.out.println("# 물건구매 #");
		pd.add(new Product101(n, p));
		// 여기를 어떻게 해야하는지 몰랐는데 예제를 하면서 앎
		// 이 new Product101을 main()에서 담아서 보내도록 하고
		// 매개변수는 Product101 p -> pd.add(p)로 
	}
	
	public void shpList() {
		// 구매시 물건명이랑 갯수를 받아오니까 arraylist에 저장?
		
		System.out.println("# 물건구매리스트? #");
		for(Product101 p:pd) {
			System.out.println(p.getName()); 
			System.out.println(p.getPrice()); 
			System.out.println(p.getCnt()); 
		}
	}
	
	public void shpContent(String search) {
		
		for(Product101 p:pd) {
			if(p.getName().equals(search)) {
				System.out.println("해당하는 물건이 있습니다");
				System.out.println("물건명 : " + p.getName());
				System.out.println("가격 : " + p.getPrice());
				System.out.println("갯수 : " + p.getCnt());
			}
		}
		
		
	}

	
	
}
