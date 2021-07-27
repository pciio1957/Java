package Java.a01_exp.month05;

import java.util.Calendar;

public class A06_0510 {
	
	/*
	 
	 # 정리문제
	 1. Math.random()을 이용해 다양한 임의의 경우를 추출하고자 한다.
	 	기본형식을 정리하고 사원번호 1000~1020번까지 임의로 청팀/홍팀을
	 	배정하여 아래와 같이 출력하세요. for문 활용
	 	1000 청팀
	 	1001 청팀
	 	1002 홍팀
	 	
	 	1단계) 1000 0
	 	2단계) 1001 0
	 	3단계) 1002 1
	 	
	 2. 반학생 1~30번의 점수를 0~100까지 임의로 나오게 하고, 평균점수를
	 	점수로 출력하세요
	 3. Calendar 객체의 생성의 기본 형식과 주요 상수를 정리하고
	 	오늘과 이번달 임의의 날짜와의 차이를 출력하세요
	 4. enum 상수의 주요 속성을 기술하고, cards의 종류 4가지
	 (하트, 스페이스, 크로바, 다이아몬드)를 설정해, 4가지 카드 중 임의로 선택 후 출력
	 5. 객체형 배열의 생성 기본 형식을 기술하고 Student 객체에 
	 이름 국어 영어 수학 속성을 설정해 3명의 총점과 평균을 forEach구문을 통해 출력하기
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String teamName = "";

		// 1번문제
		System.out.println("\n# 1. 청팀/홍팀 #");
		for(int i=0; i<20; i++) {
			int team = (int) (Math.random()*2);
			int num1 =  (int) (Math.random()*20+1000);
			
			if (team==0) {
				teamName = "청팀";
			} else {
				teamName = "홍팀";
			}
			System.out.println(num1 + "\t" +teamName);
		}
		
		// 2번문제
		int sum = 0;
		
		System.out.println("\n# 2. 반학생의 평균점수 #");
		for(int x=1; x<=30; x++) {
			int kor = (int)(Math.random()*100); // 1부터 100번까지라서 101임
			System.out.println(x + "번 학생의 점수는 "+ kor);
			sum += kor;
		}
		
		System.out.println("평균 점수는 "+ sum/30);
		
		
		// 3번문제
		// Calendar 객체 생성의 기본 형식, 주요 상수(날짜, 시간)
		System.out.println("\n# 3. Calendar 객체 생성 형식 #");
		Calendar cal = Calendar.getInstance();
		System.out.println("연도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + cal.get(Calendar.MONTH)+1);
		System.out.println("일: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("시: " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분: " + cal.get(Calendar.MINUTE));
		System.out.println("초: " + cal.get(Calendar.SECOND));
		
		
		// 오늘과 이번달 임의의 날짜와의 차이
		/* 
		 사용하는 함수가 다르다 
		 오늘 날짜를 구하는 함수는 .get
		 임의의 날짜를 구하는 함수는 .set
		*/
		
		int ye = cal.get(Calendar.YEAR); // 오늘 날짜 구하기 
		int mon = cal.get(Calendar.MONTH)+1; 
		int da = cal.get(Calendar.DAY_OF_MONTH); 
		System.out.println("\n# 3. 오늘 날짜 #");
		System.out.println(ye + "년 " + mon + "월 " + da + "일");
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2021, 4, 25);
		int ye2 = cal2.get(Calendar.YEAR);
		int mon2 = cal2.get(Calendar.MONTH)+1; 
		int da2 = cal2.get(Calendar.DAY_OF_MONTH); 
		System.out.println("\n# 임의의 날짜 설정 #");
		System.out.println(ye2 + "년 " + mon2 + "월 " + da2 + "일" );
		
		// 4번문제
		/*
		enum : 상수를 열거하여 사용하는 방식
		public enum cards{Heart, space, croba, diamond}; 
		사용가능한 함수
		.name() : enum에 선언된 이름
		.value() : 선언된 배열의 값
		.ordinary() : 선언된 배열의 index값
		*/
		
		System.out.println("\n# 4. 카드 랜덤 선택 #");
		cards[] ca = cards.values();
		int ran = (int) (Math.random()*4);
		String caName = "";
		
	
		System.out.println("\n선택된 카드는 " + ran+ "번째 카드인 " + ca[ran]);
		
		
		// 5번문제 - 객체형 배열의 생성 형식		
		Student[] sObjeArry = {new Student("김지은", 90, 80, 85),
					   new Student("김지금", 70, 50, 60),
					   new Student("김지동", 40, 80, 55)
		};
		
	
		System.out.println("\n # 5. 학생의 총점과 평균 # ");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(Student s:sObjeArry) {
			int tot = 0;
			tot += s.getKor() + s.getEng() + s.getMath();
			System.out.println(s.getName()  + "\t" +s.getKor() + "\t" 
			+ s.getEng() + "\t" + s.getMath() + "\t" + tot 
			+ "\t" + tot/3);
			 
		}	
	}
	
	// 4번문제 - 열거형 enum 선언
	public enum cards{Heart, space, croba, diamond}; 

}

// 5번문제 - Student 클래스 
class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	
	
	
}
