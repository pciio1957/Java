package Java.a09_api;

import java.util.StringTokenizer;

public class A12_String {
	
	/*
	
	#String 기능메소드 (이어서)
		5) "대상문자열".replace("찾는문자열", "변경할문자열") :
			대상 문자열에서 특정한 문자열을 다른 문자열로 변경할때 사용한다. 
		6) "문자열".substring(추출할시작위치, 추출할마지막위치) :
			특정한 문자열에서 문자열을 추출하여 문자를 만들때 사용한다.
		7) "문자열".split("구분자") :
			특정문자열을 구분자에 의해 구분해서 구분된 데이터를 배열로 할당 처리
	
	#StringTokenizer("문자열", "구분자")
	1. 기능메소드
		1) countTokens() : 구분자를 통해 나온 데이터의 건수
		2) nextToken() : 구분자를 통해서 각 데이터 하나씩 나옴. 
			호출할 때마다 데이터를 하나씩 가져온다.
		3) hasMoreTokens() : 해당 데이터가 있을 때 true, row 단위로 변경처리
			주로 while문에 사용된다.
		
			
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 5) replace() 실습
		String target = "자바는 객체지향프로그램입니다. \n "
				+ "자바는 풍부한 API를 지원합니다. ";
		String newStr = target.replace("자바", "JAVA");
		
		System.out.println("기존 문자열 : " + target);
		System.out.println("변경 문자열 : " + newStr);
		
		
		// 6) substring() 실습
		String subStr = target.substring(4, 12);
		System.out.println("추출 문자열 : " + subStr);
		
		
		// 응용6) 자신의 주민번호를 통해서 생년월일을 추출하여 
		//		주민번호 : @@@@
		// 		@@년 @@월 @@일 생입니다 출력(4조)
		String jNum = "950402-12345767";
		
		String jYear = jNum.substring(0, 2);
		String jMonth = jNum.substring(2, 4);
		String jDay = jNum.substring(4, 6);
		System.out.println(jYear + "년 " + jMonth 
				+ "월 " + jDay + "일 생입니다.");
	
		
		
		// 7) split() 실습
		String data01 = "사과&바나나&딸기";
		String[] fruits = data01.split("&");
		// = {"사과", "바나나", "딸기} 로 만듬
		// forEach 구문 : for(단위데이터:배열) {}
		for (String fruit:fruits) {
			// 반복문을 통해서 배열 안에 구성하는 요소를 
			// 하나씩 뽑아서 fruit변수에 담고 그것을 출력 처리
			System.out.println(fruit);
		}
		
		// 응용7) 서울-대구-대전-부산 나열된 문자열을 split 구분을 통해서 처리하고
		//		해당 내용을 forEach 구문을 통해서 출력하기 
		String map = "서울-대구-대전-부산";
		String[] maps = map.split("-");
		
		for(String m:maps) {
			System.out.println(m);
		}
		
		// 마무리문제,, & - 가 들어있는 경우 이중 for문으로 처리
		
		
		// StringTokenizer 실습
		StringTokenizer st = new StringTokenizer("오렌지&수박&딸기","&");
		int count = st.countTokens();
		
		System.out.println("# Tokens #");
		for(int cnt = 1; cnt <= count ; cnt++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		st = new StringTokenizer("홍길동/김길동/신길동", "/");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		
		// 응용8) StringTokenizer를 활용해 물건명@가격@갯수로 
		//		해당 데이터 출력하기 (for문/while문 둘다 사용)
		StringTokenizer sz = new StringTokenizer("노트북@1200000@1", "@");
		int count2 = sz.countTokens();
		
		System.out.println("# 응용 Tokens #");
		// for문 사용시 1부터 시작..
		for(int i = 1 ; i <= count2 ; i++) {
			String token = sz.nextToken();
			System.out.println(token);
		}
		
		sz = new StringTokenizer("자바책@16000@5","@");
		while(sz.hasMoreTokens()) {
			String token = sz.nextToken();
			System.out.println(token);
		}
		
	}

}
