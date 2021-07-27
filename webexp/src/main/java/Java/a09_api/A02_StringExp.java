package Java.a09_api;

public class A02_StringExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 응용1) himan일때, 등록된 아이디입니다 표시
		//       그 외에는 등록가능한 아이디입니다 표시
		// 응용2) args에 로그인 id와 pass를 입력하고
		//		"himan" / "7777" 일때만 로그인 성공, 그외에는 로그인 실패로 출력
				
		// 응용 풀이
		String id = "himan";
		String pass = "7777";
			
		// main 함수의 args에 로그인성공값을 넣었기때문에 args[0]식으로 사용
		if(id.equals(args[0]) && pass.equals(args[1])) {
			System.out.println("**로그인 성공**");
		} else if(id.equals(args[0])) {
			//System.out.println("로그인 실패 ㅠㅠ");
			System.out.println("등록된 아이디입니다.");
		} else {
			System.out.println("로그인 실패 ㅠㅠ");
		}
		
		// 강사님 풀이1
		String id2 = args[0];
		String pass2 = args[1];
		
		if(id.equals("himan")) {
			System.out.println("등록된 아이디입니다.");
		} else {
			System.out.println("해당 아이디로 등록가능합니다");
		}
		
		// 강사님 풀이2
		if(id.equals("himan") && pass.equals("7777")) { // 둘다 true 일떄2
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}

}
