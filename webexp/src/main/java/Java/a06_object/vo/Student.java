package Java.a06_object.vo;

// VO (value object) : 가치를 가지고 있는 오브젝트? 라는 말로 클래스를 선언하고 
//					외부/내부 패키지에 접근하여 데이터로 사용할 때 활용한다.

public class Student {
	// 1. 필드 : 일반적으로 private로 선언한다.
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	// 2. 생성자 : 매개변수가 없는 생성자로 선언할지
	//			필요한 초기값이 있는 생성자로 선언할지 내가 사용할 데이터를 잘 확인하고 선언~!!
	public Student() {
		super();
	}

	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// 3. 간접적으로 필드를 접근할 수 있게 set@@@(), get@@@() 선언해서 사용
	//		해당 메소드들을 이용해서 값을 설정하거나 가져와서 사용하는 방식으로 한다.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
	// 4. 추가적인 기능 메소드 선언
	// 	set, get 이외의 필요한 메소드가 있다면 필요기능에 맞게 잘 선언해서 사용한다.
	// 	Source에 있는 메소드 
	// 		1) toString() : 객체를 생성해서 참조변수만 호출했을 때 default로 나타날 리턴값을 선언한다.
	//				ex) Student st1 = new Student();
	//					System.out.println(st1);   
	//					default로 참조변수.주소값이 나오는데 toString()을 만들어놓으면 아래 리턴값에 맞는 값이 전달됨. 
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	

	
	public static void main(String args[]) {
		
		// 응용) Product2.java로 선언하여 물건명, 가격, 갯수를 필드로 처리하고
		// 		toString()에는 해당 필드와 총계까지 리턴하여 선언되게 하고
		//		참조변수로 해당 내용을 출력해보기(6조)
		
		Product200 pro1 = new Product200("두유", 1200, 3);
		Product200 pro2 = new Product200("우유", 3000, 5);
		Product200 pro3 = new Product200("물", 500, 6);
		
		System.out.println(pro1.toString());
		System.out.println(pro2.toString());
		System.out.println(pro3.toString());
		
	}
	
	
	
}
