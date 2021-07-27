package Java.a01_exp.month05;

import java.util.ArrayList;
import java.util.Scanner;

import Java.a05_condition.Student2;

public class A11_0518exp {
	
/*
#마무리문제

1. while문과 do while문의 형식을 기술하고
while문을 통해서 아래와 같이 입력한 범위의 숫자의 합을
아래형식으로 출력하세요
마지막 숫자 : @@
1 + 2 + 3 + 5 = 11


2. while문을 이용해서 아래와 같이 
번호를 선택해서 해당 번호의 물건명과 가격 갯수를 입력해서 총 비용을 출력하세요
= 메뉴 =
1. 사이다 800
2. 콜라 1200
3. 캔커피 900
완료하시겠습니까? (Y/N)
1단계) 구매한 물건만 표시
2단계) 총비용 표시
3단계) 구매한 물건/갯수/단가/단위계 - ArrayList<클래스>로,하면 쉬움
	총계: @@ 표시

3. do while문으로 다음 예제를 진행하세요
어서오세요
갈비탕(12000) 전문집입니다.
@@ 회 방문입니다.
맛나게 먹고갑니다
또 방문하시겠습니까? (Y/N)
총 방문횟수 : @@, 총 지불비용: @@@


4. while/do while을 이용해 
컴퓨터와 함께하는 임의의 숫자 맞추기 게임
랜덤에 의해서 임의으 숫자가 (1~100)를 설정하면
맞출때까지 반복문을 수행하는데 
hint로 보다 크다/ 보다 작다를 입력시마다 나오게 처리하기

5. continue문을 이용해서 1~12월 근무를 하되
3달마다 "SM 유지보수하다"
그외는 "SI 프로그래밍개발을 하다" 로 처리하기


6. Student 클래스에 번호, 국어, 영어, 수학 속성을 할당하고
학생 5명을 ArrayList<Student>에 담아서 출력하기
*/

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1번문제 
		/*
		1) while의 형식
		while(조건) {
			// 조건에 맞으면 수행할 코드
			// 조건에 맞아야 수행되므로 0번 실행될 수 있다
		}
		
		2) do while의 형식
		do {
			// 조건이 없으므로 적어도 1번은 실행될 코드
			// 적어도 1번은 실행되는 반복문이다.
		}while(조건)
		
		*/
		Scanner sc1 = new Scanner(System.in);
		System.out.println("# 1. 입력한 숫자의 누적합 #");
		System.out.print("숫자 입력 : ");
		int num1 = sc1.nextInt();
		int cnt1 = 1;
		int sum1 = 0;
		
		System.out.println("마지막 숫자 : " + num1);
		while(cnt1 <= num1) {
			sum1 += cnt1;
			
			System.out.print(cnt1 + " + ");
			cnt1++;
			
			if(cnt1 == num1) {
				sum1+=num1;
				System.out.println(num1 + " = " + sum1);
				break;
			}
		}
		
		
		// 2번문제
		Scanner sc2 = new Scanner(System.in);
		String[] fname = {"사이다", "콜라", "캔커피"};
		String[] fprice = {"800", "1200", "900"};
		String fCheck = "N";
		String fOrder = "";
		int fSum = 0;
		
		System.out.println("\n# 2. 자판기 #");
		
		while(fCheck.equals("N")) {
			System.out.println("1. 사이다 800");
			System.out.println("2. 콜라 1200");
			System.out.println("3. 캔커피 900");
			System.out.print("메뉴 선택 : ");
			int choiceMenu = sc2.nextInt(); // 메뉴 선택
			System.out.print("개수 입력 : ");
			int choiceCnt = sc2.nextInt(); // 갯수 입력
			String x = sc2.nextLine(); 
			
			fOrder += fname[choiceMenu-1]+ " ";
			fSum += Integer.parseInt(fprice[choiceMenu-1]) * choiceCnt;
			
			System.out.print("완료하시겠습니까? (Y/N) : ");
			fCheck = sc2.nextLine();
		}
		// 1단계..
		System.out.println("총 구매 내역: " );
		System.out.println(fOrder);
		
		// 2단계.. 
		System.out.println(fSum + "");
		
		
		// 3번문제
		Scanner sc3 = new Scanner(System.in);
		int cnt3 = 1;
		int sum3 = 0;
		String gCheck = "Y";
		
		System.out.println("\n# 3. 어서오세요 #");
		System.out.println("갈비탕(12000) 전문집입니다.");
		do {
			
			System.out.println(cnt3++ + "회 방문입니다");
			sum3 += 12000;
			System.out.println("맛나게 먹고갑니다~");
			System.out.print("또 방문하시겠습니까? (Y/N) : ");
			gCheck = sc3.nextLine();
			
		}while(gCheck.equals("Y"));
		
		System.out.println("총 방문횟수 : " + (cnt3-1));
		System.out.println("총 지불비용 : " + sum3);
		
		
		
		// 4번문제
		Scanner sc4 = new Scanner(System.in);
		int ranNum4 = (int) (Math.random() * 101 + 1);
		int choNum;
		
		
		System.out.println("\n # 4. 랜덤 숫자 맞추기 #");
		do {
			System.out.print("=> 숫자 입력 : ");
			choNum = sc4.nextInt();
			
			if(ranNum4>=choNum) {
				System.out.println("보다 큽니다!");
			} else {
				System.out.println("보다 작습니다!");
			}
			
		}while (ranNum4!=choNum);
		
		System.out.println("** 정답입니다! 정답은 " + ranNum4 + "**");
		
		
		// 5번문제
		for(int i=1; i <= 12; i++) {
			if(i%3==0) {
				System.out.println(i + "월은 SM 유지보수하다");
			} else {
				System.out.println(i + "월은 SI 프로그래밍 개발을 하다");
			}
		}
		
		
		// 6번문제
		ArrayList<Student2> slist = new ArrayList<Student2>();
		String sName[] = {"홍길동", "김길동", "이길동","유길동","하길동"};
		slist.add(new Student2("1", "80", "90", "100"));
		slist.add(new Student2("2", "77", "75", "72"));
		slist.add(new Student2("3", "80", "83", "92"));
		slist.add(new Student2("4", "89", "90", "91"));
		slist.add(new Student2("5", "50", "48", "62"));
		
		System.out.println("# 6. Student 성적표 #");
		System.out.println("이름\t번호\t국어\t영어\t수학");
		for(int i=0; i<slist.size();i++) {
			Student2 s = slist.get(i);
			s.show(sName[i]);
		}
		
		
		
		
	}
}