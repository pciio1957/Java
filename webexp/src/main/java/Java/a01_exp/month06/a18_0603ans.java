package Java.a01_exp.month06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class a18_0603ans {
	
	/*
	1. autoboxing
	 boxing을 보다 간편하게 자동으로 처리하는 것을 말한다.
	 기본유형 <-> Wrapper클래스
	  unboxing   boxing 
	  
	 
	3. 범위 출력
	10001 ~ 999999
	(int)(Math.random()*경우수+시작수)
	-> ex) 경우의수
		1~9 : 9가지, 11~99 는 89가지,
		101~999 : 899가지 
		10001 ~ 999999 : 899999 
		시작수 : 100001 
		
		((int) (Math.random()*899999))/100.0
		정수/정수 -> 정수
		정수/실수 -> 실수 
	
	
	5. Class객체의 생성 방법
		1) 객체를 선언해 생성 후 사용
		Food f1 = new Food();
		해당 객체의 메타정보(객체/클래스정보-생성자, 메소드, 필드
			등의 정보)를 가져오기 위한 객체 Class
		JVM 메모리에 로딩
		Class clazz1 = f1.getClass(); 
		해당 패키지명과 클래스명을 이용하여 가져오는 방법
		
		특정 문자열로 된 클래스명이 jvm 메모리에 로딩되기 때문에 필수예외 처리가 필요하다
		Class clazz2 = Class.forName("javaexp.z01_vo.Product"); 
		  
		  
	6. List의 하위 실제클래스
	ArrayList : 가장 일반적으로 사용되는 클래스
	Vector : 쓰레드에서 데이터와 입력/수정/삭제를 안정적으로 처리한다.
		 동기화처리를 해준다.
	LinkedList : 인접 참조를 링크에서 체이닝처리/관리
		특정 인덱스에서 객체를 제거하거나 추가하게 되면 앞뒤
		링크만 변경하기 때문에 빈번한 객체 삽입/삭제 시 효율적으로 활용된다.
	 
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> kors = new ArrayList<Integer>();
		ArrayList<Integer> engs = new ArrayList<Integer>();
		ArrayList<Integer> maths = new ArrayList<Integer>();
		String[] narry = {"홍길동", "김길동", "신길동", "마길동", "오길동"};
		
		for(int i=0;i <narry.length;i++) {
			names.add(narry[i]);
			kors.add((int)(Math.random()*101));
			engs.add((int)(Math.random()*101));
			maths.add((int)(Math.random()*101));
			System.out.print(names.get(i) + "\t");
			System.out.print(kors.get(i) + "\t");
			System.out.print(engs.get(i) + "\t");
			System.out.print(maths.get(i) + "\t");
			// unboxing 후 연산처리
			// Wrapper에 있는 객체를 기본 유형으로 자동 unboxing으로
			// 처리되어 연산 후 할당
			int tot = kors.get(i) + engs.get(i) 
			 			+ maths.get(i);
			System.out.println(tot + "\n");
		}
		
		double ran = ((int)(Math.random()*899999+100001))/100.0;
		System.out.println("랜덤 수 : " + ran);
		System.out.println("올림 : " + Math.ceil(ran));
		System.out.println("내림 : " + Math.floor(ran));
		System.out.println("반올림 : " + Math.round(ran));
		
		
		
		// 4.Random
		Random random = new Random();
		int dice1 = random.nextInt(6)+1; // 1부터 시작..
		int dice2 = random.nextInt(6)+1;
		
		
		
		// 7.
		List<String> lklist = new LinkedList<String>();
		lklist.add("사과");
		lklist.add("바나나");
		lklist.add(0, "딸기");
		lklist.set(1, "오렌지");
		lklist.remove(2);
		System.out.println(lklist);
		
		
		
		

	}

}
