package Java.a06_object;

import Java.a06_object.vo.Book;
import Java.a06_object.vo.Person;
import Java.a06_object.vo.Product;

public class A03_Class01 {
	
	/* # 클래스가 객체로 만들어지는 순간
	   1. main 메소드 안에서 실행 코드를 입력했을 떄,
	   2. 객체의 선언 방식
	   		1) 클래스명 참조변수 = new 생성자();
	   		   참조변수 안에는 heap 영역의 주소값으로 stack에 할당
	   		   new 생성자() heap영역에서 객체가 생성된다.
	   3. 컴파일을 통해서 .class가 만들어지고
	   4. 실행을 통해서 객체가 메모리에 로딩되어 수행된다.
	 

	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 Person p01 = new Person();
		 // 외부 패키지 클래스 가져오기 : ctrl+shift+o 
		 p01.name = "홍길동";
		 p01.age = 25;
		 p01.loc = "서울 신림동";
		 
		 System.out.println("p01 객체의 필드 name 값 : " + p01.name);
		 System.out.println("p01 객체의 필드 age 값 : " + p01.age);
		 System.out.println("p01 객체의 필드 loc 값 : " + p01.loc);
		 
		 /* 
		  
		  	응용1) javaexp.a05_object.vo 패키지 안에 
		  	Product 클래스를 선언하고 
		  	필드(속성) 물건명(name) 가격(price)  갯수(cnt)
		  	생성자 선언 후 물건호출 출력
		  	메소드 물건의 메소드 출력
		  	클래스를 객체로 생성하세요 
		  	
		  	응용답) vo 패키지안에 Product 클래스 선언
		  	-> vo패키지에 클래스 만들기, main이 없는 형태 
		  	필드선언(name, price, cnt)
		  	-> public String, int 형태로 선언
		  	생성자로 물건호출
		  	-> public Product() { println("물건 객체 생성자 호출"); }
		  	메소드 호출 출력
		  	-> public String call() { println("물건 호출"); return ..}
		  
		 */
		 
		 // 응용) 외부 클래스를 만들어서 해당 main에서 참조
		 // 생성자에 매개변수를 넣어서 만들때부터 입력되게 함
		 // Product p02 = new Product("텀블러", 18000, 2);
		 // p02.gg();
		 Product p02 = new Product();
		 p02.name = "텀블러";
		 p02.price = 18000;
		 p02.cnt = 2;
		 System.out.println("p02에 할당된 name 값 " + p02.name);
		 System.out.println("p02에 할당된 price 값 " + p02.price);
		 System.out.println("p02에 할당된 cnt 값 " + p02.cnt);
		 
		 // 필드의 사용1) 외부에서 할당 처리
		 //	참조변수.필드명 = 할당할 데이터;
		 p01.name = "홍길동"; // Person에 전역변수로 선언된 name의 값 지정
		 // 필드를 사용해서 만들어진 객체에 데이터를 할당함
		 System.out.println("Person객체의 필드 name의 값 " + p01.name);
		 // 다른 주소에 클래스로 객체를 생성, 주소는 p02에 주소값이 할당됨
		 // ex) 서울에 있는 63빌딩, 제주도에 있는 63빌딩을 같은 도면으로 만든 것과 같음
		 
		 Person p03 = new Person(); 
		 p03.name = "신길동";
		 p03.age = 27;
		 p03.loc = "경기 수원";
		 
		 System.out.println("p03에 할당된 name의 값 " + p03.name);
		 System.out.println("p03에 할당된 age의 값 " + p03.name);
		 System.out.println("p03에 할당된 loc의 값 " + p03.name);
		 
		 
		// 생성자가 2개면 해당하는 생성자로 생성함
		Person p04 = new Person("마길동", 24, "제주도");
		System.out.println("매개변수있는 객체 생성 name 값 " + p04.name);
		System.out.println("매개변수있는 객체 생성 age 값 " + p04.age);
		System.out.println("매개변수있는 객체 생성 loc 값 " + p04.loc);
		 
		p01.show();
		p03.show();
		p04.show();
		
		
		
		 // 응용2) Product 물건명, 가격, 갯수 필드에 데이터를 할당해서 출력하고
		 // pro01, pro02에 다른 속성을 할당하고 출력하기
		 
		 // Product의 새로운 객체 pro01 생성
		 Product pro01 = new Product();
		 pro01.name = "연필";
		 pro01.price = 800;
		 pro01.cnt = 10;
		 
		 System.out.println("Product의 pro01에 할당된 name 값 " + pro01.name);
		 System.out.println("Product의 pro01에 할당된 price 값 " + pro01.price);
		 System.out.println("Product의 pro01에 할당된 cnt 값 " + pro01.cnt);
		 
		 // Product의 새로운 객체 pro02 생성
		 Product pro02 = new Product();
		 pro02.name = "필통";
		 pro02.price = 3000;
		 pro02.cnt = 3;
		 
		 System.out.println("Product의 pro02에 할당된 name 값 " + pro02.name);
		 System.out.println("Product의 pro02에 할당된 price 값 " + pro02.price);
		 System.out.println("Product의 pro02에 할당된 cnt 값 " + pro02.cnt);
		 
		 
		 // 응용3) Product에 입력값이 있는 생성자를 추가하여 초기값 처리를 하고
		 // 	  pro03을 통해 객체를 생성하고, 속성을 출력하기
		 // 응용4) Book 클래스를 생성하고 도서명, 저자(writer), 가격 속성 설정 생성자를 통해
		 // 	  초기화 처리하고 필드를 출력하기
		 
		 
		 // 응용3 
		 Product pro03 = new Product("마우스", 15000, 8);
		 System.out.println("pro03의 name 값 " + pro03.name);
		 System.out.println("pro03의 price 값 " + pro03.price);
		 System.out.println("pro03의 cnt 값 " + pro03.cnt);
		 
		 // 응용4
		 Book boo = new Book("자바의 정석", "남궁성", 30000);  // 클래스 참조하기 컨트롤+쉬프트+o
		 System.out.println("boo의 도서명 " + boo.bookname);
		 System.out.println("boo의 저자 " + boo.per);
		 System.out.println("boo의 가격 " + boo.price);
		 
		 
		 // 응용5) Product의 기능 메소드 buy()를 통해 아래와 같은 형식으로 출력
		 //구매한 물품 @@@, 단가 @@@원, 구매갯수 @@, 총 비용 @@@원
		 
		 // 응용5 
		 System.out.println("# 메소드 호출 #");
		 pro01.buy();
		 pro02.buy();
		 pro03.buy();
		 
		 
		 
	}

}
