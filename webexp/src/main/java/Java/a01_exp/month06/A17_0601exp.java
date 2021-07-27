package Java.a01_exp.month06;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public class A17_0601exp {
	
	/*
	
	#정리문제
1. System. 하위에 기능메서드로 현재시스템에 대한 내용을 확인하고 처리할려고 한다.
    주요 메서드와 속성/속성값 처리 코드를 기술하세요.
2. 시스템의 환경변수를 가져와서 해당 내용을 자바에서 확인할 때, 사용하는 객체와 메서드를 기술하세요.
3. String 문자열이 만들어질 때까지 과정을 bit단위부터 기술해보세요.
4. String 생성자를 통해, 알파벳 대문자 8자의 임의의 비밀번호를 만들려고 한다. 
    byte[] 배열을 이용하여 처리하세요.
5. 학번을 연도(2자리)학년(2자리)반(1자리)성별(F/M)로 만들어서 처리할 때, 
    charAt와 substring을 활용해서 해당 내용을 추출하여
    @@@ 년도 입학, @@학년 @@반 남자/여자 로 출력하세요
6. 요일별로 중국집에 오늘은 메뉴를 바꿀려고 한다.
    요일을 랜덤으로 나오게 하여, 요일과 메뉴출력하는 란을 변경처리하세요
    오늘은 @@ 요일 @@ 메뉴 추천
    월 @@
    화 @@
    수 @@
    목 @@
    금 @@
    토 @@
7. 다음과 같은 데이터를 2중 반복문으로 처리하여 구매 물품을 리스트 하세요.
   split(), StringTokenizer 둘다 활용
    사과&3000&2/바나나&4000&3/딸기&12000&5
6. 함수의 두가지 유형은 기술하세요..(DB)
7. 사원명을 대소문자 구분없이 a를 입력했을 때, 해당 사원을 keyword검색되게 sql을 처리하세요(DB)

	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 
		System.out.println("# 1. 현재 시스템에 대한 정보 확인 #");
		
		// .getPRoperty("속성") : 시스템에 등록되어있는 운영체제의 이름이나 사용자의 이름, 홈디렉토리 가져오기
		// 				메소드 호출시 설정한 속성에 대한 한가지 정보만 가져옴
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");		
		
		System.out.println("운영체제 이름 : " + osName);
		System.out.println("사용자 이름 : " + userName);
		System.out.println("사용자 홈디렉토리 : " + userHome);	
		
		// .getProperties() : 시스템의 모든 정보를 Properties 객체로 가져온다.
		Properties properties = System.getProperties();
		
		// .keySet() : 내용들을 Set 형식의 key를 이용해 value들을 가져온다. 
		Set keys = properties.keySet(); 
		
		for(Object obKey:keys) {
			String key = (String) obKey; // 배열 형태로 되어있는 데이터를 하나씩 가져오고
			String value = System.getProperty(key); 
			// .getProperty에 key를 이용해 모든 정보를 불러온다. 
			System.out.println(key + " : " + value);
		}
		
		
		// 2. 
		// Map 형식을 이용해 환경변수 key를 이용해 환경변수에 대한 정보를 가져온다.  
		// System.getenv("Path") : 환경변수의 key인 Path를 입력해 환경변수의 설정된 값을 가져온다.
		Map maps = System.getenv();
		String paths = System.getenv("Path");
		
		System.out.println("\n# 2. 환경변수 정보 확인 #");
		System.out.println("환경변수의 Path : " + paths);
		
		
		// 3.
		// bit란 데이터의 최소단위를 말하며 0, 1로 이루어져있다. 이 bit가 8개가 모이면 byte가 된다.
		// byte는 정수형의 가장 기본인 데이터가 되는데 컴퓨터로 처리를 하기 위해서
		// byte의 숫자에 코드를 대입하여 코드값에 해당하는 'A', 'B'처럼 문자를 설정할 수 있게 되었다.
		// 이러한 문자들을 모아서 char[] 배열로 문자열을 표현하다가 객체지향 프로그램에서는
		// String이라는 데이터형을 만들어 문자열을 표현하게 되었다. 
		// char[] : {'b', 'y','t','e'} --> String : "byte" 
		
		
		// 4. 
		byte[] password = {70, 83, 65, 79, 77, 90}; 
		
		System.out.println("\n# 4. 임의의 대문자 비밀번호 #");
		for(int i = 0; i < password.length; i++) {
			System.out.print((char) password[i]);
		}
		System.out.println();
		
		
		
		// 5.
		String scNum = "21023F"; // 학번 : 연도(2자리)학년(2자리)반(1자리)성별(F/M)
		
		String scYear = scNum.substring(0, 2);
		String scgrade = scNum.substring(2, 4);
		String scClass = scNum.substring(4, 5);
		char scGender = scNum.charAt(5);
		
		System.out.println("\n# 5. 학생정보 #");
		if(scGender == 'F') {
			System.out.println(scYear + "년도 입학, " + scgrade + "학년 " + scClass + "반 여자");
		} else {
			System.out.println(scYear + "년도 입학, " + scgrade + "학년 " + scClass + "반 남자");
		}
		
		
		
		// 6.
		int ranDay = (int) (Math.random()*6 + 1);
		String menu = "오늘은 월요일 짜장면 메뉴 추천~!";
		
		System.out.println("\n# 6. 메뉴 추천 #");
		System.out.println(menu);
		System.out.println("random : " + ranDay + "\n");

		int num1 = menu.indexOf("메뉴") - 4; // 메뉴 시작 부분
		String strMenu = menu.substring(num1, num1+3); 
		
		switch(ranDay) {
			case 1 : 
				menu = menu.replace(menu.charAt(menu.indexOf("요일")-1), '월');
				menu = menu.replace(strMenu, "짜장면");
				System.out.println(menu);
				break;
			case 2 :
				menu = menu.replace(menu.charAt(menu.indexOf("요일")-1), '화');
				menu = menu.replace(strMenu, "수제비");
				System.out.println(menu);
				break;
			case 3 :
				menu =menu.replace(menu.charAt(menu.indexOf("요일")-1), '수');
				menu =menu.replace(strMenu, "볶음밥");
				System.out.println(menu);
				break;
			case 4 :
				menu = menu.replace(menu.charAt(menu.indexOf("요일")-1), '목');
				menu = menu.replace(strMenu, "짬뽕밥");
				System.out.println(menu);
				break;
			case 5 :
				menu = menu.replace(menu.charAt(menu.indexOf("요일")-1), '금');
				menu = menu.replace(strMenu, "미역국");
				System.out.println(menu);
				break;
			case 6 :
				menu = menu.replace(menu.charAt(menu.indexOf("요일")-1), '토');
				menu = menu.replace(strMenu, "비빔밥");
				System.out.println(menu);
				break;
			default : 
				System.out.println("처리 실패..");
		}
		
		
		// 7. 
		String data1 = "사과&3000&2/바나나&4000&3/딸기&12000&5";
		String[] data2 = data1.split("/");
		
		System.out.println("\n# 7. split()을 이용한 문자열 분할 #");
		for(String a:data2) {
			String[] data3 = a.split("&");
			for(String b:data3) {
				System.out.println(b);
			}
		}	
		
		StringTokenizer sz1 = new StringTokenizer(data1, "/");
		int count1 = sz1.countTokens();
		
		System.out.println("\n# 7. StringTokenizer를 이용한 문자열 분할 #");
		for(int x=1; x<=count1; x++) {
			StringTokenizer sz2 = new StringTokenizer(sz1.nextToken(), "&");
			//int count2 = sz2.countTokens();
			
			for(int y=1; y<=count1; y++) {
				String to = sz2.nextToken();
				System.out.println(to);
			}
		}	
	}
}
