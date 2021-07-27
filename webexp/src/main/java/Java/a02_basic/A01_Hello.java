package Java.a02_basic;

import java.util.ArrayList;

public class A01_Hello {
	
	/*
	#java 프로그램의 실행 과정
	1. 자바 코드 파일 만들기
		@@.java
		
	2. 컴파일 처리
		javac @@.java -> @@@.class가 만들어진다.
		ps) eclipse에서는 에러가 나지않으면 저장시 /build 폴더에 
		컴파일된 파일이 .class로 저장된다.
		cf) 실행 명령어 JDK 위치
			c:\Progeam Files\Java\jdk-15.0.2\bin
			javac.exe (컴파일)
		// javaexp 폴더에서 컴파일이 되어서 업데이트가 되었는지 확인
		
	3. 실행 처리
		main()메소드가 포함된 클래스만 아래의 실행 명령어를 통해
		메모리 로딩과 cpu 처리를 통해서 결과를 확인할 수 있다.
			java.exe(실행)
		-> java A01_Hello를 통해서 실행된다.
		ps) 실행을 하는데 현재 source가 실행되지 않고, 과거의 source로 실행되면 
		현재 소스가 새로운 소스로 컴파일 되지 않은 상황이므로
			1) 에러가 있는지 점검
			2) build 하위에 class 파일이 현재 시간으로 저장되어 있는지 확인 
		
	 
	*/
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 주석: ctrl+ /, 프로그램에 영향 X
		// 다중라인주석: ctrl+shift+/ 
		// 폰트크기조절: ctrl + (+/-), 프로그래밍 소스코드 폰트 크기조절
		
		// 코딩하기: 왼쪽에 빨간 줄이 뜨지않아야 하고 저장을 습관화
		System.out.println("자바를 드디어 시작했다");
		
		// 실행하기: 오른쪽 마우스 - Run As - java application
		// ctrl + shift + f11 (실제 실행)
		// ctrl + f11 (디버깅 실행)
		
		String name =" 홍길동";
		System.out.println("디버그1");
		System.out.println("디버그2");
		System.out.println("디버그3");
		
		
		int num01 = 25; int num02 = 30; // ;은 선언의 마지막
		// 이렇게 선언하면 마지막값 num05에만 초기화값 저장
		int num03, num04, num05 = 30; 
		num03 = 25; num04 = 26;
		System.out.println(""+num03); 
		System.out.println(""+num04);
		System.out.println(""+num05);
		
		

		// ctrl+M 전체보기/패키지같이보기
		
	}

}
