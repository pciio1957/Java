package Java.a09_api;

import java.util.Calendar;

public class A07_Calender {
	
	/*

	# 날짜데이터 처리 클래스 Calendar (시간 + 날짜 + 위치)
	1. 기본적으로 데이터의 처리방식이
		시간 -> 일 -> 주 -> 월 -> 년 단위로
		처리되는 객체를 생성하고 활용할 수 있게 처리해준다. 
	2. Calendar 객체의 생성 => .getInstance() (new가 아님)
	
	 
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// # 날짜처리 클래스 사용 순서
		// 1. 캘린더 객체 생성
		// 		클래스명.필드 : static 필드
		//		Calendar.DAY_OF_WEEK
		//		클래스명.대문자 : final이라는 필드가 붙어있는 상수(변경되지 않는 수)  
		//		클래스명.메소드() : static 필드
		// 		static 객체변수가 아닌 객체 공유 메모리 영역(클래스)
		Calendar cal = Calendar.getInstance();
		System.out.println("생성된 객체 : " + cal);
		// 생성되는 객체는 그레고릭캘린더임 (java.util.GregorianCalendar)
		// 1) 캘린더 객체는 위치(경도)에 따라 다르고 여러가지 날짜처리 규칙을 가지고 있다.
		// 2) 캘린더는 고유의 상수갑스로 년/월/일을 구할 수 있다. 
		// 		= 년도의 상수 값 (Calendar.상수 : 객체 생성없이 사용하는 static이고
		// 					  상수인 대문자를 가지고 있다)
		// Calendar.Year : static final 클래스 상수/클래스명.변수로 사용하기 때문.
		System.out.println("연도의 상수 Calendar. Year : " + Calendar.YEAR);
		System.out.println("Calendar.Month : " + Calendar.MONTH);
		System.out.println("Calendar.DAY_OF_MONTH : " + Calendar.DAY_OF_MONTH);
		System.out.println("요일상수 : " + Calendar.DAY_OF_WEEK);
		System.out.println("시 : " + Calendar.HOUR_OF_DAY);
		System.out.println("분 : " + Calendar.MINUTE);
		System.out.println("초 : " + Calendar.SECOND);
		
		// 3) 위에 선언된 고유의 상수값을 기준으로 현재 시간 구하기
		int year = cal.get(Calendar.YEAR);
		// 월은 고유의 문자(jan, fab..)로 되어 있어서 우리나라와 체계가 차이가 있다. 
		// 0부터 11까지의 index로 매핑되어 있음 -> 그래서 +1을 해서 우리나라의 1~12월로 연결
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "년 " + month + "월 " + day + "일");
		// 요일도 문자열로 연결, 0~6
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		
		int weekIdx = cal.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println("현재 요일 : " + days[weekIdx] +"요일입니다");
		
		
		// 응용1) 위에서 처리하는 상수와 처리되는 기준으로 
		// 		현재 int hour, minute, second를 할당하여 출력하세요
		// 		@@시 @@분 @@초
		
		int hour = cal.get(Calendar.HOUR); // 0 ~ 23
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println("현재 시간은 " + hour + "시 " + min +
				"분 " + sec + "초 입니다.");
		
		
		// 특정 날짜/시간 설정
		Calendar cal2 = Calendar.getInstance();
		// 월은 0부터 11까지의 index로, 1월 = 0, 12월 = 11이다.
		// cal.set(매개변수의 갯수와 유형) : 매개변수의 갯수와 유형을 설정한다
		// 여러가지 데이터를 저장할 수 있다. 
		cal2.set(2021, 1, 5); // 이렇게 설정 -> 2021년 10월 5일
		int year2 = cal2.get(Calendar.YEAR);
		int month2 = cal2.get(Calendar.MONTH)+1;
		int date2 = cal2.get(Calendar.DAY_OF_MONTH);
		System.out.println(year2 + "년 " + month2 + "월 " + date2 + "일");
		
		
		
		// 응용2) cal3을 만들고 자신의 생년월일을 설정하고, 다시 출력하기
		Calendar cal3 = Calendar.getInstance();
		// 월은 0부터 11까지의 index로, 1월 = 0, 12월 = 11이다.
		cal3.set(1995, 3, 2); // 이렇게 설정 -> 2021년 10월 5일
		int year3 = cal3.get(Calendar.YEAR);
		int month3 = cal3.get(Calendar.MONTH)+1;
		int date3 = cal3.get(Calendar.DAY_OF_MONTH);
		System.out.println(year3 + "년 " + month3 + "월 " + date3 + "일");
				
	}

}
