package Java.a11_io;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import Java.z01_vo.Food;

public class A03_List {
	
	/*
	
	#컬렉션 프레임워크의 주요 인터페이스
	1. List
		순서를 유지하고 저장, 중복 저장 가능
		ArrayList, Vector, LinkedList
	
	2. Set
		순서를 유지하지 않고 저장, 중복 저장 안됨
		HashSet, TreeSet
	
	3. Map
		키와 값의 쌍으로 저장, 키만 중복 저장 불가
		HashMap, HashTable, TreeMap, Properties
		
		
	#List컬렉션
	1. 특징
		인덱스로 관리
		중복해서 객체 저장 가능
	2. 구현클래스
		ArrayList
		Vector : 불확실성이 많은 쓰레드에서 보다 안정[적으로
			데이터를 추가 삭제할 수 있다.
		LinkedList : 인접 참조를 링크해서 체인처럼 관리
			특정 인덱스에서 객체를 제거하거나 추가하게 되면
			바로 앞뒤 링크만 변경
			빈번한 개체 삭제, 삽입이 일어나는 곳에서 ArrayList보다
			좋은 성능을 발휘한다
	3. 공통 메소드
		add(객체) : 맨끝에 추가된다.
		add(지정index, 객체) : 지정한 index위치에 추가된다
			기존 객체들을 추가 위치를 기준으로 하나씩 밀리게 된다
		set(지정인덱스, 객체) : 지정한 index에 객체를 바꿈
		contains(객체) : 해당 객체가 있는지 여부를 리턴 
		get(위치index) : 해당index의 객체를 가져온다
		isEmpty() : 컬렉션이 비어있는지 확인한다. (boolean)
		size() : 저장되어 있는 전체 객체수를 리턴한다.
		clear() : 저장된 모든 객체를 삭제한다.
		remove(index) : 특정 위치에 있는 객체를 삭제
		remove(객체) : 주어진 객체를 삭제
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// List 생성 후 비었는지 확인, 사이즈 확인
		List<String> list = new ArrayList<String>();
		System.out.println("isEmpty() : " + list.isEmpty());
		System.out.println("size() : " + list.size());
		
		// 객체에 데이터 삽입
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		
		// 다시 객체가 비었는지 확인, 사이즈 확인
		System.out.println("isEmpty() : " + list.isEmpty());
		System.out.println("size() : " + list.size());
		
		
		// 해당 인덱스에 데이터 삽입
		list.add(1, "오렌지"); 
		System.out.println(list);
		System.out.println("세번째 데이터 : " + list.get(2));
		
		// 수박으로 변경후 검색
		list.set(2, "수박");
		System.out.println(list);
		System.out.println("수박이 있는지? : " + list.contains("수박"));

		// 해당인덱스 삭제, 검색해서 데이터 삭제
		list.remove(0);
		list.remove("바나나");
		System.out.println(list);
		
		// 모두 삭제 후 있는지, 사이즈 확인
		list.clear();
		System.out.println("isEmpty() : " + list.isEmpty());
		System.out.println("size() : " + list.size());
		
		
		// 응용) 회원관리 ArrayList<String>
		//		회원 등록 2명, 1번째에 추가, 2번째 회원 변경,
		//		회원 탈퇴(index, 이름), 전체 탈퇴 처리,
		//		회원 회원크기
		
		ArrayList<String> mem = new ArrayList<String>();
		
		mem.add("홍길동");
		mem.add("고길동");
		mem.add(1, "이길동");
		mem.set(2, "주길동");
		
		System.out.println("현재 회원 : " + mem);
		
		mem.remove(1);
		mem.remove("주길동");
		
		System.out.println("남은 회원은 " + mem.isEmpty());
		System.out.println("회원목록의 크기는 " + mem.size());
		
		// 
		Vector<Food> f1 = new Vector<Food>();
		f1.add(new Food("짜장면", 5000, "강남맛집"));
		f1.add(new Food("두부요리", 7000, "콩두부맛집"));
		f1.add(new Food("한정식", 7000, "개포동한정식"));
		
		for(Food f:f1) {
			System.out.print(f.getfname()+"\t");
			System.out.print(f.getfprice() +"\t");
			System.out.println(f.getfLoc() +"\t");
		}
		
		
		// List와 LinkedList의 추가 속도 비교
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime = 0;
		long endTime = 0;
		startTime = System.nanoTime();
		
		for(int cnt=1; cnt <= 9999; cnt++) {
			list1.add(0, String.valueOf(cnt));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 추가 입력 시간 : "
				+ (endTime-startTime) + "ns");
		
		startTime = 0;
		for(int cnt = 1; cnt<= 9999; cnt++) {
			list2.add(0, String.valueOf(cnt));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 추가 입력 시간 : " +
				(endTime-startTime) + "ns");
		
		
		
		
		
	}

}
