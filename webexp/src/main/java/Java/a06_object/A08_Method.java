package Java.a06_object;

public class A08_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object01 ob1 = new Object01();
		String st1 = ob1.returnExp();
		String st2 = ob1.returnExp();
		String st3 = ob1.returnExp();
		
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		
		Object01 ob2 = new Object01();
		System.out.println(ob2.returnExp1());
		System.out.println(ob2.returnExp2());
		System.out.println(ob2.returnExp3());
		System.out.println(ob2.returnExp4());
		System.out.println(ob2.returnExp5());
		
		// 배열을 리턴해오는 메소드들 출력이 잘 못되서 확인을 못한 것,,
		System.out.println(ob2.returnExp6());
		System.out.println(ob2.returnExp7());
		
		// 배열이 리턴되므로 배열에 해당하는 데이터 type으로 할당하여 사용해야함
		int[] chA = ob2.returnExp6();
		System.out.println(chA[0]);
		
		
		
	}

}

class Object01 {
	
	// 리턴할 유형을 선언, 메소드명() { return 리턴할 실제데이터; }
	String returnExp() {
		return "안녕하세요";	
	}
	
	String returnExp1() {
		return "반갑습니다";	
	}
	
	char returnExp2() {
		return 'A';	
	}
	
	int returnExp3() {
		return 3000;	
	}
	
	double returnExp4() {
		return 25.2+30.7;	
	}
	
	boolean returnExp5() {
		return false;	
	}
	
	// 못 푼 문제 
	// 1) 리턴값이 {2,3,4} 인 경우 배열을 선언해서 그 자체를 보냄
	int[] returnExp6() {
		int[] a = {2,3,4};
		return a;	
		// 이렇게 해서 보냈을때는 주소값이 나와서 ?,, 안된다고 생각함
	}
	
	// 2) 리턴값이 {2,3,4} 인 경우 새로 배열을 만들면서 보냄
	int[] returnExp7() { 
		int[] a = {2,3,4};
		return new int[] {2,3,4};	
	}
	
}
