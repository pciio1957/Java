package Java.a01_exp.month05;

public class A01_0504a {
static int coke(int num1) {
	int tot = num1 - 900;
	return tot;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//문제1
		System.out.println("hello java");
		
		// 문제2
		String name = "김지은";
		int age = 27;
		String hobby = "넷플보기";
		System.out.println("\n나의 이름은 " + name); 
		System.out.println("나의 나이는 " + age); 
		System.out.println("나의 취미는 " + hobby); 
		
		//문제3-1
		int bear = 3;
		int cnt1 = 5;
		int tot1 = bear * cnt1;
		System.out.println("\n곰돌이가 먹은 빵의 총개수: " + tot1);
		
		//문제3-2
		int bread = 20;
		int eat = bread / bear;
		int noeat = bread % bear;
		System.out.println("\n곰돌이가 먹은 빵의 개수: " + eat);
		System.out.println("곰돌이가 먹고 남은 빵의 개수: " + noeat);
		
		//문제3-3
		int totalmoney = 100000;
		int trans = 3000;
		int meal = 7000;
		int snack = 3000;
		int tot2 = totalmoney - (trans * 2) - meal - snack;
		System.out.println("\n남은 잔액: " + tot2);
		
		//문제4
		int comprice = 200000;
		if(comprice>=1000000) {
			System.out.println("\n고가입니다");
		}else {
			System.out.println("\n저가입니다");
		}
		
		//문제5-1
		System.out.println("\n");
		for(int cnt2=30; cnt2<=50; cnt2++) {
			System.out.println("반복문1 카운트다운: " + cnt2);
		}
		
		//문제5-2
		System.out.println("\n");
		for(int cnt3=10; cnt3>=0; cnt3--) {
			System.out.println("반복문2 카운트다운: " + cnt3);
		}
		
		//문제 6
		System.out.println("\n콜라 자판기의 잔액: "+ coke(2000));
		//if문을 이용해서 0원아래면 지급X 이상일때 콜라 지급하는것도 하심
		
		//문제7
		/*
		 	자바의 작은 메모리는 바로 할당하여 사용할 수 있지만
		 	큰 메모리의 경우 heap영역을 이용해 할당하고, 주로 객체와 배열이 생성된다.
		 	그리고 이 heap영역의 주소값은 stack영역에 할당하여 참조한다.
		*/

	}

}
