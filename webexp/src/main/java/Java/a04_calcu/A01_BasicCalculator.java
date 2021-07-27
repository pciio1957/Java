package Java.a04_calcu;

import java.util.Scanner;

public class A01_BasicCalculator {
	
	/*
	
	#연산이란?
	1. 데이터를 처리하여 결과를 산출하는 것을 말한다.
		연산자 : 연산에 사용되는 표시나 기호(+, -, *, /, %, =...)
		피연산자 : 연산 대상이 되는 데이터(리터럴, 변수)
		연산식 : 연산자와 피연산자를 이용해 연산의 과정을 기술하는 것
		
	#자바의 활용연산자들
	1. 사칙연산자와 나머지연산자
		+, -, *, /, %
		* : 곱셈
		% : 나눈 나머지값
		
		연산자로 데이터를 처리하는 경우 int형 이상에서만 할당하여 처리할 수 있다.
		byte num01 = 25 + 10; (x)
		
		정수형/정수형 -> 정수형의 몫만 가져올 수 있다.
			ex) 25/3 -> 8
		정수형/(double)정수형 -> 소숫점이하 처리시 피연산자가 하나이상 실수형이어야한다.
			ex) 10/(double)3 -> 3.33333..
			
	2. 비교연산자 
		1) 두 개의 값을 비교하여 결과로 boolean(true/false)값을 처리하는 연산자
			주로 조건 if(비교연산자), for(초기;비교연산자;증감), while(비교연산자)가 사용된다
		2) 종류
			== : 동일할 때, true
			!= : 같지 않을 때, true
			>= : 크거나 같을 때, true
			<= : 작거나 같을 때, true
			> : 클 때, true
			< : 작을 때, true	
	
	3. 부호연산자
		+, = 음수와 양수의 부호
		int num01 = 25;
		-num01 -> -25;
		
	4. 문자열을 이어주는 concat 연산자 : +
		"문자열1" + "문자열2" -> "문자열1문자열2"
		
	5. 증감연산자
		++, -- (1씩 증가 및 감소 처리)
		
	6. 대입연산자
		=
		ex) int num02 = 30; num02에 30을 대입 처리
		+= 대입증감 : 기존의 데이터에 증가범위로 누적처리
			num02 = num02+ 2; -> num02 += 2;
		-=, *=, /=, %=, &= ... >>>=(쉬프트연산자) ...
		
	7. 논리연산자
		1) ! : not, 비교연산자의 반대값 처리
				true -> false, false -> true
				ex) boolean isPass = true;
					if(!isPass) { -> true가 아닌 false일때 조건문 실행
					   System.out.println("시험에 떨어졌다");
					} else {
						System.out.println("시험 통과");
					}
		2) 논리연산자(비교연산자 + 비교연산자) : &&, ||
			비교연산자 && 비교연산자 -> 모두 true일때, true
			비교연산자 || 비교연산자 -> 모두 false일때, false
			비교&비교 와 비교&&비교의 차이 -> 프로세스를 축약, 앞이 false이면 뒤에 비교연산자 수행 X
			비교|비교 와 비교||비교의 차이 -> 프로세스를 축약, 앞에 true면 뒤에 비교연산자 실행 X
			ex) if(id.equals("himan") && pass.equals("7777")) {
				 	id/pass가 himan/7777일때 처리할 내용
				  	두 조건을 다 만족할때 처리할 내용 기술
				} 
				
				if(id.equals("goodman") || pass.equals("goodlady")) {
					둘 중에 하나만 만족하면 처리할 내용 기술
				}
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 
		
		int num01 = 25;
		int num02 = 5;
		System.out.println(num01 + " + " + num02 + " = " + (num01 + num02));
		System.out.println(num01 + " - " + num02 + " = " + (num01 - num02));
		System.out.println(num01 + " * " + num02 + " = " + (num01 * num02));
		System.out.println(num01 + " / " + num02 + " = " + (num01 / num02));
		System.out.println(num01 + " % " + num02 + " = " + (num01 % num02));
		
		// 응용) 위 사칙연산자 중 하나를 이용해 과일의 가격(price)은 3000 대입,
		// 구매할 갯수(cnt)는 5로 선언해 총 비용 출력하기
		
		int price = 3000;
		int cnt = 5;
		System.out.println("구매 총 비용은 " + (price * cnt));
		
		
		// 2. 비교연산자 예제
		System.out.println(num01 + " == " + num02 + " ==> " + (num01 == num02));
		System.out.println(num01 + " != " + num02 + " ==> " + (num01 != num02));
		System.out.println(num01 + " >= " + num02 + " ==> " + (num01 >= num02));
		System.out.println(num01 + " <= " + num02 + " ==> " + (num01 <= num02));
		System.out.println(num01 + " > " + num02 + " ==> " + (num01 > num02));
		System.out.println(num01 + " < " + num02 + " ==> " + (num01 < num02));
		
		// boolean으로 할당
		boolean isTrue = num01 >= num02; 
		
		// 응용) boolean으로 isPass 변수 선언 후 
		// point 점수 80을 두고, 70 이상일때 합격 여부 출력
		int point = 80;
		boolean isPass = point >= 70; 
		System.out.println("점수 : " + point);
		System.out.println("합격여부 : " + isPass);
		
		
		// 그 외에 논리연산자(비교연산자 + 비교연산자) : &&, || -> 다음에 진행
		// 삼항연산자, 대입연산자, 증감연산자 등..

		
		// 응용1) 임의의 값 1~10을 나오게 하여 부호 연산자로 음수를 처리하여 출력하기
		// 응용2) 문자열을 이어주는 +를 이용해 임의의 10자리 범위 두개의 값을 이어서 코드작성
		// 응용3) 대입 증감 및 감소 연산자를 이용해 
		// 		1~10까지 누적 증가된 총합을 출력하고
		// 		100~90까지 2씩 감소 누적된 값 출력하기 (4조 제출)
		
		
		// 응용1
		System.out.println("\n# 응용문제 풀이 #");
		for(int i = 0; i < 10; i++) {
			int ranNum1 = (int) (Math.random() * 10 + 1);
			System.out.println("(" + i+1 + ")" + ranNum1 + "의 부호연산자를 더하면 : " + -ranNum1);
		}
		
		// 응용2 
		// "" + 숫자형 -> "숫자형문자열"
		String nm1 = ""+(int)(Math.random() * 90 + 10); // 임의의 10자리 값, 문자열변환
		String nm2 = ""+(int)(Math.random() * 90 + 10); // 임의의 10자리 값, 문자열변환 
		System.out.println("문자열 더하기 : " + (nm1 + nm2));
		
		// 응용3
		int sum1 = 0;
		int sum2 = 0;
		
		for(int x=1; x <= 10; x++) {
			sum1 += x;		
		}
		
		System.out.println("1~10 누적총합 : " + sum1);
		
		for(int x=100; x>=90; x-=2) {
			sum2 += x;
		}
		System.out.println("100~90 누적총합: " +sum2);
		
		
		
		// 응용) 논리연산자 연습
		//		1) Scanner로 입력받아, himan이 아닐때를 먼저 체크해 등록된 사원이 아닙니다 출력
		//			그외는 등록된 사원입니다 출력
		//		2) 점수를 입력받아 90이상 A등급, 80~90미만은 B등급, && 연산자 활용 그외는 표시 X
		// 		3) 놀이공원 나이를 입력받아 5세 미만이거나 65이상이면 무료, 그외는 입장료 50000원
		
		// 응용1
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("\n# 1. 로그인 판별 #");
		System.out.print("아이디를 입력하세요 -> ");
		String id = sc1.nextLine();
		
		if (!id.equals("himan")) {
			System.out.println("등록된 사원이 아닙니다");
		} else {
			System.out.println("등록된 사원입니다");
		}
		
		// 응용2
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("\n# 2. 등급 환산 #");
		System.out.print("점수를 입력하세요 -> ");
		int pit1 = sc2.nextInt();
		
		if(pit1 >= 90) {
			System.out.println("A등급");
		} else if (pit1 >= 80 && pit1 < 90) {
			System.out.println("B등급");
		}
		
		// 응용3
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("\n# 3. 놀이공원 입장 나이 확인 #");
		System.out.print("나이를 입력하세요 -> ");
		int age = sc3.nextInt();	
		
		if(age >= 65 || age < 5) {
			System.out.println("입장료는 무료입니다");
		} else {
			System.out.println("입장료는 50000원입니다");
		}
		
		
		// 응용2) 논리연산자연습
		//		1) 1번~4번 중 정답 입력하기, not(!) 활용
		//			3번이 아닐때 오답입니다 출력, 그 외는 3인 경우 정답입니다		
		//		2) 구매금액을 입력해서 10000원~30000원인 경우 VIP 고객입니다, && 연산자 활용
		//		3) 점수를 입력받는데, 0 미만 100 초과일 경우 (|| 연산자 활용) 정상범위 @@점 입니다
		//			그 외는 입력 범위는 0~100입니다 아니면 범위를 벗어났습니다 
		
		// 응용1
		Scanner sc4 = new Scanner(System.in);
		int ok = 3; // 정답
		
		System.out.println("\n# 1. 문제 맞추기 #");
		System.out.print("정답을 입력하세요 -> ");
		int check = sc4.nextInt();
		
		if(check != ok) {
			System.out.println("오답입니다");
		} else {
			System.out.println("정답입니다");
		}
		
		// 응용2
		Scanner sc5 = new Scanner(System.in);
		
		System.out.println("\n# 2. 구매금액 확인 #");
		System.out.print("구매금액을 입력하세요 -> ");
		int amount = sc5.nextInt();
		
		if(amount>=10000 && amount <=30000) {
			System.out.println("VIP 고객입니다");
		} 
		
		// 응용3
		Scanner sc6 = new Scanner(System.in);
		
		System.out.println("\n# 3. 점수 확인 #");
		System.out.print("점수를 입력하세요 -> ");
		int pit2 = sc6.nextInt();
		
		if (pit2<0 || pit2>100) {
			System.out.println("범위를 벗어났습니다");
		} else {
			System.out.println(pit2 + "점으로 정상범위입니다");
		}
	}

}
