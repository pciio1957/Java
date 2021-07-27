package Java.a11_io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Java.a06_object.vo.Product;
import Java.z01_vo.Food;

public class A02_Basic {
	
	/*
	 
	 # 배열 객체의 한계와 collection 객체
	 1. 배열은 한번 크기가 설정이 되어 만들어지면
	 	배열의 크기를 동적으로 변경이 불가능하다.
	 	새로운 메모리로 배열을 다시 만들어야 하는 단점을 가지고 있다.
	 2. java에서는 이러한 배열형에 대한 동적인 구조를 처리하기 위해
	 	3가지 형태의 기본적인 데이터처리 구조를 만들어 사용한다.
	 	
	 3. Collection 객체 3가지
	 	1) set 인터페이스 하위객체
	 		순서가 확보되지 못하고 중복을 허용하지 못한다.
	 	2) List 인터페이스 하위객체
	 		순서를 index에 의해 확보가 되고,
	 		다양한 기능메소드를 통해서 데이터를 처리하고 있다.
	 		add(추가)
	 		add(index, 추가) : 특정 위치 이후에 추가
	 		set(index, 변경) : 특정 위치에 변경
	 		get(index) : 특정 위치에 데이터 가져오기
	 		remove(index) : 특정 위치의 데이터 삭제
	 		size() : 해당 객체의 크기
	 	3) Map 인터페이스 하위 객체
	 		Key, value 형식의 데이터를 할당하여 중복되지 않는
	 		key를 기준으로 데이터를 처리할 수 있다.
	 		put("key", value객체) : key, value값 할당
	 		ketSet() : Set객체로 전체 중복되지 않는 key를 가져올 수 있다.
	 		get(키값) : map 객체에 포함된 key에 해당하는 값을 가져올 수 있다.
	 		
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1) Set 객체 확인
		// 자동 Import 단축키 : ctrl+shift+o
		Set set = new HashSet();
		set.add("사과");
		set.add("바나나");
		set.add("바나나");
		set.add("오렌지");
		set.add("수박");
		System.out.println("set 구조 확인 : " + set + "\n");
		// 순서가 규칙적이지 않으며, 중복이 허용되지 않는다.
		
		
		// 2) List 객체 확인
		List lst = new ArrayList();
		lst.add("오렌지");
		lst.add("오렌지");
		lst.add("바나나");
		lst.add("수박");
		lst.add("수박");
		lst.add("키위");
		System.out.println("lst 구조 확인:" + lst + "\n");
		// 중복도 허용하고, 순서도 정확하게 매핑
		
		
		// 응용1) 좋아하는 음료를 List 객체로 입력하여 구조 확인
		List drink = new ArrayList();
		drink.add("콜라");
		drink.add("사이다");
		drink.add("콜라");
		drink.add("쥬시쿨");
		drink.add("환타");
		System.out.println("좋아하는 음료들 : " + drink + "\n");
		
		
		// 데이터 수정 : lst.set(위치, 변경할 데이터)
		lst.set(0, "망고");
		// 데이터 삭제 : lst.remove(lst.size()-1); // 크기-1 하면 마지막데이터 지정
		lst.remove(lst.size()-1);
		// lst.add(위치, 특정위치에 추가)
		lst.add(1, "사과");
		// .size()를 통해서 크기 설정
		for(int idx = 0; idx < lst.size(); idx++) {
			// get()을 통해서 단위 데이터를 가져올 수 있다.
			System.out.println(idx + 1 + ":" + lst.get(idx));
		}
		
		
		// 응용2) 음료 list 내용을 3번째 위치에 추가,
		//  	 첫번째 위치의 음료 삭제, 4번째 위치의 음료 수정하여
		//		 전체 데이터 리스트를 출력처리하기
		drink.add(2, "식혜");
		drink.remove(0);
		drink.set(3, "코코팜");
		
		for(int idx = 0; idx < drink.size(); idx++) {
			System.out.println(idx +1+ ":" + drink.get(idx));
		}
		System.out.println("수정된 좋아하는 음료들 :" + drink + "\n");
		
		
		
		// 객체 단위로 데이터 추가 변경
		// ArrayList로 generic으로 Product 객체만 할당할 수 있다.
		// List 객체 선언
		List<Product> plist = new ArrayList<Product>();
		plist.add(new Product("사과", 3000, 2));
		plist.add(new Product("바나나", 4000, 5));
		plist.add(new Product("오렌지", 2000, 5));
		plist.add(new Product("수박", 13000, 3));
		plist.add(new Product("키위", 800, 13));
		for(Product p:plist) {
			//p.buy();
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getCnt() + "\n");
		}
		
		
		
		// 응용) Food 객체를 ArrayList로 객체 3개를 생성하여 담고,
		//		해당 내용을 출력 처리하기
		// List<Food> : 리스트 객체에 기본 데이터 유형인 Object에서
		// 				특정한 데이터 유형 Food만 구성요소로 들어올 수 있게 
		// 				해서 반복문에서 typecasting없이 바로 객체를 사용할 수 있게 한다
		List<Food> flist = new ArrayList<Food>();
		flist.add(new Food("마라탕", 12000, "탕화쿵푸"));
		flist.add(new Food("호두과자", 8000, "복호두"));
		flist.add(new Food("맥주", 2500, "편의점"));
		flist.add(new Food("초코소라빵", 1200, "뜌레쥬르"));
		
		System.out.println("\n음식명\t가격\t파는곳");
		for(Food f:flist) {
			System.out.println(f.getfname() + "\t" + f.getfprice() +
					"\t" + f.getfLoc());
		}
		
		
		// 3) Map 객체 생성 (key, value유형)
		Map<String, String> map = new Hashtable<String, String>();
		map.put("name", "홍길동");
		map.put("age", "25");
		map.put("loc", "서울 신림동");
		System.out.println("Map의 name값 : " + map.get("name"));
		System.out.println("Map의 age값 : " + map.get("age"));
		System.out.println("Map의 loc값 : " + map.get("loc"));
		
		
		
		// 응용) 물건명, 가격, 갯수를 key로 하고 해당 값을 value로 하여 
		// 할당 후 출력처리하기
		Map<String, String> buuy = new Hashtable<String, String>();
		buuy.put("bName", "책");
		buuy.put("bPrice", "18000");
		buuy.put("bCnt", "3");
		System.out.println("\nbuuy의 물건명 : " + buuy.get("bName"));
		System.out.println("buuy의 가격 : " + buuy.get("bPrice"));
		System.out.println("buuy의 갯수 : " + buuy.get("bCnt"));
	}

}
