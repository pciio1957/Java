package Java.a01_exp.month05;

public class A04_0507exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1번문제
		/*
		 	interface 인터페이스명 {
				void 메소드명(); 
				// 기본적으로 public abstract가 선언되어있어서 생략가능 
			}
		*/

		// 2번문제
		SwimmingWay sw1 = new PoolSwimming();
		SwimmingWay sw2 = new LakeSwimming();
		SwimmingWay sw3 = new SeaSwimming();
		
		// 확인용
		sw1.swim();
		sw2.swim();
		sw3.swim();
		
		// 3번 문제
		Duck duck = new Duck();
		duck.swim();
		
		duck.setswim(new PoolSwimming());
		duck.swim();
		duck.setswim(new LakeSwimming());
		duck.swim();
		duck.setswim(new SeaSwimming());
		duck.swim();
		
		// 4번 문제
		/*  자바에서는 프로그래밍의 안정성을 확보하기 위해서 예외처리를 하도록 하고
		 	이 처리를 통해서 오류가 나더라도 프로그램이 제대로 종료될 수 있도록 한다
		 	try {
		 	 // 예외가 발생할 수 있는 코드
		 	} catch (오류종류) {
		 	 // 예외가 발생하면 처리될 코드
		 	}
		*/
		
		// 5번 문제
		/*
		 예외 처리 순서
		 1) 코드를 작성하고 실행해 오류가 나는 곳에서 발생하는 오류를 복사한다.
		 2) try 문에는 작성했던 코드를 넣고, 오류가 발생하면 할일은 catch문에 작성한다.
		 3) 복사한 오류는 catch문 조건에 붙여넣기한다
		 4) 예외가 제대로 처리되는지 확인한다.
		 
		*/
		
		//6번 문제
		/*
		 String 데이터형에 문자열을 대입하는 방법은 2가지가 있다.
		 1) String 변수명 = "데이터";
		 	이 경우에는 직접적으로 데이터를 삽입함으로써 같은 데이터를 삽입하면 
		 	같은 주소값을 가진다.
		 2) String 변수명 = new String("데이터");
		 	이 경우에는 공간을 미리 만든다음 데이터를 삽입함으로써
		 	같은 값을 가져도 다른 주소값을 가지는 데이터가 만들어진다.
		 이러한 특성때문에 문자열의 비교는 비교연산자 ==이 아닌 equals() 함수를 사용해야한다.
		*/
		
		// 7번 문제
		Wrapper wp = new Wrapper("8", "12.80");
		wp.typeInt();
		wp.typeDouble();
		
		// 8번 문제
		/*
		 1. promote 
		 	작은 값의 데이터형에서 큰 값의 데이터형으로 변환하는 것
		 	데이터의 유실이 없다. 
		 2. typecasting
		 	큰 값의 데이터형에서 작은 값의 데이터형으로 변환하는 것
		 	데이터의 유실이 생긴다. 
		*/
		
		// 9번문제 
		String name1 = args[0];
		int kor1 = Integer.parseInt(args[1]);
		int eng1 = Integer.parseInt(args[2]);
		int math1 = Integer.parseInt(args[3]);
		int tot1 = kor1 + eng1 + math1;
		
		String name2 = args[4];
		int kor2 = Integer.parseInt(args[5]);
		int eng2 = Integer.parseInt(args[6]);
		int math2 = Integer.parseInt(args[7]);
		int tot2 = kor2 + eng2 + math2;
		
		// 1단계
		System.out.println("** 1단계 출력 **");
		System.out.println(name1 + "\t" + kor1 + "\t" + 
		eng1 + "\t" + math1);
		
		// 2단계
		System.out.println("** 2단계 출력 **");
		System.out.println(name1 + "\t" + kor1 + "\t" + 
				eng1 + "\t" + math1 + "\t" + (tot1) 
				+ "\t" + tot1/3);
		
		// 3단계
		System.out.println("** 3단계 출력 **");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name1 + "\t" + kor1 + "\t" + 
				eng1 + "\t" + math1 + "\t" + (tot1) 
				+ "\t" + tot1/3);
		System.out.println(name2 + "\t" + kor2 + "\t" + 
				eng2 + "\t" + math2 + "\t" + (tot2) 
				+ "\t" + tot2/3);
		System.out.println("\n");
		
		
		// 10번 문제
		int random1 = (int) (Math.random()*3);
		int random2 = (int) (Math.random()*3);	
	
		// 1단계
		System.out.println("# Random 값 #");
		System.out.println("1번팀 " + random1);
		System.out.println("2번팀 " + random2);
		
		// 2단계
		String rps1 = "";
		String rps2 = "";
		
		switch (random1) {
			case 0: {
				rps1 = "가위"; 
				break;}
			case 1: {
				rps1 = "바위"; 
				break;}
			case 2: {
				rps1 = "보"; 
				break;}
		}
		
		switch (random2) {
		case 0: {
			rps2 = "가위"; 
			break;}
		case 1: {
			rps2 = "바위"; 
			break;}
		case 2: {
			rps2 = "보"; 
			break;}
		}
		
		System.out.println("# 가위바위보 무엇을 낼까요? #");
		System.out.println("1번팀 -> " + rps1);
		System.out.println("2번팀 -> " + rps2);
		
		// 3단계
		System.out.println("# 가위바위보 누가 이겼을까요? #");
		if(rps1.equals("가위")) {
			if(rps2.equals("가위")) {
				System.out.println("비겼습니다");
			} else if (rps2.equals("바위")) {
				System.out.println("2번팀이 이겼습니다");
			} else {
				System.out.println("1번팀이 이겼습니다");
			}
		}
		
		if(rps1.equals("바위")) {
			if(rps2.equals("가위")) {
				System.out.println("1번팀이 이겼습니다");
			} else if(rps2.equals("바위")) {
				System.out.println("비겼습니다");
			} else {
				System.out.println("2번팀이 이겼습니다");
			}
		}
		
		if(rps1.equals("보")) {
			if(rps2.equals("가위")) {
				System.out.println("2번팀이 이겼습니다");
			} else if(rps2.equals("바위")) {
				System.out.println("1번팀이 이겼습니다");
			} else {
				System.out.println("비겼습니다");
			}
		}
		
		// 가위 바위 보
		
	}

}

// 2번문제
interface SwimmingWay {
	void swim();
}

class PoolSwimming implements SwimmingWay {
	
	public void swim() {
		System.out.println("수영장\n");
	}
}

class LakeSwimming implements SwimmingWay {
	
	public void swim() {
		System.out.println("연못\n");
	}
}

class SeaSwimming implements SwimmingWay {
	
	public void swim() {
		System.out.println("바다\n");
	}
}

// 3번 문제
class Duck {
	public SwimmingWay sway;
	
	public void setswim(SwimmingWay s) {
		this.sway = s;
	}
	
	public void swim() {
		System.out.println("**오리가 헤엄을 치는 곳은 **");
		if (sway != null) {
			sway.swim();
		} else {
			System.out.println("헤엄치지않아요 \n");
		}
	}
}

// 7번 문제
class Wrapper {
	String intData;
	String douData;
	
	public Wrapper(String i, String x) {
		this.intData = i;
		this.douData = x;
	}
	
	public int typeInt() {
		int a = Integer.parseInt(intData);
		return a;
	}
	
	public double typeDouble() {
		double b = Double.parseDouble(douData);
		return b;
	}
}