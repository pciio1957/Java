package Java.a14_generic;

import java.util.ArrayList;
import java.util.List;

import Java.a06_object.vo.Product;
import Java.a06_object.vo.Student;

public class A01_basic {
	
	/*
	#지네릭스 타입
	1. 컴파일 단계에서 잘못된 타입이 사용될 수 있는 문제를 제거할 수 있도록 해준다.
	2. 이점
		1) 컴파일 시 강한 타입의 체크 가능
			실행시 타입 에러가 나는 것 방지
			컴파일 시에 미리 타입을 강하게 체크해서 에러 사전 방지
		2) 타입변환 제거가능
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1) generic 사용 X
		// default로 모든 객체를 할당할 수 있다
		List list = new ArrayList();
		list.add(new Product("사과", 3000, 2));
		list.add(new Product("바나나", 2000, 3));
		list.add(new Product("딸기", 1000, 7));
		
		// 반드시 typecasting이 필요하다
		Product p01 = (Product) list.get(0);
		
		
		// 2) generic 사용 O
		List<Product> plist = new ArrayList<Product>();
		plist.add(new Product("사과", 3000, 2));
		plist.add(new Product("바나나", 2000, 3));
		plist.add(new Product("딸기", 1000, 7));
		
		// generic으로 사전에 입력할 객체 type을 선언했기 때문에
		// 형변환없이 사용가능하다. 
		Product p02 = plist.get(0);
		
		
		
		
		// 응용) Student(이름, 국어, 영어, 수학)을 List<Student> 형태로
		//		generic으로 선언하고 할당하여 이름, 국어, 영어, 수학점수를 출력하세요 (2조)
		
		List<Student> slist = new ArrayList<Student>();
		slist.add(new Student("홍길동", 67,89,86));
		slist.add(new Student("신길동", 88,97,92));
		slist.add(new Student("김길동", 62,55,43));
		
		System.out.println("이름\t국어\t영어\t수학");
		for(int idx=0; idx<slist.size();idx++) {
			System.out.print(slist.get(idx).getName() + "\t");
			System.out.print(slist.get(idx).getKor()+ "\t");
			System.out.print(slist.get(idx).getEng() + "\t");
			System.out.print(slist.get(idx).getMath() + "\n");
		}
		
	}

}
