package Java.a09_api;



public class A08_Enum {

	/*
	
	# 열거형 상수 enum
		상수를 효과적으로 열거형으로 사용할 때 쓰이는 데이터 유형 
	1. 선언
		public enum 객체의 이름명 { 사용할 상수1, 상수2, 상수3 .. }
	2. 열거형 상수의 속성/메소드
		.value() : 배열로 상수 전체를 가져온다.
		.name() : 이름
		.ordinal() : enum의 포함되어 있는 순서 index값
	 
	*/
	
	
	public enum Colorss {RED, BLACK, YELLOW, BLUE};
	
	
	public enum Flowers {ROSE, PANSY, PEONY};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// enum 호출 및 활용
		Colorss color = Colorss.BLACK;
		System.out.println(color);
		Colorss[] cs = Colorss.values(); // values()를 통해서 배열로 데이터를 가져옴
		// for(단위객체 : 배열형데이터)
		for(Colorss x:cs) {
			System.out.println(x.name() + "\t" + x.ordinal());
		}
		
		Flowers[] fl = Flowers.values();
		for(Flowers f: fl) {
			System.out.println(f.ordinal() +1+"번째 꽃은 "+f.name());
		}
		
		
	}

}
