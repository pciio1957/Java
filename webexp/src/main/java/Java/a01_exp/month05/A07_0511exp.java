package Java.a01_exp.month05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class A07_0511exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1번문제
		System.out.println("# 1. 출/퇴근 확인 #");
		Worker[] wor = {new PoliceMan(),
						new FireMan(),
						new Programmer()};
		
		for(Worker w:wor) {
			w.working();
			w.goWork();
			w.goHome();
		}
		
		
		// 2번문제
		/*
		 1. Set 객체 : 순서 상관 X, 중복 허용 X
		 2. List 객체 : 순서 상관 O, 중복 허용 O
		 3. Map 객체 : 순서 상관 O, 중복 허용 (key X, value O)
		*/
		
		
		// 3번문제
		Set<Fruit> fruit = new HashSet<Fruit>();
		fruit.add(new Fruit("바나나", "노랑색"));
		fruit.add(new Fruit("사과", "빨강색"));
		fruit.add(new Fruit("키위", "초록색"));
		
		System.out.println("# 3. 항아리에 담긴 과일 #");
		for(Fruit f:fruit) {
			f.choice();
		}
		System.out.println("\n");
		
		
		// 4번문제 
		List<Student> stu = new ArrayList<Student>();
		stu.add(new Student("김", 84, 86, 90));
		stu.add(new Student("이", 50, 40, 70));
		stu.add(new Student("박", 77, 58, 70));
		stu.add(new Student("진", 68, 69, 70));
		stu.add(new Student("유", 99, 99, 95));
		
		System.out.println("# 4. 기말고사 시험성적표 #");
		System.out.println("학생명\t국어\t영어\t수학");
		for(Student s:stu) {
			System.out.print(s.getName() + "\t");
			System.out.print(s.getKor()+ "\t");
			System.out.print(s.getEng()+ "\t");
			System.out.print(s.getMath()+ "\n");
		}
		
		
		// 5번문제
		/*
		 Map의 하위 기능 메소드
		 1) put("key", value객체) : Key값과 value값 할당
		 2) keySet() : Set객체로 전체가 중복되지 않는 키 할당
		 3) get(Key값) : Map객체에 포함된 key에 해당하는 값 가져오기 
		*/
		
		
		// 6번문제
		/*
		 1. InputStream 기본 형식
		 InputStream is = System.in;
		 
		 try{ 
		 	char ch = (char) ch.ReadLine();
		 } catch (IOException e) {
		 } finally {
		 	is.close(); 
		 }
		 
		 2. 기본 메소드
		 	1) read() : 문자 1byte 읽어들이기 
		 				해당 문자는 code값으로 연결되어있어서 정수형이다.
		*/
		
		
		// 7번문제
		String pass = "";
		for(int i=0; i<4; i++) {
			int pRandom = (int) (Math.random() * 26 + 65);
			pass += (char) pRandom;
		}
		
		for(int i=0; i<3; i++) {
			int pRandom = (int) (Math.random() * 10 + 48);
			pass += (char) pRandom;
		}
		
		System.out.println("\n# 7. 임시비밀번호 출력 #");
		System.out.println("임시변경된 비번: " + pass + "\n");
		
		
		
		// 8번문제
		Scanner sc = new Scanner(System.in);
		String[] pName = new String[3];
		String[] pPoint = new String[3];
		
		System.out.println("\n# 8. 야구선수 성적입력표 ");
		for(int idx=0; idx<pName.length; idx++) {
			System.out.print("야구선수의 이름을 입력하세요 -> ");
			pName[idx] = sc.nextLine();
			System.out.print("야구선수의 점수를 입력하세요 -> ");
			pPoint[idx] = sc.nextLine();
		}
		
		System.out.println("\n# 8. 야구선수 성적출력표 ");
		System.out.println("이름\t성적");
		for(int idx=0; idx<pName.length; idx++) {
			System.out.println(pName[idx] + "\t" + pPoint[idx]);
		}
		
		
	}

}

// 1번문제
abstract class Worker {
	
	// 추상메소드
	void working( ) {};
	
	// 공통 기능 메소드
	public void goWork() {
		System.out.println("출근합니다!");
	}
	
	public void goHome() {
		System.out.println("퇴근합니다!\n");
	}
}

class PoliceMan extends Worker {
	public void working() {
		System.out.println("경찰관입니다");
	}
}
class FireMan extends Worker {
	public void working() {
		System.out.println("소방관입니다");
	}
}
class Programmer extends Worker {
	public void working() {
		System.out.println("개발자입니다");
	}
}

// 3번문제
class Fruit {
	String b;
	String c;
	
	public Fruit(String b, String c) {
		super();
		this.b = b;
		this.c = c;
	}
	
	public void choice() {
		System.out.println(c + " 과일은 " + b);
	}
}

