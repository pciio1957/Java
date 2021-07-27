package Java.a09_api;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class A11_String {
	/*
	#String 문자열의 시작
	1. 숫자
		0,1 : 데이터의 최소단위 bit
		01010101 => 8개 byte -> 정수형의 가장 기본 데이터
		-> 숫자에 코드를 대입해 'A', 'B' 문자를 설정하여 생성되었다.
		문자들로 배열을 만들어서 일상에 문자열을 사용하게 되었음.
		{'H', 'e', 'l', 'l', 'o'} -> "Hello"
		
		{25, 34, 72, 43, 22} : 코드값으로 bytes 배열은 문자가 모인 문자열로
			사용할 수 있다.
		--> 객체지향 프로그램에서 char[] 배열의 형태에서 한단계 더 나아가
			String 문자열 객체를 만들게 되었다. c++부터 사용되기 시작함.
	
	
	#String 
	1. 문자열 처리 객체
	2. 생성자로 byte[]를 받아서 처리 
	
	
	#여러가지 기능메소드
	1) charAt(index) : 특정 index 위치에 있는 문자를 리턴받는다.
	2) getBytes() : 문자열의 byte배열을 가져온다.
		이때 매개변수값으로 EUC-KR이나 UTF-8로 한글 encoding 형식을 지정할 수 있다.
	3) indexOf("찾을문자열") :
		해당 문자 안에서 찾을 문자열의 시작 위치를 index로 리턴해준다.
		해당 문자열을 포함하지 않으면 -1을 리턴한다.
		
		응용문제에 참고
		대상문자열.indexOf(찾고자하는 문자열) :
			결과로 찾고자하는 문자열이 없으면 -1
			결과로 찾고자하는 문자열이 있으면 해당 문자열의 시작 위치를 리턴한다.
		switch(입력된 index) {
			case index번호 : 처리할 내용 break;
			case index번호 : 처리할 내용 break;
			default : 위에 나열된 경우가 아닐때
		}
			
	4) length() : 문자열의 크기를 나타낸다.
		cf) length : 배열의 크기를 나타낸다.
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// code값 확인
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 91, 118, 97};
		// 숫자에 해당하는 문자(char)가 모여서 문자열을 이루게 한다는 개념하에
		// String 생성자를 통해서 문자열을 만들 수 있게 하였다.
		String str= new String(bytes); 
		System.out.println("출력 : " + str);

		for(int code = 64;code<=128;code++) {
			System.out.println(code + " : " + (char) code);
			// code 값 확인
		}
		
		
		// 응용) 위와 같이 byte 배열과 유니코드 값을 이용해서 Goodjob을 출력하세요(6조)
		byte[] goodjob = {103, 111, 111, 100, 106, 111, 98};
		
		for(int i = 0 ; i < goodjob.length;i++) {
			System.out.print((char)goodjob[i]);
		}
		System.out.println();
		
		
		
		// 1) charAt 실습
		String name = "himan";
		System.out.println("charAt(2) : " + name.charAt(2));
		
		
		
		// 응용) 주민번호를 문자열로 지정해서 특정위치에 있는 문자를 가져와서
		//		1, 3일때 남자 / 2,4일때 여자로 표기하세요 (1조)
		String jnum1 = "950601-2334565";
		String jnum2 = "993873-1234533";
		
		char gender = jnum1.charAt(7);
		
		// switch case에서 그냥 1이랑 '1'은 다름..
		switch(jnum1.charAt(7)) {
		case '1' : // break없어서 밑으로
		case '3' : 
			System.out.println("남자");
			break;
		case '2' :
		case '4' :
			System.out.println("여자");
			break;
		default :
			System.out.println("입력 범위는 1~4입니다");
		}
	
		
		// 2)getBytes() 실습
		String str3 = "반가워요";
		byte[] bytes3 = str3.getBytes();
		String str4 = new String(bytes3);
		System.out.println("문자열 4번째 : " + str4);
		
		try {
			byte[] bytes4 = str3.getBytes("EUC-KR");
			String str5 = new String(bytes4);
			System.out.println("문자열 5번째 : " + str5);
			
			byte[] bytes5 = str3.getBytes("UTF-8");
			String str6 = new String(bytes5);
			System.out.println("문자열 6번째 : " + str6);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 응용) 오늘도 즐겁고 감사한 하루! encoding으로 euc-kr과 utf-8로
		// 		처리하여 출력하기(2조)
		String haru = "오늘도 즐겁고 감사한 하루!";
		
		try {
			byte[] btHaru1 = haru.getBytes("EUC-KR");
			String btstr1 = new String(btHaru1);
			System.out.println(" 오늘의 첫번째 인사 : " + btstr1);
			
			byte[] btHaru2 = haru.getBytes("UTF-8");
			String btstr2 = new String(btHaru2);
			System.out.println(" 오늘의 두번쨰 인사 : " + btstr2);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 3) indexOf 실습
		String msg = "점심 맛있게 드셨나요?";
		int idxLoc = msg.indexOf("맛있게");
		System.out.println("시작 위치 : " + idxLoc);
		
		if(msg.indexOf("짜장면") != -1) { // -1이 리턴되는것은 문자열이 없다는 뜻
			System.out.println("짜장면 관련 위치 확인");
		} else {
			System.out.println("해당 문자열을 발견하지 못했습니다");
		}
		
		// 4) length() 실습
		System.out.println("문자열의 크기 : " + msg.length());
		
		
		
		
		// 응용4) 메뉴는 사과, 바나나, 딸기로 과일을 선택받음(Scanner)
		//		indexOf를 이용해 입력한 과일이 없으면 "해당 과일은 메뉴에 없습니다"
		//		각 index위치를 확인해서 어느 순서의 과일인지 표시하기
		//		@@ 번째 과일 @@을 선택했습니다(3조)
		
		Scanner sc = new Scanner(System.in);
		String fmsg = "사과, 바나나, 딸기";
		
		System.out.println("# 메뉴는 사과, 바나나, 딸기가 있습니다 #");
		System.out.println("# 메뉴를 선택해주세요 #\n-> ");
		String fstr = sc.nextLine();
		// sc.nextLine() : 문자열을 입력받아서 enter키 입력 전까지 
		
		System.out.println("선택한 메뉴의 index : " + fmsg.indexOf(fstr));
		
		// 조건을 정해줘야한다고 생각해서 if문을 사용했는데 switch문으로 해도 ㄱㅊ
		// indexOf를 받아서 해당 위치의 값을 case 하면 됨. 
		// 위치를 제대로 알기위해서 직접 세는거 보다 출력을 통해서 알아내는게 빠름,,
		if(fmsg.indexOf(fstr) == 0) {
			System.out.println("첫번째 과일 " + fstr + "를 선택했습니다");
		} else if(fmsg.indexOf(fstr) == 4) {
			System.out.println("두번째 과일 " + fstr + "를 선택했습니다");
		} else if(fmsg.indexOf(fstr) == 9) {
			System.out.println("세번째 과일 " + fstr + "를 선택했습니다");
		} else {
			System.out.println("입력한 과일은 메뉴에 없습니다");	
		}
		
		
	}

}
