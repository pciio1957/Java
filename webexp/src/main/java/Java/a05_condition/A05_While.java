package Java.a05_condition;

import java.util.Scanner;

public class A05_While {
	
	
	/*
	
	#While
	1. 조건에 따라 반복 여부를 결정할 떄 사용되는 구문
	2. 형식
		while(반복조건) {
			// 반복을 수행할 코드
		}
	3. 주로 반복 block에 있는 값의 입력으로 반복 여부를 결정할 떄 사용된다.
	
		
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cnt = 1;
		System.out.println("반복문 시작");
		while(cnt<=10) {
			System.out.println("번호 : " + cnt);
			cnt++;
		}
		System.out.println("반복문 종료 ");
		
		
		// 응용) while문을 이용해서 과일가격이 3000원인 사과를 10개 구매하는
		//		비용을 1~10까지 출력하기
		
		int i = 1;
		int applePay = 3000;
		int tot = 0; 
		
		System.out.println("\n# 사과 구입표 #");
		while(i<=10) {
			tot += applePay;
			System.out.println("사과\t" + i + "\t" + tot);
			i++; // 증감을 안하면 무한 루프를 도니까 조심하기.. 깜놀함
		}
		
		// 실습 
		Scanner sc = new Scanner(System.in);
		String order = ""; // 주문내역
		while(true) { // true값을 주면 무한루프, {}안에서 적절한 데이터가 나오면 나가도록 설계
			System.out.print("\n # 주문을 받습니다 # : ");
			// 입력받은 데이터를 누적 처리
			order += sc.nextLine()+ " "; 
			System.out.println("현재까지 주문한 내역 : ");
			System.out.println(order);
			System.out.print("주문을 종료하시겠습니까? (Y/N) : ");
			
			// 종료할 수 있는 문자열을 지정하여 처리
			if(sc.nextLine().equals("Y")) {
				System.out.println("주문 완료! \n");
				// break문을 통해서 while문을 벗어나게 처리, 없으면 무한루프 ..
				break;
			}
		}
		
		System.out.println(" # 최종 주문 내역 #");
		System.out.println(order);
		
		
		
		// 응용) while문을 이용해서 구매한 금액을 입력한 뒤 
		//		구매의사를 물어보고 끝나면 최종 금액을 출력하기
		// 	sc.nextLine(), Integer.parseInt(sc.nextLine()) 이용
		// sc.next()는 제대로 입력을 받지 못해서,, 
		
		Scanner s = new Scanner(System.in);
		int sum = 0; // 누적할 변수
		
		System.out.println("\n # 구매한 금액 누적 # ");
		while(true) {
			System.out.print("구매금액 입력 : ");
			int money = Integer.parseInt(s.nextLine());
			sum += money; // 누적
			
			System.out.print("그만 구매하시겠습니까? (Y/N) : ");
			if(s.nextLine().equals("Y")) {
				System.out.println("구매 완료!");
				break;
			}
		}
		
		System.out.println("총 구매 금액 : " + sum);
		
		
		
	}

}
