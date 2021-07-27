package Java.a01_exp.month06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Java.z01_vo.Car;
import Java.z01_vo.Food;

public class a18_0603 {
	/*
	# 정리 과제 #
	1. autoboxing이란 무엇을 말하는지 예제 2가지를 기술해보세요.
	2. 학생 5명의 이름과 국어, 영어, 수학 성적(0~100임의)으로 autoboxing으로 입력하고,
    	리스트 출력 처리하세요.
	3. 임의의 범위를 1000.01 ~ 9999.99 로 설정하여
    	데이터를 출력하고, 올림/내림/반올림 처리한 결과를 룰력하세요.
	4. Random 객체를 활용하여 주사위 2개의 합산을 나타내세요.
	5. Class 객체의 생성방법 2가지를 기술하세요.
	6. List의 공통메서드와  하위 실제클래스의 특징을 기술하세요.
	7. LinkedList를 이용해서, 구매물품을 추가,수정,삭제를 처리하세요.
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1. 같은 데이터 유형의 데이터를 넣으면 자동으로 Wrapper로 생성해주는 것이 autoboxing이다 
		Integer intNum1 = new Integer(1000); // boxing의 경우
		Integer intNum2 = 1000; // autoboxing
		
		
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(new Integer(1000)); // boxing의 경우
		alist.add(2000); // autoboxing
		
		
		// 2.
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> kors = new ArrayList<Integer>();
		ArrayList<Integer> engs = new ArrayList<Integer>();
		ArrayList<Integer> maths = new ArrayList<Integer>();
		
		names.add("김기동");
		names.add("김이동");
		names.add("김아동");
		names.add("김나동");
		names.add("김다동");
		
		for(int i = 0; i < names.size(); i++) {
			int ranNum1 = (int) (Math.random()*101);
			int ranNum2 = (int) (Math.random()*101);
			int ranNum3 = (int) (Math.random()*101);
			
			kors.add(ranNum1);
			engs.add(ranNum2);
			maths.add(ranNum3);
		}
		
		System.out.println("\n# 2. 학생 성적표 #");
		System.out.println("이름\t국어\t영어\t수학");
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + "\t" +  kors.get(i) 
				+ "\t" + engs.get(i) + "\t" + maths.get(i));
		}
		
		// 3. 
		int ranNum = (int) (Math.random() * 899999 + 100000);
		double mNum = ranNum/100.0;
		System.out.println(ranNum);
		System.out.println(ranNum/100.0);
		
		System.out.println("\n# 3. Math함수 #");
		System.out.println("올림(ceil) : " + Math.ceil(mNum));
		System.out.println("내림(floor) : " + Math.floor(mNum));
		System.out.println("반올림(round) : " + Math.round(mNum));
		
		
		
		// 4.
		Random randoms = new Random();
		int dice1 = (int) randoms.nextInt(6); // 0도 나옴..
		int dice2 = (int) randoms.nextInt(6);

		System.out.println("\n# 4. 주사위값의 합산 #");
		System.out.println("주사위 1번 : " + dice1);
		System.out.println("주사위 2번 : " + dice2);
		System.out.println("주사위 2개의 합산 : " + (dice1+dice2));
		
		
		// 5. 
		// Class 객체 생성 방법 1: 실제클래스를 객체로 선언한 후 그 객체의 클래스를 받아온다. 
		Car car = new Car();
		Class cla1 = car.getClass();
		System.out.println("\n# 5. Class 객체 생성 방법 #");
		System.out.println("Class 1번 : " + cla1.getName());
		
		try {
			// Class 객체 생성 방법 2: 실제클래스의 패키지명부터 시작하는 경로?를 받아와서 생성한다. 
			Class cla2 = Class.forName("javaexp.z01_vo.Food");
			System.out.println("Class 2번 : " + cla2.getName());
			
			// 해당 클래스를 객체로 사용하는 방법..?
			Food fod = (Food) cla2.newInstance();
			fod.setFname("바나나");
			System.out.println("Class 2번에 설정한 값 : " + fod.getfname());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		/*
		 6. 
		 	1. List의 공통메소드
		 		1) add(객체) : 맨끝에 데이터 추가
		 		2) add(index, 객체) : 지정한 index 위치에 데이터가 추가된다.
		 			기존 객체들의 위치를 추가 위치 기준으로 하나씩 밀린다.
		 		3) set(index, 객체) : 지정한 index의 객체를 바꾼다.
		 		4) contains(객체) : 해당 객체가 있는지에 대한 여부를 리턴한다.
		 		5) get(index) : 해당 index의 객체를 가져온다.
		 		6) isEmpty() : 컬렉션이 비어있는지 확인한다. 리턴값은 boolean이다.
		 		7) size() : 저장되어 있는 전체 객체의 수를 리턴한다.
		 		8) clear() : 저장된 모든 객체를 삭제한다.
		 		9) remove(index) : 특정 위치에 있는 객체를 삭제한다. 
		 		10) remove(객체) : 주어진 객체를 삭제한다.
		 	2. 하위 구현 클래스의 특징
		 		1) ArrayList :  배열의 특징과 리스트의 특징을 가지고 있는 List로
		 			가변적인 크기의 List이다. 
				2) Vector : 불확실성이 많은 쓰레드에서 보다 안정적으로 데이터를 추가/삭제할 수 있다.
				3) LinkedList : 인접 참조를 링크해서 체인처럼 관리하는 형태로 특정 인덱스에서
					객체를 제거하거나 추가하게 되면 바로 앞뒤의 링크만 변경된다.
					빈번한 개체 삭제, 삽입이 일어나는 곳에서 ArrayList보다 좋은 성능을 보인다.


		*/
		
		// 7.
		List<String> plist = new LinkedList<String>();
		System.out.println("\n# 7. LinkedList 이용한 구매목록 #");
		
		// 추가
		plist.add("공책");
		plist.add("볼펜");
		plist.add("필통");

		for(int i = 0; i < plist.size(); i++) {
			System.out.println(i+1 + "번째 물품 : " + plist.get(i));
		}
		System.out.println();
		
		// 수정
		plist.set(2, "시그노볼펜");
		plist.set(1, "노트");
		
		for(int i = 0; i < plist.size(); i++) {
			System.out.println(i+1 + "번째 물품 : " + plist.get(i));
		}
		System.out.println();
		
		// 삭제
		plist.remove(0);
		
		for(int i = 0; i < plist.size(); i++) {
			System.out.println(i+1 + "번째 물품 : " + plist.get(i));
		}
		System.out.println();
		
		
	}

}
