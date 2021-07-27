package Java.z02_project;

// 중재역할
// 화면단에서 받은 데이터를 매개변수(Member m)로 받아서
// 다시 화면단에 넘겨준 데이터를 Model d로 선언하여 처리한다.

// id : []
// pass : []
// [로그인]
// 기능메소드 선언(입력할 데이터처리, 모델객체(실제 출력은 x))
public class A01_MemberController {
	// dao 호출
	private C01_MemberDao dao = new C01_MemberDao();
	
	// Member는 입력데이터(입력받), Model은 출력데이터(화면에 출력)
	public String login(Member m, Model d) {
		// id, pass가 담긴 Member를 받는다.
		// 넘겨온 id와 pass를 dao로 처리해서
		// 최종 결과를 model로 화면에 넘겨준다
		// 앞의 DAo에서 보낸걸 여기서 받아서 다시 model로..? 
		d.addAttribute("로그인결과", dao.login(m));
		
		return "호출할 화면";
	}
	
	
	// 회원가입
	// id, pass, name, email, auth, point 받아야함
	public String regMember(Member insert, Model d) {
		
		// 회원가입시 입력한 데이터는 insert에 담겨있음
		// dao.호출을 통해서 데이터를 입력함
		System.out.println("# controller 처리");
		// model을 통해서 화면에 출력할 회원가입 성공/실패를 설정
		d.addAttribute("result", dao.insert(insert));
		System.out.println("최종 결과 : " + dao.insert(insert));
		
		return "화면 호출";
	}
}
