package Java.a02_basic;

import java.util.Scanner;

public class A02_ClassBound {
	
	/*
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 응용1) 코드 계층적 block 처리
		// 		아래의 Calcu 클래스를 선언하고 입력값 2개로 사칙연산을 처리하는 코드를 처리하되,
		//		변수의 중괄호 선언 규칙에 의해 선언하고 할당, main()을 통해서 호출하기
		Scanner sc = new Scanner(System.in);
		System.out.print("더할 첫번쨰 값을 입력하세요 ->  ");
		int num01 = sc.nextInt();
		System.out.print("\n더할 두번째 값을 입력하세요 ->  ");
		int num02 = sc.nextInt();
		
		Calcu cal = new Calcu(num01, num02);
		cal.plus();
		cal.minus();
		cal.multi();
		cal.division();

	}

}


class Calcu {
	// 필드 선언
	// 1. 이 클래스에서 다 사용할 수 있는 전역변수 : class의 {] (중괄호)에서
	// 	  선언되어 있음
	// 2. 이 클래스에서 모든 구성 멤버에서 사용될 수 있다.
	private int num1; 
	private int num2;
	private int tot;
	
	// 생성자 선언
	public Calcu(int n1, int n2) {
		// 매개변수로 받는 int num1은 지역변수이기에 다른 중괄호 블럭에서 사용할 수 없다.
		// 그러나 this.num1은 클래스변수인 전역변수를 뜻하므로 이 변수에 
		// 매개변수의 데이터를 할당해서 데이터를 사용할 수 있도록 한다.
		this.num1 = n1;
		this.num2 = n2;
	}
	

	// 기능메소드 선언
	public void plus() {
		// n2 = 1+2; 생성자에서 사용한 n2는 지역변수라서 이곳에서는 사용 불가
		
		// 연산자 조건 처리
		tot = num1 + num2; // tot 변수는 전역변수이므로 다른 메소드에서 사용가능
		System.out.println(num1 + " + " + num2 + " = " + tot);
	}
	
	public void minus() {
		tot = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + tot);
	}
	
	public void multi() {
		tot = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + tot);
	}
	
	public void division() {
		tot = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + tot);
	}
	
}
