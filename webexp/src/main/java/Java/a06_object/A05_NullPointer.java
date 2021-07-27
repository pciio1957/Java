package Java.a06_object;

import Java.a06_object.vo.Person;

public class A05_NullPointer {

	
	/*
	
	#자바의 데이터타입
	1. 자바의 변수는 크게 두가지로 나뉜다
		1) 기본 타입(primitive type) 
			정수, 실수, boolean
			stack영역에 선언과 할당한다
		2) 참조 타입(reference type)
			객체형
			heap영역에 할당되어 있고, heap영역의 주소값을 stack에 저장한다.
			
			= javaexp.a05_object.vo.Person@5305068a 
			클래스명@16진수heap영역의 주소값으로 나타난다.
			
	2. null이란
		1) 객체를 선언만 하고 heap영역에 생성이 되지 않을 떄 null, 
			즉 heap영역에 아무것도 없다는 뜻으로 사용된다.
		2) heap영역에 없는 객체의 속성을 호출하면 NullPointerException이 발생함
		3) 일반적으로 해당 데이터가 생성되었을 때 처리하기 위해서 객체 변수는 if(변수명!=null)을 이용해 
			check한 후 속성을 사용하는 방법을 쓴다.
	
	3. 비교연산자 처리
		1) 비교연산자(==, != 등)는 stack영역의 할당된 데이터를 비교하여
			boolean값을 리턴한다.
		2) 기본 primitive 데이터 : 할당된 데이터값 비교
		3) 객체형 참조변수 : heap영역의 주소값 비교
			- if(참조변수 != null) : 객체가 할당된 경우를 의미
		4) String : 문자열 할당
			String str1 = "홍길동";
			String str2 = "홍길동";
			동일한 문자열은 동일한 heap영역에 할당된 경우를 말한다.
			
			str1 == str2 -> true  : 객체 생성 할당
			
			String str3 = new String("홍길동");
			String str4 = new String("홍길동");
			일반적으로 외부 입력 Scanner나 Stream(네트워크, 파일처리)을 통해서 
			처리된 경우는 내부적으로 객체가 생성되어 처리된다.
			
			str3 == str4 -> false : 같은 주소값이 아니다 
			----> 그렇기때문에 문자열을 비교할때 str3.equals(str4)를 사용한다.
	
			
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 실습
		int num01 = 25;
		Person p01 = new Person();
		System.out.println("스택 영역의 데이터(primitive) : " + num01);
		System.out.println("스택 영역의 데이터(Object) : " + p01);
		
		Person p02 = null;
		System.out.println("heap 영역에 할당되지 않는 obejct : " + p02);
		//System.out.println(p02.age);
		
		// 속성이 있는지 확인하기 위한 조건문
		// p01은 객체가 있고, p02는 객체가 없음
		if(p01!=null) {
			System.out.println("p01 객체가 생성되었습니다");
		} else {
			System.out.println("p01 객체가 생성되지 않았습니다");
		}
		
		if(p02!=null) {
			System.out.println("p02 객체가 생성되었습니다");
		} else {
			System.out.println("p02 객체가 생성되지 않았습니다");
		}
		
		
		
		
		
		
		
	}

}
