package Java.a01_exp.month05;

public class A14_0525ans {
	

	/*
	
	#마무리문제
	1. static, final, static final 각각의 차이점을 기본예제를 통해서 기술하기
		static : 객체 공유 메모리 영역으로 즉 클래스 단위 멤버를 설정할 때 활용된다
		final : 필드에서는 상수선언으로 객체마다 하나의 상수를 초기 선언하면 변경이 불가능하다.
		static final : 클래스 단위 멤버이면서 변경이 불가능하게 처리할 때 활용된다.
					class에서 바로 할당하는 경우가 많다.
		
		main() {
		// 메인에서 객체를 생성하기 전에 초기화해준다. 
		Bear.TOT_BREAD_CNT = 30;
		}
		
		class Bear {
			private int eat_cnt; 
			// 이 클래스로부터 생성되는 모든 Bear 객체가 공유 메모리 영역 남은 빵의 갯수 
			public static int TOT_BREAD_CNT; 
			final String NAME; // final 상수
			// 해당 클래스에 매핑되어 변경되지않는 경우에 사용
			static final String KIND = "곰돌이";
			
			Bear(String name) {
				// 객체마다 초기로 선언하여 변경이 불가능하게 할 때 사용
				this.NAME = name;
			}
			public void eat() {
				// 각 객체마다 해당 변수를 변경 처리
				eat_cnt++; 
				// 객체의 공유 데이터 변경 처리 
				TOT_BREAD_CNT--; 
			}
		}	
	
	2. Robot 클래스를 정의할 때 "기계로봇", 로봇의 종류, 로봇의 공유 전력 남은양,
		처리할 기능을 필드로 선언하여, 해당 내용을 활용하는 부분을 위 문제에 선언한 keyword의 
		기능에 맞게 처리하세요 (생성자, 메소드, 필드 선언을 적절하게 하세요)
		
		
	3. 접근제어자의 범위를 기술하고 클래스명 앞에 붙는 접근 제어자와 생성자 앞에 붙는
		접근제어자가 main()에서 어떻게 영향을 미치는지 예제를 통해 기술하기
		
		 (오늘 설명을 한번 더 해주신다고 하심)
		 접근제어자
		 	private : 클래스 내에서만 사용할 수 있는 범위로 지정
		 			객체로 만들어질 때 외부 클래스나 main()에서 직접적인 접근을 하지못하게 선언할 때 사용한다. 
		 			public get@@@(), public set@@@()식으로 간접적으로 접근 가능하다.
		 	default(x) : 기본적으로 접근제어자가 붙어있지 않는 멤버는 같은 패키지의 클래스들만 접근하여 사용할 수 있다. 
						ex) 클래스 선언 최상단에 선언되어있는 패키지가 동일할 때 사용가능
			protected : 전제조건으로 상속관계가 선언되어있다면 외부 패키지의 클래스가 접근하여 사용할 수 있게 선언한다.
			public : 외부패키지에서 어떠한 클래스가 접근해도 호출이 가능하게 처리하는 것을 말한다.
			
			현재 패키지에 클래스를 z01_vo > Person을 만듬 
			
			디폴트 생성자의 경우 클래스를 생성했을때 눈에 안보이지만 선언이 되어있는것임
			class Person { public Person() {} ) 
			이렇게 안에 안보이게 선언되어있는 것 표현한다면 저렇게 써져있음
			
			1. 외부패키지에서 선언할 클래스를 호출 / 접근제어자 class Person{} 이 부분을 선언한 것
			최상단패키지명.Person p1; // 패키지가 겹쳐서 제대로 확인이 안되므로 패키지명도 작성함
			// 현재 패키지의 클래스와 같은 이름의 클래스를 호출할 때 패키지명과 함께 선언한다.
			
			2. 생성자 호출
			p1 = new 최상단패키지명.Person();
			
			패키지명은 계층구조와 상관없이 동일한 이름으로 선언되어야지 같은 패키지이다.
			패키지명은 종속관계로 선언되지 않는다.
			
			같은 패키지일지라도 접근제어자 private는 접근불가
			패키지범위로 접근하는 멤버는 그 이상의 protected, default? 
			
			외부 패키지에 있을때는 public만 접근이 가능하다
			
		
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// staic 변수는 객체 생성없이 사용가능, 변수이름은 관례로 대문자로 사용
		Robot50.REST_POWER = 3000;
		Robot50 robo1 = new Robot50("비행");
		robo1.working(10);
		robo1.attack(100);
		System.out.println(robo1.getKIND() + " 현재 상태 : " + robo1.getCurrenFunction());
		
		Robot50 robo2 = new Robot50("청소");
		robo2.attack(50);
		robo2.working(5);
		System.out.println(robo2.getKIND() + " 현재 상태 : " + robo2.getCurrenFunction());
		System.out.println("현재 남은 전력량 : " + Robot50.REST_POWER);
	}

}
class Robot50 {
		public static int REST_POWER; // 공유 전력 남은양
		private final String KIND; // 로봇의 종류로 변경되지 않도록 처리
		private static final String ROBOT_CLASSES = "기계로봇"; // 클래스 단위 상수 설정
		private String currenFunction; // 각 로봇이 현재하고 있는 기능 표시
		
		Robot50(String k) {
			this.KIND = k;
		}
		
		public void working(int usingpower) {
			currenFunction = "일을 하고 있다!";
			System.out.println(ROBOT_CLASSES + "분류로 되어 있는 " + KIND 
						+ "로봇이 " + currenFunction);
			System.out.println("소모 전력 : " + usingpower);
			REST_POWER -= usingpower;
			System.out.println("남은 전력 : " + REST_POWER);
		}
		
		public void attack(int usingpower) {
			currenFunction = "공격을 하고 있다!";
			System.out.println(ROBOT_CLASSES + "분류로 되어 있는 " + KIND 
						+ "로봇이 " + currenFunction);
			System.out.println("소모 전력 : " + usingpower);
			REST_POWER -= usingpower;
			System.out.println("남은 전력 : " + REST_POWER);
		}

		// 직접적이지않지만 값을 설정하고 가져올 수 있음
		public String getCurrenFunction() {
			return currenFunction;
		}

		public void setCurrenFunction(String currenFunction) {
			this.currenFunction = currenFunction;
		}

		// final 상수라서 변경이 불가능함 그래서 set메소드가 안생김
		public String getKIND() {
			return KIND;
		}
		
		
}
