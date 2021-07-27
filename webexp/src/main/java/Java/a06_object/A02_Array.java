package Java.a06_object;

public class A02_Array {
	
	/*
	 # 객체의 범위
	 	1. 사용자의 정의 클래스 객체
	 	2. primitive data 유형의 배열도 객체에 포함
	 	
	 # 배열의 선언
	 	1. 데이터유형[] 참조명 = new 데이터유형[배열의 크기];
	 		배열의 메모리만 선언
	 		ex) int[] arr01 = new int[5]; 
	 		=> 정수형으로 된 5만큼의 배열 생성 
	 		arr01[0] arr01[1] arr01[2] arr01[3] arr01[4] 
	 		=> 데이터는 할당이 되지 않은 상태, 
	 		heap 영역에 객체가 메모리로 만들어져 있다. 
	 	2. 데이터유형[] 참조명 = {데이터1, 데이터2, 데이터3};
	 		배열의 메모리선언과 함께 데이터할당
	 		ex) String[] fru = {"바나나", "사과", "포도"};
	 
	 # 배열의 데이터 확인
	 	1. 배열명[index]로 데이터를 확인할 수 있다
	 		index는 0부터 시작
	 	2. 배열명.length를 통해 배열의 크기를 확인할 수 있다.
	 	
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정수형 배열선언
		int[] arry01 = new int[5];
		int[] arry02 = {3000, 4000, 5000};		
		System.out.println("메모리 확인: " + arry01);
		System.out.println("메모리 확인: " + arry02);
		
		// 배열의 각각의 값 확인
		System.out.println(arry02[0]);
		System.out.println(arry02[1]);
		System.out.println(arry02[2]);
		
		//배열의 크기확인
		System.out.println("배열의 크기1: " + arry01.length);
		System.out.println("배열의 크기2: " + arry02.length);
		
		// 문자열로 된 배열 확인
		String[] fru = {"사과", "바나나", "딸기"};
		System.out.println(fru[0]);
		System.out.println(fru[1]);
		System.out.println(fru[2]);
		
		
		// 응용1) 배열 3번째로 좋아하는 공휴일 3개를 선언하고 출력
		// 응용2) 주로 타는 버스번호(정수) 3개를 선언하고 출력
		String[] h = {"어린이날", "설날", "추석"};
		int[] n = {62, 99, 3400};
		System.out.println(h[0]);
		System.out.println(h[1]);
		System.out.println(h[2]);
		System.out.println(n[0]);
		System.out.println(n[1]);
		System.out.println(n[2]);
		
		
	}

}
