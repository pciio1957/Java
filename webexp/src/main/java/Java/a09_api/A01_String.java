package Java.a09_api;

public class A01_String {
	

	/*
	
	# String
	1. 문자열을 처리하는 객체
	2. 선언 방식
		String 변수명 = "문자열 데이터";
		String 변수명 = new String("문자열데이터");
	3. 객체이기 떄문에 heap 메모리 주소에 할당
		1) 첫번째 방식은 문자열만 같으면 같은 주소에 할당된다.
			String name1 = "홍길동";
			String name2 = "홍길동";
			String name3 = "홍길동";
			"홍길동" 이라는 문자열은 heap 영역에 동일한 주소를 참조해 설정한다
			-> 직접 코딩에 의해서 할당이 되어 사용가능하다. 
			- name1 == name2는 동일한 주소값이기 때문에 동일한 true로 처리된다
		2) 두번째 방식은 문자열이 각각 다른 주소를 만들어서
			문자열의 데이터를 가지고 온다.
			String name4 = new String("홍길동");
			String name5 = new String("홍길동");
			String name6 = new String("홍길동");
			- name4 == name5 다른 주소를 가지고 있기때문에 주소값이 다르게 처리된다. 
			false로 처리된다.
		일반적으로 DB에서 불러오거나, network을 통해서 가져오거나,
		파일을 통해서 가져오는 데이터는 모두 다 내부적으로 해당 방식(2번째방법)으로 가져온다.
		
		=> 그렇기 때문에 문자열의 비교를 할때는 == 비교연산자를 사용하는 것이 아니라
		equals() 라는 함수를 사용해줘야한다 
			
	 
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name1 = "홍길동";
		String name2 = "홍길동";
		
		String name4 = new String("홍길동");
		String name5 = new String("홍길동");
		
		System.out.println(name1 == name2); // true 출력, 같은 주소값을 가짐
		System.out.println(name4 == name5); // false 출력, 다른 주소값을 가짐
		// 문자열만 비교해서 데이터를 처리할 때는 ==와 같은 stack영역의
		// 데이터비교 방식은 문제가 발생한다.
		// -> 문자열을 비교할때는 == 를 쓰면 안된다 (equals() 사용)
		// ** 그렇기때문에 문자열의 데이터를 비교할 때는 stack영역의 주소값이
		// 아닌 문자열 자체를 비교해주는 .equals() 메소드를 활용한다
		System.out.println(name4.equals(name5)); // true 출력
		
		System.out.println(name4.equals(name5));
		// 오른쪽마우스 -> run as -> run 속성 -> arguments에 홍길동 홍길동 작성
		String name6 = args[0]; // 홍길동, arguments에 적은 첫번째 값
		String name7 = args[1]; // 홍길동, arguments에 적은 두번째 값
		System.out.println(name6 == name7); // false 나옴 이렇게 사용하면 X
		System.out.println(name6.equals(name7)); // true 나옴, 제대로 결과!
		
		// 응용1) himan일때, 등록된 아이디입니다 표시
		//       그 외에는 등록가능한 아이디입니다 표시
		// 응용2) args에 로그인 id와 pass를 입력하고
		//		"himan" / "7777" 일때만 로그인 성공, 그외에는 로그인 실패로 출력
		
		// 응용 풀이
		String id = "himan";
		String pass = "7777";
		
		if(id.equals(args[0]) && pass.equals(args[1])) {
			System.out.println("**로그인 성공**");
		} else if(id.equals(args[0])) {
			//System.out.println("로그인 실패 ㅠㅠ");
			System.out.println("등록된 아이디입니다.");
		} else {
			System.out.println("로그인 실패 ㅠㅠ");
		}
		
		// 강사님 응용문제 풀이는 새로운 클래스 A02_StringExp에서 하심
		
		
	}

}
