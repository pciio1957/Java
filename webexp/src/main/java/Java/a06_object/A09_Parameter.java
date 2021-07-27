package Java.a06_object;

import java.util.Scanner;

public class A09_Parameter {
	
	/*
	
	#매개변수
	1. 매개변수는 해당 type을 할당하면 데이터를 받아서 처리한다.
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product();
		p1.setPrice(200);
		
		byte num01 = 24; // promote : 큰 데이터안에 작은 값 넣기
		p1.setPrice(num01);
		
		char ch01 = 'A';
		p1.setPrice(ch01); // promote 
		
		// 선언된 갯수와 type에 맞게 데이터를 넘겨줘야 한다
		p1.calcu(300, 2);
		p1.calcu(4000, 5);
		
		
		// 응용) Calculator 클래스에 
		//		1) 기본유형의 데이터를 받는 메소드 선언 출력 처리
		//		2) plus() : 두개의 값을 합산
		//		   multi() : 두개의 값을 곱셈처리
		//		모든 데이터가 다 입력이 가능하게 처리 (3조)
		
		// 넘 복잡하게 함, 걍 제일 큰 데이터형으로 double로 받았어야함
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 정수형");
		System.out.println("2. 문자열");
		System.out.println("3. 실수형");
		System.out.print("입력할 데이터의 유형 입력 : ");
		int chNum = sc.nextInt();
		System.out.println("1. 더하기");
		System.out.println("2. 곱하기");
		System.out.print("연산의 유형 입력 : ");
		int chNum2 = sc.nextInt();
		
		if(chNum == 1) {
			System.out.print("첫번째 숫자 입력 : " );
			int num1 = sc.nextInt();
			System.out.print("두번째 숫자 입력 : " );
			int num2 = sc.nextInt();
			
			Calculator cal1 = new Calculator();
			cal1.setNum(num1, num2);
			
			if(chNum2 == 1) {
				cal1.plus();
			} else {
				cal1.multi();
			}
			
			
		} else if(chNum == 2) {
			sc.nextLine();
			System.out.print("첫번째 데이터 입력 : " );
			String str1 = sc.nextLine();
			System.out.print("두번째 데이터 입력 : " );
			String str2 = sc.nextLine();
			
			Calculator cal2 = new Calculator();
			cal2.setNum(str1, str2);
			
			if(chNum2 == 1) {
				cal2.plus();
			} else {
				cal2.multi();
			}
			
		} else if (chNum == 3) {
			System.out.print("첫번째 숫자 입력 : " );
			double num3 = sc.nextDouble();
			System.out.print("두번째 숫자 입력 : " );
			double num4 = sc.nextDouble();
			
			Calculator cal3 = new Calculator();
			cal3.setNum(num3, num4);
			
			if(chNum2 == 1) {
				cal3.plus();
			} else {
				cal3.multi();
			}
		}
		
	}

}

class Product {

	// 1. 새로운 클래스안에 기능 메소드 생성 (정수형 데이터를 입력받는 메소드)
	void setPrice(int price) {
		System.out.println("입력된 값 : " + price);
		System.out.println("입력된 값 연산 : " + price*0.1);
	}
	
	void calcu(int price, int cnt) {
		System.out.println("물건가격 : " + price);
		System.out.println("물건갯수 : " + cnt);
	}
}

// 응용
class Calculator {
	int num01 = 0;
	int num02 = 0;
	String str1 = "";
	String str2 = "";
	double num03 = 0;
	double num04 = 0;
	
	void setNum(int n1, int n2) {
		num01 = n1;
		num02 = n2;
	}
	
	void setNum(String s1, String s2) {
		str1 = s1;
		str2 = s2;
	}
	
	void setNum(double n1, double n2) {
		num03 = n1;
		num04 = n2;
	}
	
	
	void plus() {
		
		if(num01 != 0) {
			int tot1 = num01 + num02;
			System.out.println("더하기 결과 : " + tot1);
		} else if (str1.equals("")) {
			int tot2 = Integer.parseInt(str1) + Integer.parseInt(str2);
			System.out.println("더하기 결과 : " + tot2);
		} else if (num03 != 0) {
			double tot3 = num03 + num04;
			System.out.println("더하기 결과 : " + tot3);
		} else {
			System.out.println("데이터가 잘못되었습니다");
		}
	}
	
	void multi() {
		if(num01 != 0) {
			int tot1 = num01 * num02;
			System.out.println("곱하기 결과 : " + tot1);
		} else if (str1.equals("")) {
			int tot2 = Integer.parseInt(str1) * Integer.parseInt(str2);
			System.out.println("곱하기 결과 : " + tot2);
		} else if (num03 != 0) {
			double tot3 = num03 * num04;
			System.out.println("곱하기 결과 : " + tot3);
		} else {
			System.out.println("데이터가 잘못되었습니다");
		}
	}
	
	
	
}