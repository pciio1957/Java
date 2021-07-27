package Java.a06_object;

public class Z01_Person {
	// 접근제어자에 따른 처리가 어떻게 되는지 확인하기 위한 전역변수 선언
	private String name = "홍길동";
	String address = "서울시 강남구 대치동";
	protected String ingerit = "고향에 있는 상속할 땅";
	public String announce = "우리 5/25에 결혼해요";
	
	public void call() {
		// 같은 클래스내에서는 필드(위의 인스턴스변수)에 선언한 데이터에 접근 가능
		System.out.println(name);
		System.out.println(address);
		System.out.println(ingerit);
		System.out.println(announce);
		
	}

}
