package Java.a06_object;

public class A11_Process {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcessExp pe = new ProcessExp();
		pe.loop(5, 20);
		pe.countDown(1, 10);
		pe.bonusCal(1000);
		
		
		// 응용) countDown(시작값, 마지막) : 카운트다운 처리하는 기능메소드
		// 		bonusCal(입력값) : 입력값과 30%의 값을 합산한 결과 출력하는 기능메소드
		pe.countDown(1, 10);
		pe.bonusCal(1000);
	}

}

class ProcessExp {
	// 반복문의 시작값과 끝값을 매개변수로 넣고 반복문을 처리한다.
	void loop(int start, int end) {
		System.out.println("# 반복처리 #");
		System.out.println("시작값 : " + start);
		System.out.println("마지막값 : " + end);
		for(int c=start; c<=end; c++) {
			System.out.print(c + "  ");
		}
		System.out.println();
	}
	
	// 응용 - 카운트다운
	void countDown(int s, int e) {
		System.out.println("\n카운트다운 시작!");
		for(int i = e; s <= i; i--) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
	
	// 응용 - 30%의값 합산
	void bonusCal(int n) {
		System.out.println("\n합산 시작!");
		System.out.println("합산값 : " + (n+(int)(n*0.3)));
 	}
}


