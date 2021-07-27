package Java.a11_io;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Java.z01_vo.Product;

public class A05_Map {
	
	/*
	#Map인터페이스 하위객체
	1. key, value 형식의 구조를 가진 collection
		key : 식별자
		value : 객체
		put(K, v) : 형식으로 저장처리
		keyset() : 저장되어 있는 key들을 set형식으로 리턴 
		get(k) : 결과로 value값을 가져오는 처리 
		
	2. key값을 중복을 허용하지 않음 
	3. value는 단일 데이터, 객체/배열도 할당 가능하다.
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		// Map<String, Integer> : key는 문자열 
		// value는 Integer Weapper를 선언하여 처리함 
		// put(key, value값 설정)
		// value값은 Wrapper이기에 기본유형으로 boxing 처리가 가능하다
		map.put("김길동", 80);
		map.put("신길동", 89);
		map.put("신길동", 92);
		map.put("오길동", 85);
		map.put("김길동", 87);
		System.out.println("Map의 크기 : " + map.size());
		// 중복된 데이터는 들어가지 않아서 사이즈는 3임
		
		// map의 key 가져오기 : map.keySet() 
		Set<String> keySet = map.keySet();
		
		for(String key:keySet) {
			// 맵객체.get("키") : value를 가져오기
			// 할당된 최종값을 가져온다 
			System.out.println(key + " : " + map.get(key));
		}
		
		// Map <정수형 Wrapper, 객체>
		// 정수형 Wrapper를 활용하여 boxing, unboxing 처리
		// 번호 순서로 데이터가 자동 저장
		// 최종값을 기준으로 value객체를 저장하여 중복을 허용하지 않는다.
		Map<Integer, Product> pMap = new HashMap<Integer, Product>();
		// autoboxing 처리로 key값은 기본 정수가 Integer에 할당처리
		pMap.put(1001, new Product("오렌지", 2000, 3));
		pMap.put(1002, new Product("딸기", 1000, 2));
		pMap.put(1003, new Product("바나나", 4000, 1));
		pMap.put(1004, new Product("키위", 5000, 6));
		pMap.put(1005, new Product("수박", 12000, 1));
		pMap.put(1006, new Product("한라봉", 9000, 5));
		
		Set<Integer> prokey = pMap.keySet();
		
		for(int code:prokey) {
			// int 정수타입변수 = new Integer("입력값");
			System.out.print(code + "\t");
			// key값 기준으로 연결되어 있는 value객체를 가져오고 있다.
			Product p = pMap.get(code);	
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getCnt() + "\n");
		}
		
		// 응용) 물건명과 가격을 key/value형식으로 설정하고 
		//		중복 처리도 한 후 반복문을 통해 최종 결과값 출력
		//		1조 제출~
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("연필", 1200);
		map2.put("공책", 2000);
		map2.put("연필", 1800);
		map2.put("마우스", 12000);
		map2.put("볼펜", 900);
		
		Set<String> key2 = map2.keySet();
		
		System.out.println("# map 결과 #");
		for(String k:key2) {
			System.out.println(k + " : " + map2.get(key2));
		}
		
		Map<Integer, Product> pMap2 = new HashMap<Integer, Product>();
		pMap2.put(1000, new Product("사과", 3000, 2));
		pMap2.put(1000, new Product("바나나", 4000, 4));
		pMap2.put(1000, new Product("딸기", 12000, 2));
		pMap2.put(1000, new Product("오렌지", 2000, 5));
		pMap2.put(1000, new Product("수박", 15000, 5));
		
		Set<Integer> proKey = pMap2.keySet();
		// unboxing 처리
		
		for(int code:proKey) {
			System.out.print(code + "\t");
			Product p = pMap2.get(code);
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.println(p.getCnt());
		}
	}

}
