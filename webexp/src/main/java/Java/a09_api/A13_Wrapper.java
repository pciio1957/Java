package Java.a09_api;

import java.util.ArrayList;

public class A13_Wrapper {
	
	/*
	
	#Wrapper 객체란
	1. 기본 타입(bytem, char, short, int, long, float, 
		double, boolean) 값을 내부에 두고 포장하는 객체를 말한다.
		왜 객체로 변환하는가? 객체로 전환되는 순간, 여러가지 기능메소드가
		지원되며, 데이터 변환이나 기능 처리를 할 수 있기 때문이다.
		
	 2. 포장 클래스
	 	대부분 대문자로 시작하여 처리하는 객체를 말한다.
	 	char -> Character ,  int -> Integer  : 줄이지않은 기본이름 사용
	 	byte -> Byte, short -> Short  : 데이터 유형 그대로 사용
	 	
	 3. 박싱(Boxing) 과 언박싱(UnBoxing)
	 	기본데이터 <-> Wrapper 객체 : 변환해주는 과정이 필요함
	 	
	 	1) 박싱 : 기본 타입의 값을 포장 객체로 만드는 과정
	 	2) 언박싱 : 포장 객체에서 기본 타입의 값을 얻어내는 과정
	 	3) autoboxing : 위에 있는 정상적인 처리방법 외에 간편하게 처리하는 것
	 	
	 4. 처리방법
	 	1) 생성자를 통한 박싱 처리
	 		[1] 기본 타입을 생성자에 할당
	 		[2] 문자열형 기본타입을 생성자에 할당
	 			deplicated : 버전의 상승으로 인한 사용을 자제시킴, 
	 				나중에 사용을 변경 내지 삭제 계획이 있다는 뜻.
	 			Byte b01 = new Byte("10");
	 			System.out.println(b01);
	 	
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// wrapper 실습
		// 기본 유형의 데이터를 Wrapper 객체로 변환 처리
		int num01 = 25;
		// 객체의 속성(필드/메소드)를 통해서 여러가지 기능을 처리할 수 있다.
		Integer num01Obj = new Integer(num01);
		
		// Boxing 처리
		Byte obj01 = new Byte("10");
		Integer obj02 = new Integer(1000);
		Double obj03 = new Double("35.27");
		
		System.out.println("박싱된 객체 : " + obj01);
		System.out.println("박싱된 객체 : " + obj02);
		System.out.println("박싱된 객체 : " + obj03);
		
		
		// unboxing 처리
		byte value01 = obj01.byteValue();
		int value02 = obj02.intValue();
		double value03 = obj03.doubleValue();
		
		System.out.println("언박싱된 객체 : " + value01);
		System.out.println("언박싱된 객체 : " + value02);
		System.out.println("언박싱된 객체 : " + value03);
		
		
		// autoboxing
		// 기본 데이터 유형을 바로 할당할 때, 
		// autoboxing이 일어나서 객체로 Wrapper 된다
		Integer obj04 = 1000;
		Double obj05 = 35.24;
		ArrayList<Integer> ilist = new ArrayList<Integer>();
		ilist.add(new Integer(25));
		ilist.add(new Integer("30")); // 일반적
		
		ilist.add(35);
		ilist.add(25); // 이렇게 들어감
		
		for(Integer i:ilist) {
			System.out.println("데이터 : " + i);
		}
		
		
		// 응용1) char, boolean, float 데이터를 boxing 처리하여 
		//		Wrapper 클래스에 할당하고 출력하기
		// 응용2) main(String[] args)의 args[]안에 문자열 데이터를
		//		정수형, 실수형 3개 입력하고 Wrapper(생성자)로 데이터 출력
		// 응용3) ArrayList로 임의의 수학점수(0~100) 정수형 데이터
		// 		5개를 할당하고 출력하기
		
		// 응용1
		// boxing 처리시 형식 : new 래퍼클래스(문자열형)/ new 래퍼클래스(해당타입)
		System.out.println("\n# 응용1 #");
		Character num1 = new Character('a');
		Boolean num2 = new Boolean(true);
		Float num3 = new Float(3.3);
		
		System.out.println("박싱된 객체(Character) : " + num1);
		System.out.println("박싱된 객체(Boolean) : " + num2);
		System.out.println("박싱된 객체(Float) : " + num3);
		
		
		// 응용2
		System.out.println("\n# 응용2 #");
		
		ArrayList<Integer> iList = new ArrayList<Integer>();
		ArrayList<Float> fList = new ArrayList<Float>();
		
//		iList.add(Integer.parseInt(args[0]));
//		iList.add(Integer.parseInt(args[1]));
//		iList.add(Integer.parseInt(args[2]));
//
//		for(Integer i:iList) {
//			System.out.println("Integer 생성자 데이터" + i);
//		}
//		
//		fList.add(Float.parseFloat(args[3]));
//		fList.add(Float.parseFloat(args[4]));
//		fList.add(Float.parseFloat(args[5]));
//		System.out.println("생성자 데이터 4 : " + args[3]);
//		System.out.println("생성자 데이터 5 : " + args[4]);
//		System.out.println("생성자 데이터 6 : " + args[5]);
//		for(Float f:fList) {
//			System.out.println("Float 생성자 데이터" + f);
//		}
		
		
		// 응용3
		ArrayList<Integer> ranList = new ArrayList<Integer>();
		
		System.out.println("\n# 응용3 #");
		for(int i=0 ;i < 5; i++) {
			Integer ranNum = (int) (Math.random()*101);
			ranList.add(ranNum);
			// ranList.add((int) (Math.random()*101));
			System.out.println(i+1 + "번째 점수 : " + ranNum);
		}
		
	}
}
